package com.example.portapantry.doas;

import com.example.portapantry.pojos.FoodGroup;

import java.util.ArrayList;

public interface FoodGroupDOA {
    public ArrayList<FoodGroup> getAllFoodGroups();
    public FoodGroup getFoodGroup(int id);
}
