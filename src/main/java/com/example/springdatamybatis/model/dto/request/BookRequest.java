package com.example.springdatamybatis.model.dto.request;

import com.example.springdatamybatis.model.Author;
import com.example.springdatamybatis.model.Category;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BookRequest {
    private String title;
    private LocalDateTime publishedDate;
    private int authorId;
    private List<Integer> categoryId;
}
