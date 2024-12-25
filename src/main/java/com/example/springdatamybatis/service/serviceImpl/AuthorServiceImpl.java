package com.example.springdatamybatis.service.serviceImpl;

import com.example.springdatamybatis.model.Author;
import com.example.springdatamybatis.model.dto.request.AuthorRequest;
import com.example.springdatamybatis.repository.AuthorRepository;
import com.example.springdatamybatis.service.AuthorService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAllAuthor();
    }

    @Override
    public Author getAuthorById(int id)  {
        if(authorRepository.findAuthorById(id) == null){
            throw new RuntimeException("Author not found");
        }
        return authorRepository.findAuthorById(id);
    }

    @Override
    public void insertAuthor(AuthorRequest author) {
        authorRepository.InsertAuthor(author);
    }

    @Override
    public void updateAuthor(int id, AuthorRequest author) throws NotFoundException {
        if(authorRepository.findAuthorById(id) == null){
            throw new NotFoundException("Author does not exist");
        }
        authorRepository.updateAuthorById(id, author);
    }

    @Override
    public void deleteAuthor(int id) {

    }
}
