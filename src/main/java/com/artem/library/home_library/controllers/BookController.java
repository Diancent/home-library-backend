package com.artem.library.home_library.controllers;

import com.artem.library.home_library.domain.dto.BookDto;
import com.artem.library.home_library.domain.entities.Book;
import com.artem.library.home_library.mappers.BookMapper;
import com.artem.library.home_library.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {

        Book createdBook = bookService.createBook(bookMapper.fromDto(bookDto));
        BookDto responseDto = bookMapper.toDto(createdBook);

        URI location = URI.create("/books/" + createdBook.getId());

        return ResponseEntity
                .created(location)
                .body(responseDto);
    }

    @GetMapping(path = "/{book_id}")
    public Optional<BookDto> getBook(@PathVariable("book_id") Long book_id) {
        return bookService.getBook(book_id).map(bookMapper::toDto);
    }
}
