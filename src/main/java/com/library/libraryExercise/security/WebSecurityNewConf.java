package com.library.libraryExercise.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityNewConf {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.httpBasic()
                .and()
                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.GET,"/books").permitAll()
//                .antMatchers(HttpMethod.GET,"/books/{id}").hasAnyRole("ADMIN", "USER")
//                .antMatchers(HttpMethod.POST,"/books").hasRole("USER")
//                .antMatchers(HttpMethod.DELETE,"/books/{id}").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/books/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().csrf().disable();
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
