package yongs.temp.dto;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yongs.temp.model.JobExecution;
import yongs.temp.model.StepExecution;

@NoArgsConstructor
@Getter
@Setter
public class Job {
	private long instanceId;
	private String name;
	private JobExecution execution;
	private Map<String, String> params;
	private List<StepExecution> stepList;
	private List<StepExecution> completeStepList;
	private long elapsed;
}
