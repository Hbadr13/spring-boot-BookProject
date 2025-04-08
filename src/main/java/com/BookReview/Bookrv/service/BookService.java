package com.BookReview.Bookrv.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BookReview.Bookrv.dto.BookDTO;
import com.BookReview.Bookrv.entity.Book;
import com.BookReview.Bookrv.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Book> addBook(BookDTO dto) {

        try {
            Book book = new Book();
            book.setTitle(dto.title());
            book.setAuthor(dto.author());
            book.setPublishedDate(dto.publishedDate());
            Book bk = this.bookRepository.save(book);
            return new ResponseEntity<>(bk, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> getBookById(UUID id) {

        try {

            Book bk = this.bookRepository.findById(id).orElse(null);
            if (bk == null)
                return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(bk, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Book>> listBooks() {
        try {

            List<Book> bks = this.bookRepository.findAll();
            return new ResponseEntity<>(bks, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
