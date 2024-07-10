package io.github.srujangajul.lld.vendingmachine;

import io.github.srujangajul.lld.vendingmachine.model.COIN;
import io.github.srujangajul.lld.vendingmachine.model.NOTE;
import io.github.srujangajul.lld.vendingmachine.model.Product;
import io.github.srujangajul.lld.vendingmachine.model.VendingMachine;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();
        Product product = new Product("Coke", 20);
        Product product1 = new Product("Pepsi", 30);
        Product product2 = new Product("Soda", 40);
        vendingMachine.addProduct(product, 10);
        vendingMachine.addProduct(product1, 10);
        vendingMachine.addProduct(product2, 10);
        vendingMachine.addDenomination(COIN.ONE_RUPEE, 100);
        vendingMachine.addDenomination(COIN.TWO_RUPEE, 100);
        vendingMachine.addDenomination(COIN.FIVE_RUPEE, 100);

        vendingMachine.addChange(NOTE.TEN_RUPEE, 3);
        vendingMachine.dispenseProduct("Coke");

        vendingMachine.dispenseChange();

    }
}