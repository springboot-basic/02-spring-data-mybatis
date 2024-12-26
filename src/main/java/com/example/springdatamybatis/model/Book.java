package com.example.springdatamybatis.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Book {
    private int id;
    private String title;
    private LocalDateTime publishedDate;
    private Author author;
    private List<Category> categories;
}
