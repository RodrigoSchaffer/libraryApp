package com.library_app.book_store.mapper;

import com.library_app.book_store.entity.Book;
import com.library_app.book_store.DTOs.AuthorDTO;
import com.library_app.book_store.DTOs.BookDTO;
import com.library_app.book_store.entity.Author;
import org.springframework.stereotype.Service;


public class BookstoreMapper {
    public static AuthorDTO toDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setName(author.getName());
        dto.setId(author.getId());
        return dto;
    }

    public static BookDTO toDTO(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setGenre(book.getGenre());
        dto.setAuthorId(book.getAuthor().getId());
        return dto;
    }
}
