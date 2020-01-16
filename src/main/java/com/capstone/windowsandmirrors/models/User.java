package com.capstone.windowsandmirrors.models;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "users")
public class User {
    @Id
    @SequenceGenerator(name="users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="users_id_seq" )
    private Long id;

    private String name;

    private String email;

    @Column(name = "account_type")
    private String accountType;

    public User(){}

    public User(Long id, String name, String email, String accountType ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.accountType = accountType;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, email, accountType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }
}
