package com.library_app.book_store.service;

import com.library_app.book_store.DTOs.AuthorDTO;
import com.library_app.book_store.DTOs.BookDTO;
import com.library_app.book_store.entity.Author;
import com.library_app.book_store.entity.Book;
import com.library_app.book_store.exception.EntityNotFoundException;
import com.library_app.book_store.mapper.BookstoreMapper;
import com.library_app.book_store.repository.AuthorRepository;
import com.library_app.book_store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookstoreService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;


    public AuthorDTO createAuthor(AuthorDTO dto) {

        Author author = new Author();
        author.setName(dto.getName());
        dto.setId(dto.getId());

        authorRepository.save(author);
        return dto;
    }

    public ResponseEntity<AuthorDTO> getAuthor(UUID id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No author goes by this id"));

        AuthorDTO dto = BookstoreMapper.toDTO(author);
        return ResponseEntity.ok(dto);
    }

    public List<AuthorDTO> getAllAuthors() {

        return authorRepository.findAll().stream().map(author -> {

                    return BookstoreMapper.toDTO(author);

        }).collect(Collectors.toList());

    }

    public AuthorDTO updateAuthor(AuthorDTO dto, UUID id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No author goes by this id"));

        author.setName(dto.getName());


        authorRepository.save(author);
        dto.setId(author.getId());
        return dto;
    }

    public void deleteAuthor(UUID id) {
        authorRepository.deleteById(id);
    }
    public BookDTO createBook(BookDTO dto) {
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new EntityNotFoundException("No author goes by this id"));

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setGenre(dto.getGenre());
        book.setAuthor(author);
        dto.setId(book.getId());

        bookRepository.save(book);
        return dto;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> {

            return BookstoreMapper.toDTO(book);
        }).collect(Collectors.toList());
    }

    public BookDTO updateBook(BookDTO dto, UUID id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No book goes by this id"));

        book.setTitle(dto.getTitle());
        book.setGenre(dto.getGenre());

        if (!book.getAuthor().getId().equals(dto.getAuthorId())) {
            Author author = authorRepository.findById(dto.getAuthorId())
                    .orElseThrow(() -> new EntityNotFoundException("No author goes by this id"));
            book.setAuthor(author);
        }

        bookRepository.save(book);
        dto.setId(book.getId());

        return dto;
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

    public List<BookDTO> getBooksByAuthor(UUID id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No author goes by this id"))
                ;
        return bookRepository.findAll().stream().map(book -> {
                    return BookstoreMapper.toDTO(book);
                })
                .filter(book -> book.getAuthorId() == id).collect(Collectors.toList());
    }


}
