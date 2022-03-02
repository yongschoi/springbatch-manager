 package yongs.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import yongs.temp.dto.Job;
import yongs.temp.model.JobExecution;
import yongs.temp.repository.JobQueryRepository;

@Service
public class JobService {
	@Autowired
	private JobQueryRepository jobQueryRepo;
	
	public Page<Job> findAll(Pageable pageable) {
		Page<Job> jobPage = jobQueryRepo.findAll(pageable);
		
		jobPage.forEach(job -> {
			// 성공한 ExecutionJob을 셋팅(성공한 Job이 없으면 아무거나 셋팅)
			JobExecution execution = findCompletedOrAnyJobByInstanceId(job.getInstanceId());		
			job.setInstanceId(execution.getInstanceId());
			job.setExecution(execution);
		
			// 셋팅된 ExecutionJob의 parameter를 셋팅
			job.setParams(jobQueryRepo.findParamsByExcutionId(execution.getId()));
		});

		return jobPage;
	}

	public List<Job> findByNameNoOffset(Long instanceId, String name, int pageSize) {
		List<Job> jobList = jobQueryRepo.findByNameNoOffset(instanceId, name, pageSize);
		jobList.forEach(job -> {
			// 성공한 ExecutionJob을 셋팅(성공한 Job이 없으면 아무거나 셋팅)
			JobExecution execution = findCompletedOrAnyJobByInstanceId(job.getInstanceId());
			job.setInstanceId(execution.getInstanceId());
			job.setExecution(execution);

			// 셋팅된 ExecutionJob의 parameter를 셋팅
			job.setParams(jobQueryRepo.findParamsByExcutionId(execution.getId()));
		});

		return jobList;
	}
	
	public JobExecution findCompletedOrAnyJobByInstanceId(Long instanceId) {
		JobExecution returnJe = null;
		List<JobExecution> jobExecutionList = jobQueryRepo.findExecutionByInstanceId(instanceId);
		for(JobExecution je : jobExecutionList) {
			// EXIT_CODE가 COMPLETED한것을 Completed Execution Job으로 정의
			if(je.getExitCode().equals("COMPLETED")) {
				returnJe = je;
				break;
			}
			else returnJe = je;
		}
		return returnJe;
	}
	
	public long setRemovedJobStatus(long executionId) {
		return jobQueryRepo.updateExecutionStatusAndExitCodeByExecutionId(executionId, "COMPLETED", "REMOVED");
	}
}
