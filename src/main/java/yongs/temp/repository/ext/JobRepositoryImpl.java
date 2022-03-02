package yongs.temp.repository.ext;

import static yongs.temp.model.QJobInstance.jobInstance;

import java.util.List;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import yongs.temp.model.JobInstance;

@RequiredArgsConstructor
public class JobRepositoryImpl implements JobRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public List<JobInstance> findByName(String name) {
        return queryFactory
                .selectFrom(jobInstance)
                .where(jobInstance.name.eq(name))
                .fetch();
    }
}
