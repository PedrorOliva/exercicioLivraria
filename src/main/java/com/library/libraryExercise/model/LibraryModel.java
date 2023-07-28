package com.library.libraryExercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "BOOKS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LibraryModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 100, nullable = false)
  private String name;
  @Column(length = 100, nullable = false)
  private String author;
  @Column(length = 15, nullable = false)
  private String releaseDate;
  @Column(length = 100, nullable = false)
  private Long bookCode;
}
