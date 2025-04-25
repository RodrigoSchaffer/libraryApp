package com.library_app.book_store.controller;

import com.library_app.book_store.DTOs.AuthorDTO;
import com.library_app.book_store.DTOs.BookDTO;
import com.library_app.book_store.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookstoreController {

    @Autowired
    private BookstoreService bookstoreService;

    @PostMapping(path = "/Add-Author")
    public AuthorDTO addAuthor(@RequestBody AuthorDTO dto) {
        return bookstoreService.createAuthor(dto);
    }

    @GetMapping(path = "/Author/{id}")
    public AuthorDTO getAuthor(@PathVariable("id") UUID id) {
        return bookstoreService.getAuthor(id);
    }

    @GetMapping(path = "/Author-List")
    public List<AuthorDTO> getAllAuthors() {
        return bookstoreService.getAllAuthors();
    }


    @PutMapping(path = "/Update-Author/{id}")
    public AuthorDTO updateAuthor(@RequestBody AuthorDTO dto, @PathVariable("id") UUID id) {
        return bookstoreService.updateAuthor(dto, id);
    }

    @DeleteMapping(path = "/Delete-Author/{id}")
    public void deleteAuthor(@PathVariable("id") UUID id) {
        bookstoreService.deleteAuthor(id);
    }

    @PostMapping(path = "/Add-Book")
    public BookDTO addBook(@RequestBody BookDTO dto) {
        return bookstoreService.createBook(dto);
    }

    @GetMapping(path = "/Book-Catalog")
    public List<BookDTO> getBooks() {
        return bookstoreService.getAllBooks();
    }

    @PutMapping(path = "/Edit-Book/{id}")
    public BookDTO updateBook(@RequestBody BookDTO dto, @PathVariable("id") UUID id) {
        return bookstoreService.updateBook(dto, id);

    }

    @DeleteMapping(path = "/Delete-Book/{id}")
    public void deleteBook(@PathVariable("id") UUID id) {
        bookstoreService.deleteBook(id);
    }

    @GetMapping(path = "/Author/{id}/Book-Catalog")
    public List<BookDTO> getBookByAuthor(@PathVariable("id") UUID id) {
        return bookstoreService.getBooksByAuthor(id);
    }


}
