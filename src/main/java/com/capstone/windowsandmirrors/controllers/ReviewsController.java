package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.Review;
import com.capstone.windowsandmirrors.models.ReviewSummaryData;
import com.capstone.windowsandmirrors.models.ReviewWithUser;
import com.capstone.windowsandmirrors.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/api/reviews_summary/{bookId}")
    public ReviewSummaryData retrieveSummaryData(@PathVariable long bookId){
        return reviewsService.bookSummary(bookId);
    }

    @PostMapping("/api/reviews_summary/{bookId}")
    public Review addReviewToBook (@RequestBody Review newBookReview){
        return reviewsService.addReview(newBookReview);
    }

}
