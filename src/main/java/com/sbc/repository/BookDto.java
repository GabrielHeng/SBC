package com.sbc.repository;

import com.sbc.entity.Book;
import com.sbc.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDto extends JpaRepository<Book, Long> {
    List<Book> getBooks();
    List<Genre> getGenres();
}
