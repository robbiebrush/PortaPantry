package com.example.portapantry.forms;

import com.example.portapantry.pojos.FoodGroup;
import com.example.portapantry.tables.FoodGroupsTable;
import com.example.portapantry.tables.FoodsTable;
import javafx.scene.control.Tab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class StatisticsTab extends Tab {
    private static StatisticsTab tab;
    public PieChart chart;

    private StatisticsTab() {
        this.setText("Statistics");
        BorderPane root = new BorderPane();
        chart = new PieChart();
        chart.setTitle("All Foods Found");
        chart.setLabelsVisible(true);
        root.setCenter(chart);
        generateChart();
        this.setContent(root);

    }

    public void generateChart(){
        FoodsTable foodsTable = new FoodsTable();
        FoodGroupsTable foodGroupsTable = new FoodGroupsTable();

        //Grab a list of the types of coins
        ArrayList<FoodGroup> foodGroups = foodGroupsTable.getAllFoodGroups();

        ArrayList<PieChart.Data> data = new ArrayList<>();

        // "PENNY", 5
        for (FoodGroup foodGroup: foodGroups) {
            double count = foodsTable.getFoodGroupCount(foodGroup.getId());
            if (count > 0) {
                data.add(new PieChart.Data(foodGroup.getName(), count));
            }
        }

        ObservableList<PieChart.Data> chartDate =
                FXCollections.observableArrayList(data);

        chart.setData(chartDate);
    }

    public static StatisticsTab getInstance(){
        if (tab == null){
            tab = new StatisticsTab();
        }
        return tab;
    }

}

