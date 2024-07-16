package io.github.srujangajul.cvm.model;

import lombok.Getter;

@Getter
public enum COIN {
    ONE_RUPEE(1),
    TWO_RUPEE(2),
    FIVE_RUPEE(5);

    private final int value;

    COIN(int value) {
        this.value = value;
    }
}
