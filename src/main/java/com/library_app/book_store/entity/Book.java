package com.library_app.book_store.entity;

import jakarta.persistence.*;

import java.util.UUID;

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Title")
    private String title;
    @Column(name = "Genre")
    private String genre;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book() {

    }

    public Book(UUID id, String title, String genre, Author author) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
