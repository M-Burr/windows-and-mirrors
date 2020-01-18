package com.capstone.windowsandmirrors.models;

public class ReviewWithUser {
    private User user;
    private Review review;

    public ReviewWithUser(User user, Review review) {
        this.user = user;
        this.review = review;
    }

    public Double getRating(){
        return this.review.getRating();
    }

    public  String getPraise(){
        return this.review.getPraise();
    }

    public String getConcern(){
        return this.review.getConcern();
    }

    public String getDiscussionTopics(){
        return this.review.getDiscussionTopics();
    }

    public String getUserName(){
        return this.user.getName();
    }

    public String getAccountType(){
        return this.user.getAccountType();
    }
}
