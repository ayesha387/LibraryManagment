package com.example.LMS.repository;

import com.example.LMS.entity.BookShelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookShelfRepo extends JpaRepository<BookShelf, Long> {
}
