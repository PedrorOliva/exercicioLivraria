package com.library.libraryExercise.repository;

import com.library.libraryExercise.model.LibraryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<LibraryModel, Long> {
}
