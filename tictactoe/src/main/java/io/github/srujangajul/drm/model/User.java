package io.github.srujangajul.drm.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private int gamesPlayed;
    private int gamesWon;
}
