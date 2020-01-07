package com.capstone.windowsandmirrors.models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "books")
public class Book {
    @Id
    private Long id;

    @ManyToMany
    @JoinTable(
            name="authors_books",
            joinColumns = @JoinColumn(name= "book_id"),
            inverseJoinColumns = @JoinColumn(name="author_id") //this is the name of the column in the join table that points at the other side
    )
    private Set<Author> authors;



    private String title;

    private String isbn10;

    private String isbn13;

    private String summary;

    @Column(name = "start_age")
    private Long startAge;
    @Column(name = "end_age")
    private Long endAge;

    @Column(name = "start_grade")
    private String startGrade;
    @Column(name = "end_grade")
    private String endGrade;


    @Column(name = "img")
    private String bookCover;

    private String genre;


    public Book(){}

    public Book(Long id, String title, String genre, String isbn10, String isbn13, String summary, Long startAge, Long endAge, String startGrade, String endGrade, String bookCover) {
        this.id = id;
        this.title = title;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.summary = summary;
        this.startAge = startAge;
        this.endAge = endAge;
        this.startGrade = startGrade;
        this.endGrade = endGrade;
        this.bookCover = bookCover;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, genre, isbn10, isbn13, summary, startAge, endAge, startGrade, endGrade, bookCover);
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getIsbn10(){
        return isbn10;
    }
    public void setIsbn10(String isbn10){
        this.isbn10 = isbn10;
    }

    public String getIsbn13() { return isbn13; }
    public void setIsbn13(String isbn13) { this.isbn13 = isbn13; }

    public String getSummary(){
        return summary;
    }
    public void setSummary(String summary){
        this.summary = summary;
    }

    public Long getStartAge() { return startAge; }
    public void setStartAge(Long startAge) { this.startAge = startAge; }

    public Long getEndAge() { return endAge; }
    public void setEndAge(Long endAge) {this.endAge = endAge; }

    public String getStartGrade() { return startGrade; }
    public void setStartGrade(String startGrade) {this.startGrade = startGrade; }

    public String getEndGrade() { return endGrade; }
    public void setEndGrade(String endGrade) { this.endGrade = endGrade; }

    public Set<Author> getAuthors() { return authors; }

    public void setAuthors(Set<Author> authors) { this.authors = authors; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", summary='" + summary + '\'' +
                ", startAge='" + startAge + '\'' +
                ", endAge='" + endAge + '\'' +
                ", startGrade='" + startGrade + '\'' +
                ", endGrade='" + endGrade + '\'' +
                ", bookCover='" + bookCover + '\'' +
                '}';
    }
}
