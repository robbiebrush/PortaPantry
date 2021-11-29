package com.example.portapantry.pojos;

public class FoodAllergy {
    private int id;
    private String name;

<<<<<<< HEAD
=======
    //Read
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
    public FoodAllergy(int id, String name) {
        this.id = id;
        this.name = name;
    }

<<<<<<< HEAD
=======
    //Write
    public FoodAllergy (String name) {
        this.name = name;
    }

>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
<<<<<<< HEAD
=======

    @Override
    public String toString() {return name;}
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
}
