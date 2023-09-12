package com.library.libraryExercise.controller;

import com.library.libraryExercise.model.LibraryModel;
import com.library.libraryExercise.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LibraryController {
    @Autowired
    LibraryService libraryService;
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/books")
    public List<LibraryModel> findAllBooks() {
        return libraryService.findAllBooks();
    }
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping(path = "/books/{id}")
    public Optional<LibraryModel> findBookById(@PathVariable Long id) {
        return libraryService.findOneBook(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping(path = "/books")
    @ResponseStatus(HttpStatus.CREATED)
    public LibraryModel registerNewBook(@RequestBody LibraryModel libraryModel) {
        return libraryService.create(libraryModel);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/books/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LibraryModel updateABook(@PathVariable Long id, @RequestBody LibraryModel libraryModel) {
        return libraryService.updateABook(id, libraryModel);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/books/{id}")
    public void deleteABook(@PathVariable Long id) {
        libraryService.deleteABook(id);
    }
}
