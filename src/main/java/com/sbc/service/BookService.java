package com.sbc.service;

import com.sbc.entity.Book;
import com.sbc.entity.Genre;
import com.sbc.repository.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service("bookService")
public class BookService {
    @Autowired
    private BookDto bookDto;

    public List<Genre> mapGenres = new ArrayList<>();
    public List<Book> mapBooks = new ArrayList<>();

    /**
     * original implementation remove duplicates using Set and convert Map into LinkedList to return
     * replaced return type with ArrayList for better performance on read/search operations due to index-based mechanism
     * eliminate duplicate elements using .distinct()
     * combine result of processing stream using .collect()
     */
    public List<Genre> getAllGenres() {
        return mapGenres.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * original implementation filter books by genreName and return as Map<bookName, genreName>
     * perform filter on elements using .filter()
     * combine result of processing stream using .collect()
     */
    public Map<String, String> getBooksByGenre(String name) {
        return mapBooks.stream()
                .distinct()
                .filter(entry -> entry.getGenre().getGenreName().equals(name))
                .collect(Collectors.toMap(Book::getBookName, book -> book.getGenre().getGenreName()));
    }

    public List<Book> getBooks() {
        mapBooks = bookDto.getBooks();
        return mapBooks;
    }

    public List<Genre> getGenres() {
        mapGenres = bookDto.getGenres();
        return mapGenres;
    }
}
