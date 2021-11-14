package com.example.portapantry.doas;

import com.example.portapantry.pojos.FoodAllergy;

import java.util.ArrayList;

public interface FoodAllergyDOA {
    public ArrayList<FoodAllergy> getAllFoodAllergies();
    public FoodAllergy getFoodAllergy(int id);
}
