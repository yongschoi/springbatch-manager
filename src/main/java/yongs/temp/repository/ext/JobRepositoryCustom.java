package yongs.temp.repository.ext;

import java.util.List;

import yongs.temp.model.JobInstance;

public interface JobRepositoryCustom {
	public List<JobInstance> findByName(String name);
}
