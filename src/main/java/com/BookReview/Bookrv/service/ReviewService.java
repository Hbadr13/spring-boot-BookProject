package com.BookReview.Bookrv.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.BookReview.Bookrv.dto.ReviewDTO;
import com.BookReview.Bookrv.entity.Book;
import com.BookReview.Bookrv.entity.Review;
import com.BookReview.Bookrv.repository.BookRepository;
import com.BookReview.Bookrv.repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public ResponseEntity<Object> addReview(ReviewDTO dto, UUID book_id) {
        try {

            Review review = new Review();
            Book bk = this.bookRepository.findById(book_id).orElse(null);
            if (bk == null) {
                return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
            }
            review.setRating(dto.rating());
            review.setReviewerName(dto.reviewerName());
            review.setComment(dto.comment());
            review.setBook(bk);
            Review rv = this.reviewRepository.save(review);
            return new ResponseEntity<>(rv, HttpStatus.OK);

        } catch (

        Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Review>> getReviews(UUID id) {
        try {

            Book bk = this.bookRepository.findById(id).orElse(null);
            if (bk == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(bk.getReviews(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
