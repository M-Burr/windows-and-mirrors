package com.capstone.windowsandmirrors.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "reviews")
public class Review {
    @Id
    @SequenceGenerator(name="reviews_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="reviews_id_seq" )
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    private Double rating;

    private String praise;

    private String concern;

    @Column(name = "discussion_topics")
    private String discussionTopics;

    public Review(){}

    public Review(Long id, Long userId, Long bookId, Double rating, String praise, String concern, String discussionTopics){
        this.id = id;
        this.userId = userId;
        //this.bookId = bookId;
        this.rating = rating;
        this.praise = praise;
        this.concern = concern;
        this.discussionTopics = discussionTopics;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode(){ return Objects.hash(id, userId, rating, praise, concern, discussionTopics); }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() { return bookId; }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }

    public String getDiscussionTopics() {
        return discussionTopics;
    }

    public void setDiscussionTopics(String discussionTopics) {
        this.discussionTopics = discussionTopics;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userId=" + userId +
                ", rating=" + rating +
                ", praise='" + praise + '\'' +
                ", concern='" + concern + '\'' +
                ", discussionTopics='" + discussionTopics + '\'' +
                '}';
    }
}
