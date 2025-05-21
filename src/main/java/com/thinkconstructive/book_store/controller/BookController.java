package com.thinkconstructive.book_store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkconstructive.book_store.dto.BookDto;
import com.thinkconstructive.book_store.service.BookService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/book-store")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable("bookId") String bookId) {
        BookDto bookDto = bookService.getBook(bookId);
        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        List<BookDto> bookDtoList = bookService.getAllBooks();
        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<BookDto> createBooks(@RequestBody BookDto bookDto) {
        BookDto bookDtoCreated = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDtoCreated, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        BookDto bookDtoUpdated =  bookService.updateBookName(bookDto);
        return new ResponseEntity<>(bookDtoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId) {
        bookService.deleteBookByBookId(bookId);
        return new ResponseEntity<>("Book Deleted Successfully: "+bookId, HttpStatus.OK);
    }
}
