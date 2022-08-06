package com.example.realfinalproject;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Block {
    User blocker;
    User blocked;
    public Block(User blocker, User blocked) {
        this.blocker = blocker;
        this.blocked = blocked;
    }
}
