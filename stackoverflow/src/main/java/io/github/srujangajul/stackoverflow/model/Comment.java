package io.github.srujangajul.stackoverflow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Comment {
    private final int id;
    private String description;
    private final User by;
}
