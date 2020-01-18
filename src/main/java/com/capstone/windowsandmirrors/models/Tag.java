package com.capstone.windowsandmirrors.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="tags")
public class Tag {
    @Id
    @SequenceGenerator(name="tags_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tags_id_seq")
    private Long id;

    private String identifier;

    public Tag(){}

    public Tag(Long id, String identifier){
        this.id = id;
        this.identifier = identifier;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, identifier);
    }

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }

    public String getIdentifier(){ return identifier; }
    public void setIdentifier(String identifier) { this.identifier = identifier; }

    @Override
    public String toString(){
        return "Tag{" +
                "id=" + id +
                ", identifier" + identifier + '\'' +
                "}";
    }
}
