package com.thinkconstructive.book_store.service;

import java.util.List;

import com.thinkconstructive.book_store.dto.BookDto;

public interface BookService {
    public BookDto getBook(String bookId);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookDto bookDto);

    public BookDto updateBookName(BookDto bookDto);

    public void deleteBookByBookId(String bookId);
}
