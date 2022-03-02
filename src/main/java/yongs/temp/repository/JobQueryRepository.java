package yongs.temp.repository;

import static yongs.temp.model.QJobExecution.jobExecution;
import static yongs.temp.model.QJobInstance.jobInstance;
import static yongs.temp.model.QJobParams.jobParams;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import yongs.temp.dto.Distribution;
import yongs.temp.dto.Job;
import yongs.temp.model.JobExecution;
import yongs.temp.model.JobInstance;

@RequiredArgsConstructor
@Repository
public class JobQueryRepository {
	private final JPAQueryFactory queryFactory;

	public JobInstance findById(Long id) {
        return queryFactory
                .selectFrom(jobInstance)
                .where(jobInstance.id.eq(id))
                .fetchOne();
    }
	
	public List<JobInstance> findByName(String name) {
        return queryFactory
                .selectFrom(jobInstance)
                .where(jobInstance.name.eq(name))
                .fetch();
    }

	public Page<Job> findAll(Pageable pageable) {
		QueryResults<Job> result = queryFactory
				 .select(Projections.fields(Job.class, 
						jobInstance.id.as("instanceId"),
						jobInstance.name.as("name")
				 ))
				.from(jobInstance)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(jobInstance.id.desc())
				.fetchResults();
		
		return new PageImpl<>(result.getResults(), pageable, result.getTotal());
	}

	public List<Job> findByNameNoOffset(Long instanceId, String name, int pageSize) {
		// BooleanBuilder dynamicLtId = new BooleanBuilder();
		// if(instanceId != null) dynamicLtId.and(jobInstance.id.lt(instanceId));
		
		return queryFactory
				 .select(Projections.fields(Job.class, 
						jobInstance.id.as("instanceId"),
						jobInstance.name.as("name")
				 ))
				.from(jobInstance)
				.where(
						ltInstanceId(instanceId),
						jobInstance.name.like(name + "%"))
				.orderBy(jobInstance.id.desc())				
				.limit(pageSize)
				.fetch();
	}	
	// 1. instanceId <(Less Than) 파라미터를 첫 페이지에선 사용하지 않기 위한 동적 쿼리
	// 첫 페이지를 조회할때는 book.id.lt(bookId) 가 조건문에 없어야 하며,
	// 번째 페이지부터는 book.id.lt(bookId)가 조건문에 들어가야 합니다	
	private BooleanExpression ltInstanceId(Long instanceId) {
	    if (instanceId == null) {
	        return null; // BooleanExpression 자리에 null이 반환되면 조건문에서 자동으로 제거된다
	    }
	    return jobInstance.id.lt(instanceId);
	}
	
	public List<JobExecution> findExecutionByInstanceId(Long instanceId) {
		return queryFactory
				.selectFrom(jobExecution)
				.where(jobExecution.instanceId.eq(instanceId))
				.fetch();
	}
	
	public Map<String, String> findParamsByExcutionId(Long executionId) {
		Map<String, String> map = new HashMap<>();
		List<Tuple> params = queryFactory
				.select(jobParams.keyName, jobParams.stringVal)
				.from(jobParams)
				.where(jobParams.id.eq(executionId))
				.fetch();
		
		for(Tuple param: params) {
			map.put(param.get(jobParams.keyName), param.get(jobParams.stringVal));	
		}
	
        return map;
    }
	@Transactional
	public long updateExecutionStatusAndExitCodeByExecutionId(Long executionId, String status, String exitCode) {
		return queryFactory
				.update(jobExecution)
				.set(jobExecution.endTime, LocalDateTime.now())
				.set(jobExecution.status, status)
				.set(jobExecution.exitCode, exitCode)
				.where(jobExecution.id.eq(executionId))
				.execute();
	}
	public List<Distribution> getNumOfExecutionsByHourSum(LocalDate from, LocalDate to) {
		StringTemplate keyTime = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%H"));
		StringTemplate whereDate = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%Y-%m-%d"));
		
		List<Tuple> list = queryFactory
				.select(keyTime, jobExecution.id.count())
				.from(jobExecution)
				.where(whereDate.between(from.toString(), to.toString()))
				.groupBy(keyTime)
				.orderBy(keyTime.desc())
				.fetch();	
		
		List<Distribution> returnValue = new ArrayList<>();
		for(Tuple num: list) {
			Distribution distribution = new Distribution((String)num.get(keyTime), num.get(jobExecution.id.count()));
			returnValue.add(distribution);
		}
		return returnValue;
	}
	public List<Distribution> getNumOfExecutionsByMinuteSum(String target, LocalDate from, LocalDate to) {
		// DATE_FORMAT(A.START_TIME, '%i')
		StringTemplate keyMinute = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%i"));
		// DATE_FORMAT(BATCH_JOB_EXECUTION.START_TIME, '%H')
		StringTemplate keyTime = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%H"));
		StringTemplate whereDate = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%Y-%m-%d"));
		
		List<Tuple> list = queryFactory
				.select(keyMinute, jobExecution.id.count())
				.from(jobExecution)
				.where(
						whereDate.between(from.toString(), to.toString()),
						keyTime.eq(target)
				)
				.groupBy(keyMinute)
				.fetch();	
		
		List<Distribution> returnValue = new ArrayList<>();
		for(Tuple num: list) {
			Distribution distribution = new Distribution((String)num.get(keyMinute), num.get(jobExecution.id.count()));
			returnValue.add(distribution);
		}
		return returnValue;
	}
	
	public List<Distribution> getJobNamesBySelectedMinute(String target, LocalDate from, LocalDate to) {
		// DATE_FORMAT(A.START_TIME, '%i')
		StringTemplate keyMinute = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%i"));
		StringTemplate whereDate = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%Y-%m-%d"));
		
		List<Tuple> list = queryFactory
				.select(jobInstance.name, jobExecution.id.count())
				.from(jobInstance)
				.join(jobExecution).on(jobInstance.id.eq(jobExecution.instanceId))
				.where(
						whereDate.between(from.toString(), to.toString()),
						keyMinute.eq(target)
				)
				.groupBy(jobInstance.name)
				.fetch();		
		
		List<Distribution> returnValue = new ArrayList<>();
		for(Tuple num: list) {
			Distribution distribution = new Distribution(num.get(jobInstance.name), num.get(jobExecution.id.count()));
			returnValue.add(distribution);
		}
		return returnValue;
	}
	/*
	public List<Distribution> getNumOfExecutionsByDate(LocalDate from, LocalDate to) {
		StringTemplate keyDate = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%m/%d"));
		StringTemplate whereDate = Expressions.stringTemplate(
				"DATE_FORMAT({0}, {1})", jobExecution.startTime, ConstantImpl.create("%Y-%m-%d"));
		
		List<Tuple> list = queryFactory
				.select(keyDate, jobExecution.id.count())
				.from(jobExecution)
				.where(whereDate.between(from.toString(), to.toString()))
				.groupBy(keyDate)
				.orderBy(keyDate.desc())
				.fetch();	
		
		List<Distribution> returnValue = new ArrayList<>();
		for(Tuple num: list) {
			Distribution distribution = new Distribution((String)num.get(keyDate), num.get(jobExecution.id.count()));
			returnValue.add(distribution);
		}
		return returnValue;
	}
	*/
	
	/*
	 * SQL 중심 querydsl
	 * 
	public Page<Job> findAll(Pageable pageable) {
		QueryResults<Job> result = queryFactory
				.select(Projections.fields(Job.class, 
						jobExecution.id.as("id"),
						jobInstance.name.as("name"),
						jobExecution.startTime.as("stime"),
						jobExecution.endTime.as("etime"),
						jobExecution.status.as("status")
				 ))
				.from(jobInstance)
				.join(jobExecution).on(jobInstance.id.eq(jobExecution.instanceId))
				.leftJoin(jobParams).on(jobExecution.id.eq(jobParams.id))
				.where(jobExecution.exitCode.ne("NOOP"))
				.groupBy(jobExecution.id)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(jobInstance.id.desc())
				.fetchResults();
		
		return new PageImpl<>(result.getResults(), pageable, result.getTotal());
	} */
	
}
