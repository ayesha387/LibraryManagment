package com.example.LMS.repository;

import com.example.LMS.entity.IssueBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueBookRepo extends JpaRepository<IssueBook, Long> {
    IssueBook findIssueBookById(Long IssueBookId);

}
