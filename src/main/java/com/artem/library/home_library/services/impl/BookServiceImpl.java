package com.artem.library.home_library.services.impl;

import com.artem.library.home_library.domain.entities.Book;
import com.artem.library.home_library.domain.entities.BookStatus;
import com.artem.library.home_library.repositories.BookRepository;
import com.artem.library.home_library.services.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
        if (book.getStatus() == null) {
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
}
