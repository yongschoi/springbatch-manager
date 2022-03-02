package yongs.temp.model.ext;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="team")
public class Team {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 30)
	private String name;
	@OneToMany(mappedBy="team", cascade = CascadeType.ALL)
	private List<Artist> artistList = new ArrayList<>();
	
	public void addArtist(Artist artist) {
		this.artistList.add(artist);
		artist.setTeam(this);
	}
	public Team(String name) {
		this.name = name;
	}
}
