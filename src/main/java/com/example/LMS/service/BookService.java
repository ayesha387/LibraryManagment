package com.example.LMS.service;

import com.example.LMS.entity.Book;
import com.example.LMS.entity.BookShelf;
import com.example.LMS.entity.IssueBook;
import com.example.LMS.entity.Member;
import com.example.LMS.entity.Shelf;
import com.example.LMS.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepository;

    @Autowired
    private ShelfService shelfService;

    @Autowired
    private BookShelfService bookShelfService;

    @Autowired
    @Lazy
    private IssueBookService issueBookService;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book saveBookWithShelfAndBookShelf(Long shelfId, Long bookShelfId, Book book) {
        Shelf shelf = shelfService.findById(shelfId).orElseThrow(() -> new RuntimeException("Shelf not found"));
        BookShelf bookShelf = bookShelfService.findById(bookShelfId)
                .orElseThrow(() -> new RuntimeException("BookShelf not found"));

        bookShelf.setShelf(shelf);
        book.setBookShelf(bookShelf);

        return bookRepository.save(book);
    }

    public Optional<Member> getBookIssueStatus(String bookName) {
        List<Book> books = bookRepository.findByName(bookName);
        if (books.isEmpty()) {
            throw new RuntimeException("Book not found");
        }

        Book book = books.get(0);
        List<IssueBook> issuedBooks = issueBookService.findAll();

        return issuedBooks.stream()
                .filter(issueBook -> issueBook.getBookShelf().getBooks().stream()
                        .anyMatch(bookInShelf -> bookInShelf.getId().equals(book.getId())))
                .map(IssueBook::getMember)
                .findFirst();
    }
}
