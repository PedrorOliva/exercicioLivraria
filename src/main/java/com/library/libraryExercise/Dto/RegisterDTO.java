package com.library.libraryExercise.Dto;

import com.library.libraryExercise.enuns.UserRole;
import lombok.Data;

@Data
public class RegisterDTO {

    private String username;


    private String password;

    private UserRole role;
}
