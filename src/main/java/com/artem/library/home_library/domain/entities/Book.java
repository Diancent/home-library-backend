package com.artem.library.home_library.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="author", nullable = false)
    private String author;

    @Column(name="publication_year", nullable = false)
    private int publicationYear;

    @Column(name="language")
    private BookLanguage language;

    @Column(name="genre")
    private BookGenre genre;

    @Column(name="description")
    private String description;

    @Column(name="status", nullable = false)
    private BookStatus status;

    @Column(name="page_count", nullable = false)
    private int pageCount;

    @Column(name="isbn", nullable = false)
    private String isbn;

    @Column(name="created", nullable = false)
    private LocalDateTime created;

    @Column(name="updated", nullable = false)
    private LocalDateTime updated;

    public Book() {

    }

    public Book(long id, String title, String author, int publicationYear,
                BookLanguage language, BookGenre genre, String description,
                BookStatus status, int pageCount, String isbn,
                LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.language = language;
        this.genre = genre;
        this.description = description;
        this.status = status;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.created = created;
        this.updated = updated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public BookLanguage getLanguage() {
        return language;
    }

    public void setLanguage(BookLanguage language) {
        this.language = language;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && publicationYear == book.publicationYear && pageCount == book.pageCount && Objects.equals(title, book.title) && Objects.equals(author, book.author) && language == book.language && genre == book.genre && Objects.equals(description, book.description) && status == book.status && Objects.equals(isbn, book.isbn) && Objects.equals(created, book.created) && Objects.equals(updated, book.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publicationYear, language, genre, description, status, pageCount, isbn, created, updated);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", language=" + language +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", pageCount=" + pageCount +
                ", isbn='" + isbn + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
