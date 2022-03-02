package yongs.temp.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.dto.Job;
import yongs.temp.model.JobExecution;
import yongs.temp.model.StepExecution;
import yongs.temp.repository.JobQueryRepository;
import yongs.temp.repository.StepQueryRepository;

@Service
public class HistoryService {
	@Autowired
	private JobQueryRepository jobQueryRepo;
	@Autowired
	private StepQueryRepository stepQueryRepo;
	
	public List<Job> findHistotyByInstanceId(Long instanceId) {
		List<Job> history = new ArrayList<>();
		// 실행 Job 목록 조회
		List<JobExecution> executionList = jobQueryRepo.findExecutionByInstanceId(instanceId);
		executionList.forEach(execution -> {
			Job job = new Job();
			job.setExecution(execution);
			
			// 종료시간이 있는경우에만 시간차를 구할 수 있다.
			if(null != execution.getEndTime())
				job.setElapsed(Duration.between(execution.getStartTime(), execution.getEndTime()).getSeconds());
			
			List<StepExecution> stepList = stepQueryRepo.findByExecutionId(execution.getId());
			stepList.forEach(step -> {
				// 종료시간이 있는경우에만 시간차를 구할 수 있다.
				if(null != step.getEtime())
					step.setElapsed(Duration.between(step.getStime(), step.getEtime()).getSeconds());
			});
			
			job.setStepList(stepQueryRepo.findByExecutionId(execution.getId()));
			history.add(job);
		});
		
		return history;

	}
}
