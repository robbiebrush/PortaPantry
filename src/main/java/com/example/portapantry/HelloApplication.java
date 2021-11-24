package com.example.portapantry;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import com.example.portapantry.tabs.AddFoodTab;
import com.example.portapantry.tabs.RemoveFoodTab;
import com.example.portapantry.tabs.StatsFoodTab;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Javafx Class HelloApplication
 */

public class HelloApplication extends Application {

    public static TabPane tabPane;

    @Override
    public void start(Stage stage) throws Exception {
        //Database.getInstance();

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
        RemoveFoodTab removeFoodTab = RemoveFoodTab.getInstance();
        StatsFoodTab statsFoodTab = StatsFoodTab.getInstance();
        tabPane.getTabs().addAll(addFoodTab, removeFoodTab, statsFoodTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Text title = new Text();
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        title.setText("Welcome to your PortaPantry!");
        VBox vbox = new VBox(10);

        //Configure tab closing policy
        //Add the menubar and tabpane to pane
        vbox.getChildren().add(title);
        root.getChildren().addAll(vbox, tabPane);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 1024, 768);
        stage.setTitle("PortaPantry");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
