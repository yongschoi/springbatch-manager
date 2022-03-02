package yongs.temp.repository.ext;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import yongs.temp.model.ext.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
	public Artist findByName(String name);
	public List<Artist> findByTeamId(Long id);
}
