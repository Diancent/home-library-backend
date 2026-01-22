package com.artem.library.home_library.mappers;

import com.artem.library.home_library.domain.dto.BookDto;
import com.artem.library.home_library.domain.entities.Book;

public interface BookMapper {

    Book fromDto(BookDto bookDto);

    BookDto toDto(Book book);
}
