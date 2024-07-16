package io.github.srujangajul.cvm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CoffeeVendingMachine {
    List<Beverage> beverages;
    List<Ingredient> ingredients;
    Beverage selectedBeverage;

    public void addIngredient(Ingredient ingredient) {
        for (Ingredient ingredient1 : ingredients) {
            if (ingredient1.getName().equals(ingredient.getName())) {
                ingredient1.setQuantity(ingredient1.getQuantity() + ingredient.getQuantity());
                return;
            }
        }
        ingredients.add(ingredient);
    }

    public void selectBeverage(int beverageId){
        for(Beverage beverage: beverages){
            if(beverage.getId() == beverageId){
                selectedBeverage = beverage;
                break;
            }
        }
    }

    public List<String> showMenu(){
        return beverages.stream().map(Beverage::getName).collect(Collectors.toList());
    }


    public synchronized Beverage dispenseBeverage(Payment payment){
        if(hasEnoughIngredients()){
            updateIngredient();
        }
        if(payment.getAmount() >= selectedBeverage.getCost()){
            double change = payment.getAmount() - selectedBeverage.getCost();
        }
    }

}
