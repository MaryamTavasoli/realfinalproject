package com.example.realfinalproject;

import java.util.ArrayList;

public class User {
    public User(String id, String password, boolean entered, String nationalCode, String businessAccount, ArrayList<User> followers, ArrayList<User> followings, ArrayList<Post> posts, ArrayList<Message> messages, ArrayList<User> allFriends) {
        this.id = id;
        this.password = password;
        this.entered = entered;
        this.nationalCode = nationalCode;
        this.businessAccount = businessAccount;
        this.followers = followers;
        this.followings = followings;
        this.posts = posts;
        this.messages = messages;
        this.allFriends = allFriends;
    }

    private String id;
    private String password;
    private boolean entered=false;
    private String nationalCode;
    private String businessAccount;
    ArrayList<User>followers=new ArrayList<>();
    ArrayList<User>followings=new ArrayList<>();
    ArrayList<Post>posts=new ArrayList<>();
    ArrayList<Message> messages=new ArrayList<>();
    ArrayList<User> allFriends=new ArrayList<>();

    public ArrayList<User> getAllFriends() {
        return allFriends;
    }

    public void setAllFriends(ArrayList<User> allFriends) {
        this.allFriends = allFriends;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public void setFollowings(ArrayList<User> followings) {
        this.followings = followings;
    }

    public ArrayList<User> getFollowings() {
        return followings;
    }

    public void setBusinessAccount(String businessAccount) {
        this.businessAccount = businessAccount;
    }

    public String getBusinessAccount() {
        return businessAccount;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }

    public boolean isEntered() {
        return entered;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
    public void printUserPosts(){
        int n= posts.size();
        if (n<5){
            for (Post post : posts) {
                System.out.println(id+"\n" +post.getText());
                if (post.getComments().size()>=1) {
                    System.out.println("comment: "+post.getComments().get(post.getComments().size() - 1).user.getId()
                            +"\n"+ post.getComments().get(post.getComments().size() - 1).getText());
                }
            }
        }
        else{
            for (int i=n-1;i>n-6;i--){
                System.out.println(id+"\n"+posts.get(i).getText());
                if (posts.get(i).getComments().size()>=1) {
                    System.out.println("comment: "+posts.get(i).getComments().get(posts.get(i).getComments().size() - 1).user.getId()
                            +"\n"+ posts.get(i).getComments().get(posts.get(i).getComments().size() - 1).getText());
                }
            }
        }
    }
    public void printFollowingsPosts(){
        for (User following : followings) {
            int n=following.getPosts().size();
            if (n<5){
                for (Post post : following.posts) {
                    System.out.println(following.getId()+"\n" + post.getText());
                    if (post.getComments().size()>=1) {
                        System.out.println("comment: "+post.getComments().get(post.getComments().size() - 1).user.getId()+"\n"+ post.getComments().get(post.getComments().size() - 1).getText());
                    }
                }
            }
            else{
                for (int i=n-1;i>n-6;i--){
                    System.out.println(following.getId()+"\n"+following.posts.get(i).getText());
                    if (posts.get(i).getComments().size()>=1) {
                        System.out.println("comment: "+posts.get(i).getComments().get(posts.get(i).getComments().size() - 1).user.getId()
                                +"\n"+ posts.get(i).getComments().get(posts.get(i).getComments().size() - 1).getText());
                    }
                }
            }
        }
    }
    public void printFollowersPosts(){
        for (User follower : followers) {
            int n=follower.getPosts().size();
            if (n<5){
                for (Post post : follower.posts) {
                    System.out.println(follower.getId()+"\n"+ post.getText());
                    if (post.getComments().size()>=1) {
                        System.out.println("comment: "+post.getComments().get(post.getComments().size() - 1).user.getId()+"\n"
                                + post.getComments().get(post.getComments().size() - 1).getText());
                    }
                }
            }
            else{
                for (int i=n-1;i>n-6;i--){
                    System.out.println(follower.getId()+"\n"+follower.posts.get(i).getText());
                    if (posts.get(i).getComments().size()>=1) {
                        System.out.println("comment: "+posts.get(i).getComments().get(posts.get(i).getComments().size() - 1).user.getId()
                                +"\n"+ posts.get(i).getComments().get(posts.get(i).getComments().size() - 1).getText());
                    }
                }
            }
        }
    }
    public int indexOfMessage(Message message){
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).equals(message)){
                return i+1;
            }
        }
        return -1;
    }
    public User(String id, String password, String nationalCode,String businessAccount) {
        this.id = id;
        this.password = password;
        this.nationalCode = nationalCode;
        this.businessAccount=businessAccount;
    }
}