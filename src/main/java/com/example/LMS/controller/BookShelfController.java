package com.example.LMS.controller;

import com.example.LMS.entity.BookShelf;
import com.example.LMS.service.BookShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookshelves")
public class BookShelfController {

    @Autowired
    private BookShelfService bookShelfService;

    @GetMapping
    public List<BookShelf> getAllBookShelves() {
        return bookShelfService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookShelf> getBookShelfById(@PathVariable Long id) {
        Optional<BookShelf> bookShelf = bookShelfService.findById(id);
        if (bookShelf.isPresent()) {
            return ResponseEntity.ok(bookShelf.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BookShelf> createBookShelf(@RequestBody BookShelf bookShelf) {
        BookShelf savedBookShelf = bookShelfService.save(bookShelf);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBookShelf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookShelf> updateBookShelf(@PathVariable Long id, @RequestBody BookShelf bookShelf) {
        Optional<BookShelf> existingBookShelf = bookShelfService.findById(id);
        if (existingBookShelf.isPresent()) {
            bookShelf.setId(id);
            BookShelf updatedBookShelf = bookShelfService.save(bookShelf);
            return ResponseEntity.ok(updatedBookShelf);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookShelf(@PathVariable Long id) {
        Optional<BookShelf> existingBookShelf = bookShelfService.findById(id);
        if (existingBookShelf.isPresent()) {
            bookShelfService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
