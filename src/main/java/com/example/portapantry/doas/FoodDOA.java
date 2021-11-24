package com.example.portapantry.doas;


import com.example.portapantry.pojos.Food;

import java.util.ArrayList;

public interface FoodDOA {
    public void createFood(Food food);
    public ArrayList<Food> getAllFoods();
    public Food getFood(int id);
    public void updateFood(Food food);
    public void deleteFood(int food);

}
