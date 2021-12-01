package com.example.portapantry;

import com.example.portapantry.forms.AddFood;
import com.example.portapantry.forms.RemoveFood;
import com.example.portapantry.forms.StatisticsTab;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Javafx Class HelloApplication
 * displays the main GUI screen
 */
public class HelloApplication extends Application {
    public static TabPane tabPane;
    @Override
    public void start(Stage stage) throws Exception {

        BorderPane root = new BorderPane();
        //Build a menubar
        MenuBar menu = new MenuBar();
        //Build menu items
        Menu fileMenu = new Menu("File");
        Menu creditsMenu = new Menu("Credits");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e-> System.exit(0));
        fileMenu.getItems().add(exit);
        //Add menu items to the bar
        menu.getMenus().addAll(fileMenu, creditsMenu);
        root.setTop(menu);
        //Create TabPane
        tabPane = new TabPane();
        //Create the tabs
        AddFood addItemTab = AddFood.getInstance();
        RemoveFood removeItemTab = RemoveFood.getInstance();
        StatisticsTab statisticsTab = StatisticsTab.getInstance();
        tabPane.getTabs().addAll(addItemTab, removeItemTab, statisticsTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        //Configure tab closing policy
        //Add the menubar and tabpane to pane
        root.setCenter(tabPane);
        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("Portapantry");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



