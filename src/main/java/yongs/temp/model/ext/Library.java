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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="library")
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 20)
	private String name;
	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL)
	private List<Book> bookList = new ArrayList<>();	
	
	public Library(String name) {
		this.name = name;
	}
	
	public void addBook(Book b) {
		bookList.add(b);
		b.setLibrary(this);
	}
}
