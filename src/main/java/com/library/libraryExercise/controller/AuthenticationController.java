package com.library.libraryExercise.controller;

import com.library.libraryExercise.Dto.AuthenticationDTO;
import com.library.libraryExercise.Dto.LoginResponseDTO;
import com.library.libraryExercise.Dto.RegisterDTO;
import com.library.libraryExercise.model.UserModel;
import com.library.libraryExercise.repository.UserRepository;
import com.library.libraryExercise.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody AuthenticationDTO data){
        var usernamePassord = new UsernamePasswordAuthenticationToken(data.getUsername() , data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassord);
        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return  ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping ("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO){
        if (this.userRepository.findByUsername(registerDTO.getUsername())!= null)
            return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getPassword());
        UserModel newUser = new UserModel(registerDTO.getUsername(),encryptedPassword,registerDTO.getRole());

        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteUser(@PathVariable String username) {

        UserDetails userOptional = userRepository.findByUsername(username);
        if (userOptional== null) {
            return ResponseEntity.notFound().build();
        }

        userRepository.delete((UserModel) userOptional);

        return ResponseEntity.noContent().build();
    }
}


