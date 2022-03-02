package yongs.temp.model.ext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="agency")
public class Agency {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String name;
	/*
	@OneToMany(mappedBy="agency", cascade = CascadeType.ALL)
	private List<Artist> artistList = new ArrayList<>();
	public void addArtist(Artist artist) {
		this.artistList.add(artist);
		artist.setAgency(this);
	}
	*/
	public Agency(String name) {
		this.name = name;
	}
}
