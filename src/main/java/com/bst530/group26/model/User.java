package com.bst530.group26.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String username;

    public User(){}

    public User(String username){
        this.username = username;
    }

    public long getID(){
        return this.id;
    }

    public void setID(long id){
        this.id = id;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
