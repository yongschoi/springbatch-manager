package yongs.temp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name="BATCH_JOB_INSTANCE")
public class JobInstance {
	@Id
	@Column(name="JOB_INSTANCE_ID")
	private long id;
	@Column(name="VERSION")
	private long version;
	@Column(name="JOB_NAME")
	private String name;
	@Column(name="JOB_KEY")
	private String key;	
} 
