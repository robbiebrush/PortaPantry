package doas;

import pojos.FoodAllergy;

import java.util.ArrayList;

public interface FoodAllergyDOA {
    public ArrayList<FoodAllergy> getAllFoodAllergies();
    public FoodAllergy getFoodAllergy(int id);
}
