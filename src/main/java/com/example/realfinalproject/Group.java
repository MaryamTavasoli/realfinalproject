package com.example.realfinalproject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
@Setter
public class Group {
    User admin;
    String groupName;
    String groupId;
    ArrayList<User>users=new ArrayList<>();
    ArrayList<Boolean>banned=new ArrayList<>();
    ArrayList<GroupMessage>groupMessages=new ArrayList<>();
    String image;


    public Group(User admin, String groupName, String groupId, ArrayList<User> users, ArrayList<Boolean> banned, ArrayList<GroupMessage> groupMessages, String image) {
        this.admin = admin;
        this.groupName = groupName;
        this.groupId = groupId;
        this.users = users;
        this.banned = banned;
        this.groupMessages = groupMessages;
        this.image = image;
    }
    public Group(User admin, String groupName, String groupId) {
        this.admin = admin;
        this.groupName = groupName;
        this.groupId = groupId;
    }

}
