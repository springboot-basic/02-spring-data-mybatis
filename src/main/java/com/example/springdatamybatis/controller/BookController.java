package com.example.springdatamybatis.controller;

import com.example.springdatamybatis.model.Book;
import com.example.springdatamybatis.model.dto.ApiResponse;
import com.example.springdatamybatis.model.dto.request.BookRequest;
import com.example.springdatamybatis.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks() {
        List<Book> books = bookService.getAllBook();
        ApiResponse<List<Book>> apiResponse = new ApiResponse<>(
                "Get books successfully",
                HttpStatus.OK,
                books
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody BookRequest book) {
        Book books = bookService.createBook(book);
        ApiResponse<?> apiResponse = new ApiResponse<>(
            "Created book successfully",
            HttpStatus.OK,
                books
        );
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
