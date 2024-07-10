package io.github.srujangajul.lld.vendingmachine.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NOTE implements Denomination{
    TEN_RUPEE(10),
    TWENTY_RUPEE(20),
    FIFTY_RUPEE(50);

    final int value;
    public int getValue() {
        return value;
    }
}
