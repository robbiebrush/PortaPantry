package com.example.portapantry.forms;

import com.example.portapantry.pojos.Food;
import com.example.portapantry.pojos.FoodAllergy;
import com.example.portapantry.pojos.FoodGroup;
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

public class AddFood extends Tab {
    private static AddFood tab;

    private AddFood(){
        this.setText("Add Food");
        FoodAllergiesTable foodAllergiesTable = new FoodAllergiesTable();
        FoodGroupsTable foodGroupsTable = new FoodGroupsTable();
        FoodsTable foodsTable = new FoodsTable();

        GridPane root = new GridPane();

        Text LabelName = new Text("Food Name: ");
        root.add(LabelName,0,4);
        TextField name = new TextField();
        root.add(name, 1,4);

        Text foodGroup = new Text("Food Group: ");
        root.add(foodGroup, 0,2);
        ComboBox<FoodGroup> comboFoodGroup = new ComboBox<>();
        comboFoodGroup.setItems(
                FXCollections.observableArrayList(foodGroupsTable.getAllFoodGroups())
        );
        root.add(comboFoodGroup, 1,2);

        Text foodAllergy = new Text("Food Allergy: ");
        root.add(foodAllergy, 0,3);
        ComboBox<FoodAllergy> comboFoodAllergy = new ComboBox<>();
        comboFoodAllergy.setItems(
                FXCollections.observableArrayList(foodAllergiesTable.getAllFoodAllergies())
        );
        root.add(comboFoodAllergy, 1,3);

        Text labelAmount = new Text("Amount: ");
        root.add(labelAmount, 0,4);
        TextField amount = new TextField();
        root.add(amount, 1,4);

        Text labelYear = new Text("Expiry Date:");
        root.add(labelYear, 0,4);
        TextField expiryDate = new TextField();
        root.add(expiryDate, 1,4);

        Button submit = new Button("Submit");
        submit.setOnAction(e->{
            Food food = new Food(
                    String.valueOf(name.getText()),
                    comboFoodGroup.getSelectionModel().getSelectedItem().getId(),
                    comboFoodAllergy.getSelectionModel().getSelectedItem().getId(),
                    String.valueOf(amount.getText()),
                    String.valueOf(expiryDate.getText()));
            foodsTable.createFood(food);
            StatisticsTab.getInstance().generateChart();
            RemoveFood.getInstance().refreshTable();
        });
        root.add(submit,0,5);
        this.setContent(root);


    }

    public static AddFood getInstance(){
        if(tab == null){
            tab = new AddFood();
        }
        return tab;
    }



}


