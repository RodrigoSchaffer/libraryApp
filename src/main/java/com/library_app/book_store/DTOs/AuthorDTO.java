package com.library_app.book_store.DTOs;

import com.library_app.book_store.enums.Status;

public class AuthorDTO {
    private String fullName;

    private Status status;

    public AuthorDTO() {

    }

    public AuthorDTO(String fullName, Status status) {
        this.fullName = fullName;
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
