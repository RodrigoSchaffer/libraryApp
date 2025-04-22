package com.library_app.book_store.mapper;

import com.library_app.book_store.DTOs.AuthorDTO;
import com.library_app.book_store.entity.Author;

import java.time.LocalDate;
import java.time.Period;

public class AuthorMapper {
    public static AuthorDTO toDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setFullName(author.getFullName());

        dto.setStatus(author.getStatus());

        return dto;
    }
}
