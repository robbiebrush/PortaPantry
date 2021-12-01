package com.example.portapantry.pojos;

public class Food {
    private int id;
    private String name;
    private int foodGroup;
    private int foodAllergy;
    private String amount;
    private String expiryDate;

    //Read
    public Food(int id, String name, int food_group, int food_allergy, String amount, String expiry_date) {
        this.id = id;
        this.name = name;
        this.foodGroup = food_group;
        this.foodAllergy = food_allergy;
        this.amount = amount;
        this.expiryDate = expiry_date;
    }

    //Write
    public Food(String name, int food_group, int food_allergy, String amount, String expiry_date) {
        this.name = name;
        this.foodGroup = food_group;
        this.foodAllergy = food_allergy;
        this.amount = amount;
        this.expiryDate = expiry_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public int getFoodGroup() { return foodGroup; }

    public void setFoodGroup(int food_group) { this.foodGroup = food_group; }

    public int getFoodAllergy() { return foodAllergy; }

    public void setFoodAllergy(int food_allergy) { this.foodAllergy = food_allergy; }

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }

    public String getExpiryDate() { return expiryDate; }

    public void setExpiryDate(String expiry_date) { this.expiryDate = expiry_date; }
}
