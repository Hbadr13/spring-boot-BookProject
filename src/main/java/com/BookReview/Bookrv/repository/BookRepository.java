package com.BookReview.Bookrv.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.BookReview.Bookrv.entity.Book;

public interface BookRepository extends JpaRepository<Book, UUID> {
}