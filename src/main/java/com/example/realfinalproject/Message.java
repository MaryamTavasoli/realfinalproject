package com.example.realfinalproject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Message {
    private User sender;
    private String text;
    private User receiver;
    private int id;
    boolean forwarded=false;
    private LocalDate localDate;
    public String localDateToString;
    private boolean seen = false;
    private String time;
    private String emojiAddress;

    public Message(User sender, User receiver, int id, String text, LocalDate localDate) {
        this.sender = sender;
        this.receiver = receiver;
        this.id = id;
        this.text=text;
        this.localDate=localDate;
    }
    public Message(User sender, String text, User receiver, int id, boolean forwarded, LocalDate localDate,boolean seen,String time,String emojiAddress) {
        this.sender = sender;
        this.text = text;
        this.receiver = receiver;
        this.id = id;
        this.forwarded = forwarded;
        this.localDate = localDate;
        this.seen = seen;
        this.time = time;
        this.emojiAddress = emojiAddress;
    }

}

