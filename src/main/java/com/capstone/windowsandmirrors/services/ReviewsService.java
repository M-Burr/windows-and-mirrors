package com.capstone.windowsandmirrors.services;

import com.capstone.windowsandmirrors.models.*;
import com.capstone.windowsandmirrors.repositories.ReviewsRepository;
import com.capstone.windowsandmirrors.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReviewsService {
    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private UsersRepository usersRepository;

    public Review addReview(Review newBookReview) {
        reviewsRepository.save(newBookReview);
        return newBookReview;
    }

    public ReviewSummaryData bookSummary(long bookId) {
        ReviewSummaryData result = new ReviewSummaryData();

        // get and set averages by account type
        Map<String, Double> averageRatingByAccountType = new HashMap<>();
        List<AverageRatingByAccountType> averages =  reviewsRepository.getAverageRatingForBook(bookId);
        averages.forEach(reviewObject -> {
            averageRatingByAccountType.put(reviewObject.getAccountType(), reviewObject.getAverageScore());
        });
        result.setAverageReviewsByAccountType(averageRatingByAccountType);

        // get and set reviews
        List<ReviewWithUser> reviewWithUsers = new ArrayList<>();
        List<Review> reviews = reviewsRepository.findReviewsByBookId(bookId);
        reviews.forEach(review -> {
            // convert review to review with user
            Optional<User> userOptional = usersRepository.findById(review.getUserId());
            User user = userOptional.get();
            // add review with user to reviewWithUsers list
            reviewWithUsers.add(new ReviewWithUser(user, review));
        });
        result.setReviews(reviewWithUsers);

        return result;
    }
}

