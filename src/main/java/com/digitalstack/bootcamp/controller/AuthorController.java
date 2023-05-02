package com.digitalstack.bootcamp.controller;

import com.digitalstack.bootcamp.dto.AuthorDto;
import com.digitalstack.bootcamp.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController
{
    final AuthorService authorService;

    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, world!";
    }

    @GetMapping("/init")
    public void initAuthors() {
        authorService.init();
    }

    @GetMapping("/test")
    public ResponseEntity<List<AuthorDto>> testAuthors() {
        List<AuthorDto> authors = authorService.testAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }


}
