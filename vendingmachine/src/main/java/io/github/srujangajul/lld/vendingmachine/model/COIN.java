package io.github.srujangajul.lld.vendingmachine.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum COIN implements Denomination{
    ONE_RUPEE(1),
    TWO_RUPEE(2),
    FIVE_RUPEE(5);

    final int value;

    public int getValue() {
        return value;
    }
}
