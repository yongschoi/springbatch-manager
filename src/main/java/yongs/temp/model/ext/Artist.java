package yongs.temp.model.ext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="artist")
public class Artist {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 20)
	private String name;
	private int fieldCode;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "agency_id")
	private Agency agency;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "team_id")
	private Team team;
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public Artist(String name, Field field) {
		this.name = name;
		this.fieldCode = field.code;
	}
	
	@AllArgsConstructor
    public enum Field {
		Singer(1), Actor(2), Comedian(3), ALL(4);
        private int	code;
    }
}
