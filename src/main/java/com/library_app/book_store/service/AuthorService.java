package com.library_app.book_store.service;

import com.library_app.book_store.DTOs.AuthorDTO;
import com.library_app.book_store.entity.Author;
import com.library_app.book_store.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorService {

    @Autowired
    AuthorDTO authorDTO;
    @Autowired
    AuthorRepository author;
    public void getAuthorById() {

    }

    public List<Author> getAllAuthors() {
        return author.findAll();
    }


}
