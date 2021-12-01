package com.example.portapantry.pojos;

public class FoodAllergy {
    private int id;
    private String name;


    //Read
    public FoodAllergy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Write
    public FoodAllergy (String name) {
        this.name = name;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {return name;}

}
