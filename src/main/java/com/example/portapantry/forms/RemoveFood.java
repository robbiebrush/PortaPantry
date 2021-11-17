package com.example.portapantry.forms;

import com.example.portapantry.HelloApplication;
import com.example.portapantry.pojos.DisplayFood;
import com.example.portapantry.pojos.Food;
import com.example.portapantry.pojos.FoodGroup;
import com.example.portapantry.tables.FoodGroupsTable;
import com.example.portapantry.tables.FoodsTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class RemoveFood extends Tab {
    private static RemoveFood tab;
    public TableView tableView;
    PieChart chart;
    private RemoveFood(){
        this.setText("Remove Item");
        FoodsTable foodsTable = new FoodsTable();
        BorderPane root = new BorderPane();
        tableView = new TableView();

        TableColumn<DisplayFood, String> column1 =
                new TableColumn<>("Coin Name");
        column1.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getName()));

        TableColumn<DisplayFood, String> column2 =
                new TableColumn<>("Coin Condition");
        column2.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getFoodGroup()));

        TableColumn<DisplayFood, String> column3 =
                new TableColumn<>("Coin Year");
        column3.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getFoodAllergy()));

        TableColumn<DisplayFood, String> column4 =
                new TableColumn<>("Coin Location");
        column4.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getExpiryDate()));

        tableView.getColumns().addAll(column1, column2, column3, column4);
        tableView.getItems().addAll(foodsTable.getPrettyFoods());

        root.setCenter(tableView);
        Button removeButton = new Button("Remove Record");
        removeButton.setOnAction(e->{
            DisplayFood food = (DisplayFood) tableView.getSelectionModel().getSelectedItem();
            foodsTable.deleteFood(food.getId());
            refreshTable();
            generateChart();
        });
        chart = new PieChart();
        chart.setTitle("All Coins Found");
        chart.setLabelsVisible(true);
        root.setRight(chart);
        generateChart();

        Button updateButton = new Button("Update");
        updateButton.setOnAction(e->{
            DisplayFood food = (DisplayFood) tableView.getSelectionModel().getSelectedItem();
            UpdateFood tab = new UpdateFood(food);
            HelloApplication.tabPane.getTabs().add(tab);
            HelloApplication.tabPane.getSelectionModel().select(tab);
        });
        HBox buttons = new HBox();
        buttons.getChildren().addAll(removeButton, updateButton);
        root.setBottom(buttons);

        this.setContent(root);
    }

    public static RemoveFood getInstance(){
        if(tab == null){
            tab = new RemoveFood();
        }
        return tab;
    }

    public void refreshTable(){
        FoodsTable table = new FoodsTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getPrettyFoods());
    }
    public void generateChart(){
        FoodsTable itemTable = new FoodsTable();
        FoodGroupsTable foodGroupsTable = new FoodGroupsTable();

        //Grab a list of the types of Foods
        ArrayList<FoodGroup> foods = foodGroupsTable.getAllFoodGroups();

        ArrayList<PieChart.Data> data = new ArrayList<>();

        // "PENNY", 5
        for (Coin coin : coins) {
            double count = itemTable.getItemCount(coin.getId());
            if (count > 0) {
                data.add(new PieChart.Data(coin.getName(), count));
            }
        }

        ObservableList<PieChart.Data> chartDate =
                FXCollections.observableArrayList(data);

        chart.setData(chartDate);
    }

}

