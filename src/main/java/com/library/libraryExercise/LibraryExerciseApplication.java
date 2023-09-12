package com.library.libraryExercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LibraryExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryExerciseApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("senha123"));
	}

}
