package com.example.LMS.controller;

import com.example.LMS.entity.Shelf;
import com.example.LMS.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shelves")
public class ShelfController {

    @Autowired
    private ShelfService shelfService;

    @GetMapping
    public List<Shelf> getAllShelves() {
        return shelfService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shelf> getShelfById(@PathVariable Long id) {
        Optional<Shelf> shelf = shelfService.findById(id);
        if (shelf.isPresent()) {
            return ResponseEntity.ok(shelf.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Shelf> createShelf(@RequestBody Shelf shelf) {
        Shelf savedShelf = shelfService.save(shelf);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedShelf);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shelf> updateShelf(@PathVariable Long id, @RequestBody Shelf shelf) {
        Optional<Shelf> existingShelf = shelfService.findById(id);
        if (existingShelf.isPresent()) {
            shelf.setId(id);
            Shelf updatedShelf = shelfService.save(shelf);
            return ResponseEntity.ok(updatedShelf);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShelf(@PathVariable Long id) {
        Optional<Shelf> existingShelf = shelfService.findById(id);
        if (existingShelf.isPresent()) {
            shelfService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
