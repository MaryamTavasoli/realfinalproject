package com.example.realfinalproject;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class GroupMessage {
    @NonNull
    User sender;
    @NonNull
    String text;
    @NonNull
    String id;
    @NonNull
    String groupId;
    @NonNull
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

}
