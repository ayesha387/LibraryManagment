package com.example.LMS.controller;

import com.example.LMS.entity.Book;
import com.example.LMS.entity.Member;
import com.example.LMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return bookService.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/shelf/{shelfId}/bookshelf/{bookShelfId}")
    public Book saveBookWithShelfAndBookShelf(@PathVariable Long shelfId,
            @PathVariable Long bookShelfId,
            @RequestBody Book book) {
        return bookService.saveBookWithShelfAndBookShelf(shelfId, bookShelfId, book);
    }

    @GetMapping("/issue-status")
    public String getBookIssueStatus(@RequestParam String bookName) {
        Optional<Member> member = bookService.getBookIssueStatus(bookName);

        if (member.isPresent()) {
            return "The book has been issued to: " + member.get().getName();
        } else {
            return "The book has not been issued.";
        }
    }
}
