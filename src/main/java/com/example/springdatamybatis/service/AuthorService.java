package com.example.springdatamybatis.service;

import com.example.springdatamybatis.model.Author;
import com.example.springdatamybatis.model.dto.request.AuthorRequest;
import org.apache.ibatis.javassist.NotFoundException;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();
    Author getAuthorById(int id) throws NotFoundException;
    void insertAuthor(AuthorRequest author);
    void updateAuthor(int id, AuthorRequest author) throws NotFoundException;
    void deleteAuthor(int id);
}
