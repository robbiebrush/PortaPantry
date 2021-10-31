package doas;

import pojos.FoodFact;

import java.util.ArrayList;

public interface FoodFactDOA {
    public void createFoodFact(FoodFact foodFact);
    public ArrayList<FoodFact> getAllFoodFacts();
    public FoodFact getFoodFact(int id);
    public void updateFoodFact(FoodFact foodFact);
    public void deleteFoodFact(FoodFact foodFact);
}
