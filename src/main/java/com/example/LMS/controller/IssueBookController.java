package com.example.LMS.controller;

import com.example.LMS.entity.Book;
import com.example.LMS.entity.BookShelf;
import com.example.LMS.entity.IssueBook;
import com.example.LMS.service.BookService;
import com.example.LMS.service.IssueBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/issuebooks")
public class IssueBookController {

    @Autowired
    private IssueBookService issueBookService;

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<IssueBook> getAllIssueBooks() {
        return issueBookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueBook> getIssueBookById(@PathVariable Long id) {
        Optional<IssueBook> issueBook = issueBookService.findById(id);
        if (issueBook.isPresent()) {
            return ResponseEntity.ok(issueBook.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<IssueBook> issueBookToMember(@RequestParam Long memberId, @RequestParam Long bookId) {
        IssueBook issuedBook = issueBookService.issueBookToMember(memberId, bookId);
        return ResponseEntity.status(HttpStatus.CREATED).body(issuedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIssueBook(@PathVariable Long id) {
        Optional<IssueBook> existingIssueBook = issueBookService.findById(id);
        if (existingIssueBook.isPresent()) {
            issueBookService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to handle book returns
    // @PostMapping("/return")
    // public ResponseEntity<?> returnBook(@RequestParam Long issueBookId) {
    // if (issueBookId == null) {
    // return new ResponseEntity<>("Issue book ID must not be null",
    // HttpStatus.BAD_REQUEST);
    // }
    // Optional<IssueBook> optionalIssueBook =
    // issueBookService.findById(issueBookId);

    // if (!optionalIssueBook.isPresent()) {
    // return ResponseEntity.badRequest().body("The IssueBook with the provided ID
    // does not exist.");
    // }

    // IssueBook issueBook = optionalIssueBook.get();

    // if (issueBook.getBook() == null) {
    // return ResponseEntity.badRequest().body("The IssueBook entity has no
    // associated Book.");
    // }

    // Book book = issueBook.getBookShelf().getBooks().stream()
    // .filter(b -> b.getId().equals(issueBook.getBook().getId()))
    // .findFirst().orElse(null);

    // if (book == null) {
    // return ResponseEntity.badRequest().body("The associated Book could not be
    // found.");
    // }

    // book.setAvailable(true);
    // bookService.save(book);

    // return ResponseEntity.ok().build();
    // }

}
