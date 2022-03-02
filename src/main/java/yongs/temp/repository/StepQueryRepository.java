package yongs.temp.repository;

import static yongs.temp.model.QStepExecution.stepExecution;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import yongs.temp.model.StepExecution;

@RequiredArgsConstructor
@Repository
public class StepQueryRepository {
	private final JPAQueryFactory queryFactory;

	public List<StepExecution> findByExecutionId(Long executionId) {
        return queryFactory
                .selectFrom(stepExecution)
                .where(stepExecution.executionId.eq(executionId))
                .fetch();
    }
	
	@Transactional
	public long updateStepStatusAndExitCodeByExecutionId(Long executionId, String status, String exitCode, String exitMessage) {
		return queryFactory
				.update(stepExecution)
				.set(stepExecution.etime, LocalDateTime.now())
				.set(stepExecution.status, status)
				.set(stepExecution.exitCode, exitCode)
				.set(stepExecution.exitMessage, exitMessage)
				.where(
						stepExecution.executionId.eq(executionId),
						stepExecution.exitCode.ne("COMPLETED"))
				.execute();
	}
}
