package com.example.springdatamybatis.repository;

import com.example.springdatamybatis.model.Book;
import com.example.springdatamybatis.model.Category;
import com.example.springdatamybatis.model.dto.request.BookRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookRepository {
    @Select("""
        SELECT *
        FROM books;
    """)
    @Results(
            id = "bookMapping",
            value = {
                    @Result(property = "publishedDate", column = "published_date"),
                    @Result(property = "author", column = "author_id",
                        one = @One(select = "com.example.springdatamybatis.repository.AuthorRepository.findAuthorById")
                    ),
                    @Result(property = "id", column = "id"),
                    @Result(property = "categories", column = "id",
                        many = @Many(select = "com.example.springdatamybatis.repository.CategoryRepository.getAllCategoriesByBookId")
                    )
            }
    )
    List<Book> getAllBooks();

    @Select("""
        INSERT INTO books(title, published_date, author_id)
        VALUES(#{b.title}, #{b.publishedDate}, #{b.authorId})
        RETURNING id
    """)
    Integer insertBook(@Param("b") BookRequest book);

    @Insert("""
        INSERT INTO book_category(book_id, category_id)
        VALUES(#{bookId}, #{categoryId})
    """)
    void insertIntoBookCategory(int bookId, int categoryId);


    @Select("""
        SELECT * FROM books
        WHERE id = #{id}
    """)
    @ResultMap("bookMapping")
    Book findBookById(Integer id);
}
