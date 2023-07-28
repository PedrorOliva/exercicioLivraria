package com.library.libraryExercise.service;

import com.library.libraryExercise.model.LibraryModel;
import com.library.libraryExercise.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

  @Autowired
  LibraryRepository libraryRepository;

  public List<LibraryModel> findAllBooks() {
    return libraryRepository.findAll();
  }

  public Optional<LibraryModel> findOneBook(Long id) {
    return libraryRepository.findById(id);
  }

  public LibraryModel create(LibraryModel libraryModel) {
    return libraryRepository.save(libraryModel);
  }

  public LibraryModel updateABook(Long id, LibraryModel libraryModel) {
    LibraryModel book = findOneBook(id).get();

    if (libraryModel.getName() != null) {
      book.setName(libraryModel.getName());
    }
    if (libraryModel.getAuthor() != null) {
      book.setAuthor(libraryModel.getAuthor());
    }
    if (libraryModel.getReleaseDate() != null) {
      book.setReleaseDate(libraryModel.getReleaseDate());
    }
    return libraryRepository.save(book);
  }

  public void deleteABook(Long id) {
    libraryRepository.deleteById(id);
  }
}
