package com.example.LMS.service;

import com.example.LMS.entity.BookShelf;
import com.example.LMS.repository.BookRepo;
import com.example.LMS.repository.BookShelfRepo;
import com.example.LMS.repository.ShelfRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookShelfService {
    @Autowired
    private BookShelfRepo bookShelfRepository;

    public List<BookShelf> findAll() {
        return bookShelfRepository.findAll();
    }

    public Optional<BookShelf> findById(Long id) {
        return bookShelfRepository.findById(id);
    }

    public BookShelf save(BookShelf bookShelf) {
        return bookShelfRepository.save(bookShelf);
    }

    public void deleteById(Long id) {
        bookShelfRepository.deleteById(id);
    }
}
