package com.library_app.book_store.DTOs;

import java.util.UUID;

public class BookDTO {

    private UUID id;
    private String title;
    private String genre;
    private UUID authorId;

    public BookDTO() {

    }

    public BookDTO(UUID id, String title, String genre, UUID authorId) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
