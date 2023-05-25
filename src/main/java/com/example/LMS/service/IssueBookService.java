package com.example.LMS.service;

import com.example.LMS.entity.Book;
import com.example.LMS.entity.IssueBook;
import com.example.LMS.entity.Member;
import com.example.LMS.repository.IssueBookRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IssueBookService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BookService bookService;
    @Autowired
    private IssueBookRepo issueBookRepository;

    public List<IssueBook> findAll() {
        return issueBookRepository.findAll();
    }

    public Optional<IssueBook> findById(Long id) {
        return issueBookRepository.findById(id);
    }

    public IssueBook save(IssueBook issueBook) {
        return issueBookRepository.save(issueBook);
    }

    public void deleteById(Long id) {
        issueBookRepository.deleteById(id);
    }

    public IssueBook issueBookToMember(Long memberId, Long bookId) {
        Member member = memberService.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
        Book book = bookService.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

        IssueBook issueBook = new IssueBook();
        issueBook.setMember(member);
        issueBook.setBookShelf(book.getBookShelf());
        issueBook.setIssueDate(LocalDate.now());
        issueBook.setReturnDate(LocalDate.now().plusDays(14));

        return issueBookRepository.save(issueBook);
    }
}
