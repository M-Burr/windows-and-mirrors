package com.capstone.windowsandmirrors.models;

import java.util.List;
import java.util.Map;

public class ReviewSummaryData {
    private Map<String, Double> averageReviewsByAccountType; // key is account type, value is average score
    private List<ReviewWithUser> reviews;

    public Map<String, Double> getAverageReviewsByAccountType() {
        return averageReviewsByAccountType;
    }

    public void setAverageReviewsByAccountType(Map<String, Double> averageReviewsByAccountType) {
        this.averageReviewsByAccountType = averageReviewsByAccountType;
    }

    public List<ReviewWithUser> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewWithUser> reviews) {
        this.reviews = reviews;
    }
}
