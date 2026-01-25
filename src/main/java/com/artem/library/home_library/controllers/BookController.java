package com.artem.library.home_library.controllers;

import com.artem.library.home_library.domain.dto.BookDto;
import com.artem.library.home_library.domain.entities.Book;
import com.artem.library.home_library.mappers.BookMapper;
import com.artem.library.home_library.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<BookDto> listBooks() {
        return bookService.listBooks()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
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
    public ResponseEntity<BookDto> getBook(@PathVariable("book_id") Long book_id) {

        return bookService.getBook(book_id)
                .map(bookMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping(path = "/{book_id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("book_id") Long book_id, @RequestBody BookDto bookDto) {
        Book updatedBook = bookService.updateBook(
                book_id,
                bookMapper.fromDto(bookDto)
        );
        return ResponseEntity.ok(bookMapper.toDto(updatedBook));
    }

    @DeleteMapping(path = "/{book_id}")
    public void deleteBook(@PathVariable("book_id") Long book_id) {
        bookService.deleteBook(book_id);
    }
}
