package com.BookReview.Bookrv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record BookDTO(
        @NotBlank String title,
        @NotBlank String author,
        @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Published date must follow the format yyyy-MM-dd") String publishedDate) {
}
