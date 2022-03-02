package yongs.temp.repository.ext;

import org.springframework.data.jpa.repository.JpaRepository;

import yongs.temp.model.ext.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
