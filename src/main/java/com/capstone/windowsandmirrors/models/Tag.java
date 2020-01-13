package com.capstone.windowsandmirrors.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name="tags")
public class Tag {
    @Id
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
