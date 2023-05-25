package com.example.LMS.service;

import com.example.LMS.entity.Book;
import com.example.LMS.entity.Shelf;
import com.example.LMS.repository.ShelfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShelfService {
    @Autowired
    private ShelfRepo shelfRepository;

    public List<Shelf> findAll() {
        return shelfRepository.findAll();
    }

    public Optional<Shelf> findById(Long id) {
        return shelfRepository.findById(id);
    }

    public Shelf save(Shelf shelf) {
        return shelfRepository.save(shelf);
    }

    public void deleteById(Long id) {
        shelfRepository.deleteById(id);
    }
}
