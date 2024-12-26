package com.example.springdatamybatis.repository;

import com.example.springdatamybatis.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryRepository {
    @Select("""
        SELECT category_name FROM categories
        JOIN book_category
        ON book_category.category_id = categories.id
        WHERE book_category.book_id= #{bookId};
    """)
    @Result(property = "categoryName", column = "category_name")
    List<String> getAllCategoriesByBookId(int bookId);
}
