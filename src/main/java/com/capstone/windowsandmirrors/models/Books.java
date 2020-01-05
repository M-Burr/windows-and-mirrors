package com.capstone.windowsandmirrors.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Objects;

@Entity(name = "books")
public class Books {
    @Id
    private Long id;

    private String title;

    private String author;

    @Column(name = "isbn_10")
    private String isbn10;

    private String summary;

    public Books(){}

    public Books(Long id, String title, String author, String isbn10, String summary) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn10 = isbn10;
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books book = (Books) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, isbn10, summary);
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

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getIsbn10(){
        return isbn10;
    }

    public void setIsbn10(String isbn10){
        this.isbn10 = isbn10;
    }

    public String getSummary(){
        return summary;
    }

    public void setSummary(String summary){
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
