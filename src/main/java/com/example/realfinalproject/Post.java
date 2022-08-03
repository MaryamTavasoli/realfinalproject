package com.example.realfinalproject;

import java.util.ArrayList;

public class Post {
    User user;

    public Post(User user, String id, String text, ArrayList<User> likeUsers, ArrayList<Post> comments) {
        this.user = user;
        Id = id;
        this.text = text;
        this.likeUsers = likeUsers;
        this.comments = comments;
    }

    String Id;
    String text;
    ArrayList<User> likeUsers=new ArrayList<>();
    public ArrayList<Post> comments=new ArrayList<>();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getLikeUsers() {
        return likeUsers;
    }

    public void setLikeUsers(ArrayList<User> likeUsers) {
        this.likeUsers = likeUsers;
    }

    public ArrayList<Post> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Post> comments) {
        this.comments = comments;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post(User user, String id) {
        this.user = user;
        this.Id= id;
    }
}
