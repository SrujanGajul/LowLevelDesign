package io.github.srujangajul.lld.vendingmachine.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class VendingMachine {
    Map<Product, Integer> productsQuantity;
    Map<Denomination, Integer> denominationQuantity;
    VendingMachineState vendingMachineState;

    Map<Denomination, Integer> denominationAdded;
    Product productSelected;

    public VendingMachine() {
        productsQuantity = new HashMap<>();
        denominationQuantity = new HashMap<>();
        vendingMachineState = VendingMachineState.IDLE;
        denominationAdded = new HashMap<>();
    }


    public void addProduct(Product product, int quantity) {
        productsQuantity.put(product, productsQuantity.getOrDefault(product, 0) + quantity);
    }

    public void addDenomination(Denomination denomination, int quantity) {
        denominationQuantity.put(denomination, denominationQuantity.getOrDefault(denomination, 0) + quantity);
    }

    public void addChange(Denomination denomination, int quantity) {
        denominationAdded.put(denomination, denominationAdded.getOrDefault(denomination, 0) + quantity);
    }

    public Product dispenseProduct(String product) {
        int totalDenomination = calculateTotalDenominationAdded();
        for (Product product1 : productsQuantity.keySet()) {
            if (
                    product1.getName().equals(product) &&
                            product1.getPrice() <= totalDenomination &&
                            productsQuantity.get(product1) >= 1
            ) {
                productSelected = product1;
            }
        }
        if (productSelected != null) {
            addDenomToDenomQuantity();
            removeProductFromProductsQuantity(productSelected);
        }
        return productSelected;

    }

    public Map<Denomination, Integer> dispenseChange() {
        if (productSelected == null)
            return denominationAdded;


        Map<Denomination, Integer> returnDenomination = new HashMap<>();
        int changeToReturn = calculateTotalDenominationAdded() - productSelected.getPrice();

        // Sort denominations in descending order
        List<Denomination> sortedDenominations = new ArrayList<>(denominationQuantity.keySet());
        sortedDenominations.sort((d1, d2) -> Integer.compare(d2.getValue(), d1.getValue()));

        // Dispense denominations from the highest to the lowest
        for (Denomination denomination : sortedDenominations) {
            while (changeToReturn >= denomination.getValue() && denominationQuantity.get(denomination) > 0) {
                returnDenomination.put(denomination, returnDenomination.getOrDefault(denomination, 0) + 1);
                denominationQuantity.put(denomination, denominationQuantity.get(denomination) - 1);
                changeToReturn -= denomination.getValue();
            }
        }

        // If there is still change to return, then it's not possible to return the exact change
        if (changeToReturn > 0) {
            // Handle this case as needed, for example, you can throw an exception
            throw new RuntimeException("Cannot return the exact change");
        }

        productSelected = null;
        denominationAdded = new HashMap<>();

        return returnDenomination;
    }

    private int calculateTotalDenominationAdded() {
        int totalValue = 0;
        for (Map.Entry<Denomination, Integer> entry : denominationAdded.entrySet()) {
            totalValue += entry.getKey().getValue() * entry.getValue();
        }
        return totalValue;
    }

    private void removeProductFromProductsQuantity(Product product) {
        productsQuantity.put(product, productsQuantity.get(product) - 1);
    }

    private void addDenomToDenomQuantity() {
        for (Map.Entry<Denomination, Integer> denomination : denominationAdded.entrySet()) {
            denominationQuantity.put(denomination.getKey(), denominationQuantity.getOrDefault(denomination.getKey(), 0) + denomination.getValue());
        }
    }


}
