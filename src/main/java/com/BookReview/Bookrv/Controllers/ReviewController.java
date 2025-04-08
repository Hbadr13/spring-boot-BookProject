package com.BookReview.Bookrv.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.BookReview.Bookrv.dto.ReviewDTO;
import com.BookReview.Bookrv.entity.Review;
import com.BookReview.Bookrv.service.BookService;
import com.BookReview.Bookrv.service.ReviewService;

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
@RequestMapping("/books/{id}/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Object> addReview(@PathVariable UUID id, @Validated @RequestBody ReviewDTO dto) {
        return this.reviewService.addReview(dto, id);
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(@PathVariable UUID id) {
        return this.reviewService.getReviews(id);
    }

}