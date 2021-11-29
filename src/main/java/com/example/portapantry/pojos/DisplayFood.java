package com.example.portapantry.pojos;

public class DisplayFood {
    private int id;
    private String name;
    private String foodGroup;
    private String foodAllergy;
    private String amount;
    private String expiryDate;

    public DisplayFood(int id, String name, String foodGroup, String foodAllergy, String amount, String expiryDate) {
        this.id = id;
        this.name = name;
        this.foodGroup = foodGroup;
        this.foodAllergy = foodAllergy;
        this.amount = amount;
        this.expiryDate = expiryDate;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getFoodGroup() { return foodGroup; }

    public void setFoodGroup(String foodGroup) { this.foodGroup = foodGroup; }

    public String getFoodAllergy() { return foodAllergy; }

    public void setFoodAllergy(String foodAllergy) { this.foodAllergy = foodAllergy; }

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }

    public String getExpiryDate() { return expiryDate; }

    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
<<<<<<< HEAD
                ", food group='" + foodGroup + '\'' +
                ", food allergy='" + foodAllergy + '\'' +
                ", amount='" + amount + '\'' +
                ", expiry date='" + expiryDate;
=======
                ", food_group='" + foodGroup + '\'' +
                ", food_allergy='" + foodAllergy + '\'' +
                ", amount='" + amount + '\'' +
                ", expiry_date='" + expiryDate;
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
    }
}
