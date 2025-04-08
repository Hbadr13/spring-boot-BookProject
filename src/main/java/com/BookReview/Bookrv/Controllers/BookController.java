package com.BookReview.Bookrv.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.BookReview.Bookrv.dto.BookDTO;
import com.BookReview.Bookrv.entity.Book;
import com.BookReview.Bookrv.service.BookService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> create(@Validated @RequestBody BookDTO dto) {
        return this.bookService.addBook(dto);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return this.bookService.listBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable UUID id) {
        return this.bookService.getBookById(id);
    }

}