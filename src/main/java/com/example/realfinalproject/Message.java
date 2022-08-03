package com.example.realfinalproject;

import java.time.LocalDate;

public class Message {
    private User sender;
    private String text;
    private User receiver;
    private int id;
    boolean forwarded=false;
    private LocalDate localDate;
    public String localDateToString;

    public Message(User sender, String text, User receiver, int id, boolean forwarded, LocalDate localDate) {
        this.sender = sender;
        this.text = text;
        this.receiver = receiver;
        this.id = id;
        this.forwarded = forwarded;
        this.localDate = localDate;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Message(User sender, User receiver, int id, String text,LocalDate localDate) {
        this.sender = sender;
        this.receiver = receiver;
        this.id = id;
        this.text=text;
        this.localDate=localDate;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

