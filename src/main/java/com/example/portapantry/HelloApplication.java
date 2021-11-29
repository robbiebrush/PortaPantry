package com.example.portapantry;

import com.example.portapantry.database.Database;
import com.example.portapantry.tabs.AddFoodTab;
import com.example.portapantry.tabs.EditFoodTab;
import com.example.portapantry.tabs.FoodTab;
import com.example.portapantry.tabs.StatsFoodTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    public static TabPane tabPane;

    @Override
    public void start(Stage stage) throws Exception {
        Database.getInstance();

        BorderPane root = new BorderPane();
        //Build a menubar
        MenuBar menu = new MenuBar();
        //Build menu items
        Menu fileMenu = new Menu("File");
        Menu creditsMenu = new Menu("Credits");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e->{
            System.exit(0);
        });
        fileMenu.getItems().add(exit);
        //Add menu items to the bar
        menu.getMenus().addAll(fileMenu, creditsMenu);
        root.setTop(menu);

        tabPane = new TabPane();
        //Create the tabs
        AddFoodTab addFoodTab = AddFoodTab.getInstance();
        FoodTab foodTab = FoodTab.getInstance();
        StatsFoodTab statsFoodTab = StatsFoodTab.getInstance();
        tabPane.getTabs().addAll(foodTab, addFoodTab, statsFoodTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);


        //Configure tab closing policy
        //Add the menubar and tabpane to pane
        root.setCenter(tabPane);
        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("PortaPantry");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}