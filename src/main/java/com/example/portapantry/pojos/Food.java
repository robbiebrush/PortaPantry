package com.example.portapantry.pojos;

public class Food {
    private int id;
    private String name;
    private int foodGroup;
    private int foodAllergy;
    private String amount;
    private String expiryDate;

<<<<<<< HEAD
    public Food(int id, String name, int foodGroup, int foodAllergy, String amount, String expiryDate) {
        this.id = id;
        this.name = name;
        this.foodGroup = foodGroup;
        this.foodAllergy = foodAllergy;
        this.amount = amount;
        this.expiryDate = expiryDate;
    }

    public Food(String name, int foodGroup, int foodAllergy, String amount, String expiryDate) {
        this.name = name;
        this.foodGroup = foodGroup;
        this.foodAllergy = foodAllergy;
        this.amount = amount;
        this.expiryDate = expiryDate;
=======
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
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
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

<<<<<<< HEAD
    public void setFoodGroup(int foodGroup) { this.foodGroup = foodGroup; }

    public int getFoodAllergy() { return foodAllergy; }

    public void setFoodAllergy(int foodFacts) { this.foodAllergy = foodAllergy; }
=======
    public void setFoodGroup(int food_group) { this.foodGroup = food_group; }

    public int getFoodAllergy() { return foodAllergy; }

    public void setFoodAllergy(int food_allergy) { this.foodAllergy = food_allergy; }
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }

    public String getExpiryDate() { return expiryDate; }

<<<<<<< HEAD
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

=======
    public void setExpiryDate(String expiry_date) { this.expiryDate = expiry_date; }
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
}
