package com.library_app.book_store.controller;

import com.library_app.book_store.entity.Author;
import com.library_app.book_store.repository.AuthorRepository;
import com.library_app.book_store.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(path = "/{id}")
    public void getAuthorById(@RequestBody Author author, @PathVariable("id") UUID id) {
        authorService.getAuthorById();
    }

    @GetMapping(path = "/Authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }


    @PostMapping(path = "/Add-Author")
    public void addAuthor() {

    }
}
