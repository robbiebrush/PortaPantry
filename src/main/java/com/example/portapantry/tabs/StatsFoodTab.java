package com.example.portapantry.tabs;

import com.example.portapantry.pojos.FoodGroup;
import com.example.portapantry.tables.FoodGroupsTable;
import com.example.portapantry.tables.FoodsTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class StatsFoodTab extends Tab {
    private static StatsFoodTab tab;
    public PieChart chart;

    private StatsFoodTab() {
        this.setText("Food Groups");
        BorderPane root = new BorderPane();
        chart = new PieChart();
        chart.setTitle("Food Groups");
        chart.setLabelsVisible(true);
        root.setCenter(chart);
        generateChart();
        this.setContent(root);

    }

    public void generateChart() {
        FoodsTable foodsTable = new FoodsTable();
        FoodGroupsTable foodGroupsTable = new FoodGroupsTable();

        //Grab a list of the food groups
        ArrayList<FoodGroup> foodGroups = foodGroupsTable.getAllFoodGroups();

        ArrayList<PieChart.Data> data = new ArrayList<>();

        for (FoodGroup foodGroup : foodGroups) {
            double count = foodsTable.getFoodGroupCount(foodGroup.getId());
            if (count > 0) {
                data.add(new PieChart.Data(foodGroup.getName(), count));
            }
        }

        ObservableList<PieChart.Data> chartDate =
                FXCollections.observableArrayList(data);

        chart.setData(chartDate);
    }

    public static StatsFoodTab getInstance() {
        if (tab == null) {
            tab = new StatsFoodTab();
        }
        return tab;
    }
}