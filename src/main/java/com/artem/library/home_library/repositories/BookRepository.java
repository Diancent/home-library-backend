package com.artem.library.home_library.repositories;

import com.artem.library.home_library.domain.entities.Book;
import com.artem.library.home_library.domain.entities.BookGenre;
import com.artem.library.home_library.domain.entities.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    Optional<Book> findByTitle(String title);
    List<Book> findByGenre(BookGenre genre);
    List<Book> findByStatus(BookStatus status);
    Optional<Book> findByIsbn(String isbn);
}
