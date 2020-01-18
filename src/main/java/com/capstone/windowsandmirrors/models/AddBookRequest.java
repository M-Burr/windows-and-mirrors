package com.capstone.windowsandmirrors.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class AddBookRequest {
    private String title;
    private Set<String> authors;
    private String bookCover;
    private String genre;
    private String isbn10;
    private String isbn13;
    private String summary;
    private Set<String> tags;
    private Long startAge;
    private Long endAge;
    private String startGrade;
    private String endGrade;
    @JsonProperty("user_id")
    private Long userId;
    private Double rating;
    private String praise;
    private String concern;
    @JsonProperty("discussion_topic")
    private String discussionTopic;

    public AddBookRequest(String title, Set<String> authors, String bookCover, String genre, String isbn10, String isbn13, String summary, Set<String> tags, Long startAge, Long endAge, String startGrade, String endGrade, Long userId, Double rating, String praise, String concern, String discussionTopic) {
        this.title = title;
        this.authors = authors;
        this.bookCover = bookCover;
        this.genre = genre;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.summary = summary;
        this.tags = tags;
        this.startAge = startAge;
        this.endAge = endAge;
        this.startGrade = startGrade;
        this.endGrade = endGrade;
        this.userId = userId;
        this.rating = rating;
        this.praise = praise;
        this.concern = concern;
        this.discussionTopic = discussionTopic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Long getStartAge() {
        return startAge;
    }

    public void setStartAge(Long startAge) {
        this.startAge = startAge;
    }

    public Long getEndAge() {
        return endAge;
    }

    public void setEndAge(Long endAge) {
        this.endAge = endAge;
    }

    public String getStartGrade() {
        return startGrade;
    }

    public void setStartGrade(String startGrade) {
        this.startGrade = startGrade;
    }

    public String getEndGrade() {
        return endGrade;
    }

    public void setEndGrade(String endGrade) {
        this.endGrade = endGrade;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getDiscussionTopic() {
        return discussionTopic;
    }

    public void setDiscussionTopic(String discussionTopic) {
        this.discussionTopic = discussionTopic;
    }

    @Override
    public String toString() {
        return "AddBookRequest{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", bookCover='" + bookCover + '\'' +
                ", genre='" + genre + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", summary='" + summary + '\'' +
                ", tags=" + tags +
                ", startAge='" + startAge + '\'' +
                ", endAge='" + endAge + '\'' +
                ", startGrade='" + startGrade + '\'' +
                ", endGrade='" + endGrade + '\'' +
                ", userId=" + userId +
                ", rating=" + rating +
                ", praise='" + praise + '\'' +
                ", concern='" + concern + '\'' +
                ", discussionTopic='" + discussionTopic + '\'' +
                '}';
    }
}
