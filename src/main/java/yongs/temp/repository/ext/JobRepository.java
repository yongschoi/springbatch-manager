package yongs.temp.repository.ext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import yongs.temp.model.JobInstance;
@Repository
public interface JobRepository extends JpaRepository<JobInstance, Long>, JobRepositoryCustom {
}
