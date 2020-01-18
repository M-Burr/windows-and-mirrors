package com.capstone.windowsandmirrors.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity(name = "authors")
public class Author {
    @Id
    @SequenceGenerator(name="authors_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="authors_id_seq")
    private Long id;

    @ManyToMany
    @JoinTable(
            name="authors_books",
            joinColumns = @JoinColumn(name= "author_id"),
            inverseJoinColumns = @JoinColumn(name="book_id") //this is the name of the column in the join table that points at the other side
    )
    private Set<Book> books;

    private String name;

    @Column(name = "avg_rating")
    private Double avgRating;

    public Author(){}

    public Author(Long id, String name, Double avgRating){
        this.id = id;
        this.name = name;
        this.avgRating = avgRating;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode(){ return Objects.hash(id, name, avgRating); }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Double getAvgRating() {return avgRating;}
    public void setAvgRating(Double avgRating) { this.avgRating = avgRating; }

    @JsonIgnore
    public Set<Book> getBooks() {return books;}

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avgRating='" + avgRating + '\''  +
                '}';
    }
}
