 package yongs.temp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.model.StepExecution;
import yongs.temp.repository.StepQueryRepository;

@Service
public class StepService {
	@Autowired
	private StepQueryRepository stepQueryRepo;
	
	public List<StepExecution> findByExecutionId(long executionId) {		
		return stepQueryRepo.findByExecutionId(executionId);
	}
	
	public long setRemovedStepStatus(long executionId, String exitMessage) {
		return stepQueryRepo.updateStepStatusAndExitCodeByExecutionId(executionId, "COMPLETED", "REMOVED", exitMessage);		
	}
}
