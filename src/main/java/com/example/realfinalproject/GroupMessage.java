package com.example.realfinalproject;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
@Setter
@Getter
public class GroupMessage {
    User sender;
    String text;
    String id;
    String groupId;
    LocalDate localDate;
    String time;
    String emojiAddress;
    String localDateToString;
    ArrayList<Boolean> seen=new ArrayList<>();
    public GroupMessage(User sender, String text, String id, String groupId, LocalDate localDate, ArrayList<Boolean> seen, String time, String emojiAddress) {
        this.sender = sender;
        this.text = text;
        this.id = id;
        this.groupId = groupId;
        this.localDate = localDate;
        this.seen = seen;
        this.time = time;
        this.emojiAddress = emojiAddress;
    }
    public GroupMessage(User sender, String text, String id, String groupId, LocalDate localDate) {
        this.sender = sender;
        this.text = text;
        this.id = id;
        this.groupId=groupId;
        this.localDate=localDate;
    }
}
