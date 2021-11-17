package com.example.portapantry.forms;

import javafx.scene.control.Tab;

public class StatisticsTab extends Tab {
    private static StatisticsTab tab;

    private StatisticsTab(){
        this.setText("Statistics");
    }

    public static StatisticsTab getInstance(){
        if (tab == null){
            tab = new StatisticsTab();
        }
        return tab;
    }

}
