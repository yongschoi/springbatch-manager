package yongs.temp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name="BATCH_JOB_EXECUTION_PARAMS")
public class JobParams {
	@Id
	@Column(name="JOB_EXECUTION_ID")
	private long id;
	@Column(name="TYPE_CD")
	private String typdCd;
	@Column(name="KEY_NAME")
	private String keyName;
	@Column(name="STRING_VAL")
	private String stringVal;

	@Column(name="DATE_VAL")
	private LocalDateTime dateVal;
	@Column(name="LONG_VAL")
	private long longVal;
	@Column(name="DOUBLE_VAL")
	private double doubleVal;
	@Column(name="IDENTIFYING")
	private String identifying;	
}
