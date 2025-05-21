package com.thinkconstructive.book_store.repository;

import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.thinkconstructive.book_store.entity.Book;
import java.util.List;


public interface BookRepository extends MongoRepository<Book, String> {
    @Query("{bookId : '?0'}")
    Book findBookByBookId(String bookId);

    @Query(value = "{'bookId' : {$eq : ?0}}")
    @Update(pipeline = {"{'$set':{'name':?1}}"})
    void updateBookNameByBookId(String bookId, String name);

    @DeleteQuery
    void deleteBookByBookId(String bookId);
}
