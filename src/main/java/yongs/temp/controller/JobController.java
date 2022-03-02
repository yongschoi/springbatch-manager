package yongs.temp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yongs.temp.dto.Distribution;
import yongs.temp.dto.Job;
import yongs.temp.model.StepExecution;
import yongs.temp.service.DistributionService;
import yongs.temp.service.HistoryService;
import yongs.temp.service.JobService;
import yongs.temp.service.StepService;

@RequestMapping("/job")
@RestController
public class JobController {
	@Autowired
	private JobService jobService;
	@Autowired
	private StepService stepService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private DistributionService distributionService;
	
	
	@GetMapping("/all")
	public Page<Job> findAll(final @RequestParam(name = "page", defaultValue = "0") int page,
			  				 final @RequestParam(name = "size", defaultValue = "5") int size) {
		// return Page
		return jobService.findAll(PageRequest.of(page, size));
    }
	
	@GetMapping("/name")
	public List<Job> findByNameNoOffset(final @RequestParam(name = "instanceId") Long instanceId,
			  				 			final @RequestParam(name = "name") String name,
			  				 			final @RequestParam(name = "pageSize") int pageSize) {
		// return List
		return jobService.findByNameNoOffset(instanceId, name, pageSize);
    }
	
	@GetMapping("/executionId/{executionId}")
	public List<StepExecution> findByExecutionId(@PathVariable("executionId") Long executionId) {
		return stepService.findByExecutionId(executionId);
    }
	
	@PutMapping("/setRemovedJob")
	public void setRemovedJobStatus(@RequestParam(name = "executionId") long executionId,
									@RequestParam(name = "exitMessage") String exitMessage) {
		jobService.setRemovedJobStatus(executionId);
		stepService.setRemovedStepStatus(executionId, exitMessage);
    }

	@GetMapping("/history/{instanceId}")
	public List<Job> findHistotyByInstanceId(@PathVariable("instanceId") Long instanceId) {
		return historyService.findHistotyByInstanceId(instanceId);
    }
	
	@GetMapping("/distribution")
	public List<Distribution> getDistribution() {
		return distributionService.getNumOfExecutionsByHour();
    }
	
	@GetMapping("/distribution/{target}")
	public List<Distribution> getDistributionByTarget(@PathVariable("target") String target) {
		return distributionService.getNumOfExecutionsByMinute(target);
    }
	@GetMapping("/contribution/{target}")
	public List<Distribution> getJobNamesByTarget(@PathVariable("target") String target) {
		return distributionService.getJobNamesByTarget(target);
    }
}
