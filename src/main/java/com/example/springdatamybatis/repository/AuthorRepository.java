package com.example.springdatamybatis.repository;

import com.example.springdatamybatis.model.Author;
import com.example.springdatamybatis.model.dto.request.AuthorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AuthorRepository {

    @Select("""
        SELECT * FROM author
    """)
    @Result(property = "authorName", column = "author_name")
    List<Author> findAllAuthor();


    @Select("""
        SELECT * FROM author WHERE id = #{id} 
    """)
    @Result(property = "authorName", column = "author_name")
    Author findAuthorById(int id);

    @Insert("""
        INSERT INTO author
        VALUES (DEFAULT, #{author.authorName}, #{author.gender})
    """)
    void InsertAuthor(@Param("author") AuthorRequest author);

    @Update("""
        UPDATE author
        SET author_name = #{a.authorName}, gender = #{a.gender}
        WHERE id = #{id}
    """)
    void updateAuthorById(int id, @Param("a") AuthorRequest author);


    @Delete("""
        DELETE FROM author
        WHERE id = #{id}
    """)
    void deleteAuthor(int id);
}
