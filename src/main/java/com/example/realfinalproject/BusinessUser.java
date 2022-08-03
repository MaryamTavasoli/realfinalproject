package com.example.realfinalproject;

import java.util.ArrayList;

public class BusinessUser extends User {
    public BusinessUser(String id, String password, String nationalCode, String businessAccount) {
        super(id, password, nationalCode, businessAccount);
    }

    public BusinessUser(String id, String password, boolean entered, String nationalCode, String businessAccount, ArrayList<User> followers, ArrayList<User> followings, ArrayList<Post> posts, ArrayList<Message> messages, ArrayList<User> allFriends) {
        super(id, password, entered, nationalCode, businessAccount, followers, followings, posts, messages, allFriends);
    }
}