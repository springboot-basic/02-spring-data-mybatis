package com.example.springdatamybatis.controller;

import com.example.springdatamybatis.model.dto.ApiResponse;
import com.example.springdatamybatis.model.Author;
import com.example.springdatamybatis.model.dto.request.AuthorRequest;
import com.example.springdatamybatis.service.AuthorService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthor();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable int id) throws NotFoundException {
        Author author = authorService.getAuthorById(id);
        ApiResponse<Author> apiResponse = new ApiResponse<>(
                "Get author successfully",
                HttpStatus.OK,
                author
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping
    public ResponseEntity<?> insertAuthor(@RequestBody AuthorRequest author) {
        authorService.insertAuthor(author);
        ApiResponse<Author> apiResponse = new ApiResponse<>(
                "Author inserted successfully",
                HttpStatus.OK,
                null
        );
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable int id, @RequestBody AuthorRequest author) throws NotFoundException {
        authorService.updateAuthor(id, author);
        ApiResponse<Author> apiResponse = new ApiResponse<>(
                "Author updated successfully",
                HttpStatus.OK,
                null
        );
        return ResponseEntity.ok(apiResponse);
    }
}
