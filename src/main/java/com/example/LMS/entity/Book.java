package com.example.LMS.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "ISBN", unique = true)
    private String ISBN;
    @Column(name = "edition")
    private String edition;
    @Column(name = "author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "book_shelf_id")
    // @JsonManagedReference
    private BookShelf bookShelf;

    @ManyToOne
    @JoinColumn(name = "category_id")
    // @JsonManagedReference
    private Category category;

    @Column(nullable = false)
    private Boolean available;
}
