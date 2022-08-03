package com.example.realfinalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class BusinessPost  extends Post{
    HashMap<User,Double> favoriteNumbers=new HashMap<>();
    ArrayList<User>viewers=new ArrayList<>();
    HashMap<User,LocalDate> likes=new HashMap<>();
    ArrayList <User>favoriteNumberUser=new ArrayList<>();
    ArrayList<Double>favoriteNumberDouble=new ArrayList<>();

    public BusinessPost(User user, String id, String text, ArrayList<User> likeUsers, ArrayList<Post> comments, HashMap<User, Double> favoriteNumbers, ArrayList<User> viewers, HashMap<User, LocalDate> likes, HashMap<User, LocalDate> views, LocalDate releasedTime) {
        super(user, id, text, likeUsers, comments);
        this.favoriteNumbers = favoriteNumbers;
        this.viewers = viewers;
        this.likes = likes;
        this.views = views;
        this.releasedTime = releasedTime;
    }

    HashMap<User,LocalDate> views=new HashMap<>();
    LocalDate releasedTime = LocalDate.now();
    //for setting database:
    ArrayList<User> likesUsersForTable = new ArrayList<>();
    ArrayList<LocalDate> likesLocalDateForTable = new ArrayList<>();
    ArrayList<User> viewUsersForTable = new ArrayList<>();
    ArrayList<LocalDate> viewLocalDatesForTable = new ArrayList<>();

    public ArrayList<User> getViewers() {
        return viewers;
    }

    public void setViewers(ArrayList<User> viewers) {
        this.viewers = viewers;
    }
    public BusinessPost(User user, String id) {
        super(user, id);
    }
}