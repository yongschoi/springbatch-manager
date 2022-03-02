package yongs.temp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name="BATCH_JOB_EXECUTION")
public class JobExecution {
	@Id
	@Column(name="JOB_EXECUTION_ID")
	private long id;	
	@Column(name="VERSION")
	private long version;
	@Column(name="JOB_INSTANCE_ID")
	private long instanceId;
	
	@Column(name="START_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime startTime;
	@Column(name="END_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime endTime;
	
	@Column(name="STATUS")
	private String status;	
	@Column(name="EXIT_CODE")
	private String exitCode;	
	@Column(name="EXIT_MESSAGE")
	private String exitMessage;	
	
	@Column(name="LAST_UPDATED")
	private LocalDateTime lastUpdated;	
	@Column(name="JOB_CONFIGURATION_LOCATION")
	private String jobConfigurationLocation;	
}
