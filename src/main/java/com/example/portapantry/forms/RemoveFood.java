package com.example.demo2;

import javafx.scene.control.Tab;

public class RemoveFood extends Tab {
    private static RemoveFood tab;

    private RemoveFood(){
        this.setText("Remove Food");
    }

    public static RemoveFood getInstance(){
        if(tab == null){
            tab = new RemoveFood();
        }
        return tab;
    }
}

