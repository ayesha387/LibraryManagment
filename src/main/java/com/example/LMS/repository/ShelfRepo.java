package com.example.LMS.repository;

import com.example.LMS.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepo extends JpaRepository<Shelf, Long> {
}
