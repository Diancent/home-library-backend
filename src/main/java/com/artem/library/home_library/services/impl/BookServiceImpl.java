package com.artem.library.home_library.services.impl;

import com.artem.library.home_library.domain.entities.Book;
import com.artem.library.home_library.domain.entities.BookStatus;
import com.artem.library.home_library.repositories.BookRepository;
import com.artem.library.home_library.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        if (null != book.getId()) {
            throw new IllegalArgumentException("Book already has an ID");
        }
        if (null == book.getTitle() || book.getTitle().isBlank()) {
            throw new IllegalArgumentException("Book must have a title");
        }
        if (null == book.getAuthor() || book.getAuthor().isBlank()) {
            throw new IllegalArgumentException("Book must have a author");
        }
        if (book.getPublicationYear() <= 0) {
            throw new IllegalArgumentException("Book must have a publication year");
        }
        if (null == book.getStatus()) {
            book.setStatus(BookStatus.AVAILABLE);
        }
        if (null == book.getIsbn() || book.getIsbn().isBlank()) {
            throw new IllegalArgumentException("Book must have a isbn");
        }

        return bookRepository.save(book);

    }

    @Override
    public Optional<Book> getBook(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public Book updateBook(Long bookId, Book book) {
        if (null == book.getId()) {
            throw new IllegalArgumentException("Book must have an ID!");
        }
        if (!Objects.equals(bookId, book.getId())) {
            throw new IllegalArgumentException("Book IDs do not match");
        }
        if (null == book.getTitle() || book.getTitle().isBlank()) {
            throw new IllegalArgumentException("Book must have a title");
        }
        if (null == book.getAuthor() || book.getAuthor().isBlank()) {
            throw new IllegalArgumentException("Book must have a author");
        }
        if (book.getPublicationYear() <= 0) {
            throw new IllegalArgumentException("Book must have a publication year");
        }
        if (null == book.getStatus()) {
            throw new IllegalArgumentException("Book must have a status");
        }
        if (null == book.getIsbn() || book.getIsbn().isBlank()) {
            throw new IllegalArgumentException("Book must have a isbn");
        }

        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublicationYear(book.getPublicationYear());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setGenre(book.getGenre());
        existingBook.setStatus(book.getStatus());
        existingBook.setDescription(book.getDescription());
        existingBook.setPageCount(book.getPageCount());
        existingBook.setIsbn(book.getIsbn());

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        bookRepository.delete(book);
    }
}
