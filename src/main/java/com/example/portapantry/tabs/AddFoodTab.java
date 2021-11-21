package com.example.portapantry.tabs;

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

public class AddFoodTab extends Tab {

    private AddFoodTab(){
        this.setText("Add Item");
        FoodGroupsTable foodGroupsTable = new FoodGroupsTable();
        FoodAllergiesTable foodAllergiesTable = new FoodAllergiesTable();
        FoodsTable foodsTable = new FoodsTable();

        GridPane root = new GridPane();

        Text labelName = new Text("Food: ");
        root.add(labelName, 0,4);
        TextField name = new TextField();
        root.add(name, 1,4);

        Text foodGroup = new Text("Food Group: ");
        root.add(foodGroup,0,0);
        ComboBox<FoodGroup> comboGroup = new ComboBox<>();
        comboGroup.setItems(
                FXCollections.observableArrayList(foodGroupsTable.getAllFoodGroups())
        );
        root.add(comboGroup, 1, 0);

        Text foodAllergy = new Text("Food Allergy: ");
        root.add(foodAllergy, 0,2);
        ComboBox<FoodAllergy> comboAllergy = new ComboBox<>();
        comboAllergy.setItems(
                FXCollections.observableArrayList(foodAllergiesTable.getAllFoodAllergies())
        );
        root.add(comboAllergy, 1,2);

        Text labelAmount = new Text("Amount: ");
        root.add(labelAmount, 0,4);
        TextField amount = new TextField();
        root.add(amount, 1,4);

        Text labelExpiry = new Text("Expiry Date: ");
        root.add(labelExpiry, 0,4);
        TextField expiry = new TextField();
        root.add(expiry, 1,4);

        Button submit = new Button("Add Food");
        submit.setOnAction(e->{
            Food food = new Food(
                    String.valueOf(name.getText()),
                    comboGroup.getSelectionModel().getSelectedItem().getId(),
                    comboAllergy.getSelectionModel().getSelectedItem().getId(),
                    String.valueOf(amount.getText()),
                    String.valueOf(expiry.getText()));
                    foodsTable.createFood(food);
                    EditFoodTab.getInstance().refreshTable();
                    StatsFoodTab.getInstance().generateChart();
        });
        root.add(submit,0,5);
        this.setContent(root);


    }

    public static AddFoodTab getInstance(){
        if(tab == null){
            tab = new AddFoodTab();
        }
        return tab;
    }

}
