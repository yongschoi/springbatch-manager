package yongs.temp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name="BATCH_STEP_EXECUTION")
public class StepExecution {
	@Id
	@Column(name="STEP_EXECUTION_ID")
	private long id;
	@Column(name="STEP_NAME")
	private String name;
	@Column(name="JOB_EXECUTION_ID")
	private long executionId;
	@Column(name="START_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime stime;
	@Column(name="END_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime etime;
	@Column(name="STATUS")
	private String status;
	@Column(name="EXIT_CODE")
	private String exitCode;
	@Column(name="COMMIT_COUNT")
	private long commitCount;
	@Column(name="READ_COUNT")	
	private long readCount;
	@Column(name="FILTER_COUNT")	
	private long filterCount;
	@Column(name="WRITE_COUNT")	
	private long writeCount;
	@Column(name="ROLLBACK_COUNT")	
	private long rollbackCount;
	@Column(name="EXIT_MESSAGE")	
	private String exitMessage;
	@Transient
	private long elapsed;
	public void setElapsed(long elapsed) {
		this.elapsed = elapsed;
	}
}
