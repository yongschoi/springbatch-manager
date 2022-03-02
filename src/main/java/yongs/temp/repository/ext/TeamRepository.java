package yongs.temp.repository.ext;

import org.springframework.data.jpa.repository.JpaRepository;

import yongs.temp.model.ext.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	public Team findByName(String name);
}
