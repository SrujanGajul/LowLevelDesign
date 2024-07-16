package io.github.srujangajul.cvm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Beverage {
    private int id;
    private String name;
    private int cost;
    private List<Ingredient> ingredients;
}
