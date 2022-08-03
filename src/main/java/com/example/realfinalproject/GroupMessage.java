package com.example.realfinalproject;

import java.time.LocalDate;

public class GroupMessage {
    User sender;
    String text;
    String id;

    Group group;
    LocalDate localDate;
    String localDateToString;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public GroupMessage(User sender, String text, String id, Group group, LocalDate localDate) {
        this.sender = sender;
        this.text = text;
        this.id = id;
        this.group=group;
        this.localDate=localDate;
    }
}
