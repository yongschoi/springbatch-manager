package yongs.temp.repository.ext;
import static yongs.temp.model.QJobInstance.jobInstance;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import yongs.temp.model.JobInstance;

@Repository
public class JobRepositorySupport extends QuerydslRepositorySupport {
	private final JPAQueryFactory queryFactory;
	
	public JobRepositorySupport(JPAQueryFactory queryFactory) {
        super(JobInstance.class);
        this.queryFactory = queryFactory;
    }
	
	public List<JobInstance> findByName(String name) {
        return queryFactory
                .selectFrom(jobInstance)
                .where(jobInstance.name.eq(name))
                .fetch();
    }

}
