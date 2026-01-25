package com.artem.library.home_library.domain.dto;

import com.artem.library.home_library.domain.entities.BookGenre;
import com.artem.library.home_library.domain.entities.BookLanguage;
import com.artem.library.home_library.domain.entities.BookStatus;

public record BookDto(Long id,
                      String title,
                      String author,
                      int publicationYear,
                      BookLanguage language,
                      BookGenre genre,
                      BookStatus status,
                      String description,
                      int pageCount,
                      String isbn
) {
}
