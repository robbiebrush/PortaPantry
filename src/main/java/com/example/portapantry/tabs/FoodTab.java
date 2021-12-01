package com.example.portapantry.tabs;

import com.example.portapantry.Main;
import com.example.portapantry.pojos.DisplayFood;
import com.example.portapantry.tables.FoodsTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class FoodTab extends Tab{

    private static FoodTab tab;
    public TableView tableView;

    private FoodTab(){
        this.setText("Your Food");
        FoodsTable foodsTable = new FoodsTable();
        BorderPane root = new BorderPane();
        tableView = new TableView();

        TableColumn<DisplayFood, String> column1 =
                new TableColumn<>("Food Name");
        column1.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getName()));

        TableColumn<DisplayFood, String> column2 =
                new TableColumn<>("Food Group");
        column2.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getFoodGroup()));

        TableColumn<DisplayFood, String> column3 =
                new TableColumn<>("Food Allergy");
        column3.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getFoodAllergy()));

        TableColumn<DisplayFood, String> column4 =
                new TableColumn<>("Amount");
        column4.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getAmount()));

        TableColumn<DisplayFood, String> column5 =
                new TableColumn<>("Expiry Date");
        column5.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getExpiryDate()));

        tableView.getColumns().addAll(column1, column2, column3, column4, column5);
        tableView.getItems().addAll(foodsTable.getPrettyFoods());

        root.setCenter(tableView);

        Button editButton = new Button("Edit Food");
        editButton.setOnAction(e->{
            DisplayFood food = (DisplayFood) tableView.getSelectionModel().getSelectedItem();
            EditFoodTab editFoodTab = new EditFoodTab(food);
            Main.tabPane.getTabs().add(editFoodTab);
            Main.tabPane.getSelectionModel().select(editFoodTab);
            refreshTable();
            StatsFoodTab.getInstance().generateChart();
        });

        Button removeButton = new Button("Remove Food");
        removeButton.setOnAction(e->{
            DisplayFood food = (DisplayFood) tableView.getSelectionModel().getSelectedItem();
            foodsTable.deleteFood(food.getId());
            refreshTable();
            StatsFoodTab.getInstance().generateChart();
        });

        Text helpText = new Text("**Select a table item before a button**");

        HBox buttons = new HBox();
        buttons.getChildren().addAll(editButton, removeButton, helpText);
        root.setBottom(buttons);

        this.setContent(root);
    }

    public static FoodTab getInstance(){
        if(tab == null){
            tab = new FoodTab();
        }
        return tab;
    }

    public void refreshTable(){
        FoodsTable table = new FoodsTable();
        tableView.getItems().clear();
        tableView.getItems().addAll(table.getPrettyFoods());
    }
}
