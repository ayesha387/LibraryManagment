package com.example.LMS.repository;

import com.example.LMS.entity.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findByName(String bookName);

}
