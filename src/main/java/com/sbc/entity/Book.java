package com.sbc.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private String bookId;

    @Column(name = "bookName")
    private String bookName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genreId", referencedColumnName = "bookId")
    private Genre genre;

    public Book(String bookId, String bookName, Genre genre) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.genre = genre;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) && Objects.equals(bookName, book.bookName) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookName, genre);
    }
}
