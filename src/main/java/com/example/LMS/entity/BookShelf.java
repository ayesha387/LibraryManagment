package com.example.LMS.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "book_shelf")
@Data
public class BookShelf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "bookShelf")
    // @JsonBackReference
    private List<Book> books;

    // @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "shelf_id")
    private Shelf shelf;

    @OneToOne(mappedBy = "bookShelf")
    private IssueBook issueBook;
}