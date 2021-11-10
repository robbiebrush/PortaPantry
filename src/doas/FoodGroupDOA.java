package doas;

import pojos.FoodGroup;

import java.util.ArrayList;

public interface FoodGroupDOA {
    public ArrayList<FoodGroup> getAllFoodGroups();
    public FoodGroup getFoodGroup(int id);
}
