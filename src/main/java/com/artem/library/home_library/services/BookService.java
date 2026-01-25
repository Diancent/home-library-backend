package com.artem.library.home_library.services;

import com.artem.library.home_library.domain.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();
    Book createBook(Book book);
    Optional<Book> getBook(Long bookId);
}
