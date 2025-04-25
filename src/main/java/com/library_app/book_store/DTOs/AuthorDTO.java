package com.library_app.book_store.DTOs;


import java.util.UUID;

public class AuthorDTO {
    private UUID id;
    private String name;

    public AuthorDTO() {

    }

    public AuthorDTO(String name, UUID id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
