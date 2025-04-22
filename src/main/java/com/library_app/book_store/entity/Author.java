package com.library_app.book_store.entity;

import com.library_app.book_store.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String fullName;

    @Column
    private Status status;


    public Author() {

    }

    public Author(UUID id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public Author(UUID id, String fullName, Status status) {
        this.id = id;
        this.fullName = fullName;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

