package com.example.springdatamybatis.service;

import com.example.springdatamybatis.model.Book;
import com.example.springdatamybatis.model.dto.request.BookRequest;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();

    Book createBook(BookRequest book);
}
