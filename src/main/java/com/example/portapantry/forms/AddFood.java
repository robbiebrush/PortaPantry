package com.example.demo2;

import javafx.scene.control.Tab;

public class AddFood extends Tab {
    private static AddFood tab;

    private AddFood(){
        this.setText("Add Food");

    }

    public static AddFood getInstance(){
        if(tab == null){
            tab = new AddFood();
        }
        return tab;
    }
}

