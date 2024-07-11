package io.github.srujangajul.stackoverflow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private final int id;
    private final String name;
    private int reputation;

    public void increaseReputation(){
        this.reputation +=1;
    }

    public void decreaseReputation(){
        this.reputation -=1;
    }
}
