package com.example.portapantry.forms;

import com.example.portapantry.HelloApplication;
import com.example.portapantry.pojos.*;
import com.example.portapantry.tables.FoodAllergiesTable;
import com.example.portapantry.tables.FoodGroupsTable;
import com.example.portapantry.tables.FoodsTable;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class UpdateFood extends Tab {

    public UpdateFood(DisplayFood food){
        this.setText("Update " + food.getName());
        FoodAllergiesTable foodAllergiesTable = new FoodAllergiesTable();
        FoodGroupsTable foodGroupsTable = new FoodGroupsTable();
        FoodsTable foodsTable = new FoodsTable();

        Food updateFood = foodsTable.getFood(food.getId());

        GridPane root = new GridPane();
        Text name = new Text("Food Name: ");
        root.add(name,0,0);
        ComboBox<Food> comboName = new ComboBox<>();
        comboName.setItems(
                FXCollections.observableArrayList(foodsTable.getAllFoods()));
        root.add(comboName, 1, 0);
        Text location = new Text("Food Allergies:");
        root.add(location, 0,2);
        ComboBox<FoodAllergy> comboLocation = new ComboBox<>();
        comboLocation.setItems(
                FXCollections.observableArrayList(foodAllergiesTable.getAllFoodAllergies()));
        root.add(comboLocation, 1,2);

        Text condition = new Text("Food Group:");
        root.add(condition, 0,3);
        ComboBox<FoodGroup> comboCondition = new ComboBox<>();
        comboCondition.setItems(
                FXCollections.observableArrayList(foodGroupsTable.getAllFoodGroups()));
        root.add(comboCondition, 1,3);
        Text labelYear = new Text("Year");
        root.add(labelYear, 0,4);
        TextField year = new TextField();
        root.add(year, 1,4);

        Button submit = new Button("Update Food");
        submit.setOnAction(e->{
            updateFood.setName(comboName.getSelectionModel().getSelectedItem().getName());
            updateFood.setFoodGroup(comboCondition.getSelectionModel().getSelectedItem().getId());
            updateFood.setFoodAllergy(comboLocation.getSelectionModel().getSelectedItem().getId());
            updateFood.setExpiryDate(String.valueOf(year.getText()));
            foodsTable.updateFood(updateFood);
            RemoveFood.getInstance().refreshTable();
            StatisticsTab.getInstance().generateChart();
            HelloApplication.tabPane.getTabs().remove(this);
            HelloApplication.tabPane.getSelectionModel().select(RemoveFood.getInstance());

        });
        root.add(submit,0,5);
        this.setContent(root);
    }

}
