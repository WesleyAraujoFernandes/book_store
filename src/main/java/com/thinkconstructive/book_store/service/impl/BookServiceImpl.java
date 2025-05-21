package com.thinkconstructive.book_store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thinkconstructive.book_store.dto.BookDto;
import com.thinkconstructive.book_store.entity.Book;
import com.thinkconstructive.book_store.mapper.BookMapper;
import com.thinkconstructive.book_store.repository.BookRepository;
import com.thinkconstructive.book_store.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public BookDto getBook(String bookId) {
        Book book = bookRepository.findBookByBookId(bookId);
        return BookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = this.bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book: books) {
            bookDtoList.add(BookMapper.toDto(book));
        }
        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookRepository.insert(BookMapper.toEntity(bookDto));
        return BookMapper.toDto(book);
    }

    @Override
    public BookDto updateBookName(BookDto bookDto) {
        bookRepository.updateBookNameByBookId(bookDto.bookId(), bookDto.name());
        Book book = bookRepository.findBookByBookId(bookDto.bookId());
        return BookMapper.toDto(book);
    }

    @Override
    public void deleteBookByBookId(String bookId) {
        bookRepository.deleteBookByBookId(bookId);
    }

}
