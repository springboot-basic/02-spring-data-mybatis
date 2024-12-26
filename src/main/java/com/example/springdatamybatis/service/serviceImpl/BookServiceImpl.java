package com.example.springdatamybatis.service.serviceImpl;

import com.example.springdatamybatis.model.Book;
import com.example.springdatamybatis.model.dto.request.BookRequest;
import com.example.springdatamybatis.repository.BookRepository;
import com.example.springdatamybatis.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book createBook(BookRequest book) {
        Integer bookId = bookRepository.insertBook(book);

        for (Integer categoryId : book.getCategoryId()) {
            bookRepository.insertIntoBookCategory(bookId, categoryId);
        }

        return bookRepository.findBookById(bookId);
    }
}
