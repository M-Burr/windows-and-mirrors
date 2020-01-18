package com.capstone.windowsandmirrors.controllers;

import com.capstone.windowsandmirrors.models.ReviewSummaryData;
import com.capstone.windowsandmirrors.services.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/api/reviews_summary/{bookId}")
    public ReviewSummaryData retrieveSummaryData(@PathVariable long bookId){
        return reviewsService.bookSummary(bookId);
    }
}
