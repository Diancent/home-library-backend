package com.artem.library.home_library.mappers.impl;

import com.artem.library.home_library.domain.dto.BookDto;
import com.artem.library.home_library.domain.entities.Book;
import com.artem.library.home_library.mappers.BookMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public Book fromDto(BookDto bookDto) {
        return new Book(
                bookDto.title(),
                bookDto.author(),
                bookDto.publicationYear(),
                bookDto.language(),
                bookDto.genre(),
                bookDto.status(),
                bookDto.description(),
                bookDto.pageCount(),
                bookDto.isbn()
        );
    }

    @Override
    public BookDto toDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear(),
                book.getLanguage(),
                book.getGenre(),
                book.getStatus(),
                book.getDescription(),
                book.getPageCount(),
                book.getIsbn()
        );
    }
}
