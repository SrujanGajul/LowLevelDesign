package io.github.srujangajul.cvm.model;

import lombok.Getter;

@Getter
public enum NOTE {
    TEN_RUPEE(10),
    TWENTY_RUPEE(20),
    FIFTY_RUPEE(50),
    HUNDRED_RUPEE(100);

    private final int value;


    NOTE(int value) {
        this.value = value;
    }
}
