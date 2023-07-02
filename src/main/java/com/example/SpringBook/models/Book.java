package com.example.SpringBook.models;

import jakarta.validation.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @NotEmpty
    private String title;
    private String description;
    @NotEmpty
    private String author;

    public Book(int id, String title, String description, String author) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }
}