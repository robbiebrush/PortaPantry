package com.example.portapantry;

import com.example.portapantry.database.DBConsts;
import com.example.portapantry.database.Database;
import com.example.portapantry.tabs.AddFoodTab;
import com.example.portapantry.tabs.FoodTab;
import com.example.portapantry.tabs.StatsFoodTab;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    public static TabPane tabPane;

    @Override
    public void start(Stage stage) throws Exception {
        //Main scene
        BorderPane mainRoot = new BorderPane();
        MenuBar menu = new MenuBar();

        Menu fileMenu = new Menu("File");
        Menu creditsMenu = new Menu("Credits");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e->{
            System.exit(0);
        });
        fileMenu.getItems().add(exit);
        menu.getMenus().addAll(fileMenu, creditsMenu);
        mainRoot.setTop(menu);

        tabPane = new TabPane();

        mainRoot.setCenter(tabPane);
        Scene mainScene = new Scene(mainRoot, 1024, 768);

        //Login scene
        GridPane loginRoot = new GridPane();

        Text labelWelcome = new Text("Welcome to PortaPantry");

        loginRoot.add(labelWelcome, 0, 0);

        Text labelInstructions = new Text("Please enter your database,\nusername, and password.");
        loginRoot.add(labelInstructions, 0, 1);

        Text labelDB = new Text("Database: ");
        loginRoot.add(labelDB, 0,2);
        TextField db = new TextField();
        loginRoot.add(db, 1,2);

        Text labelUser = new Text("Username: ");
        loginRoot.add(labelUser, 0,3);
        TextField user = new TextField();
        loginRoot.add(user, 1,3);

        Text labelPass = new Text("Password: ");
        loginRoot.add(labelPass, 0,4);
        TextField pass = new TextField();
        loginRoot.add(pass, 1,4);

        Button loginButt = new Button("Login");
        loginButt.setOnAction(e->{
            DBConsts.DB_NAME = String.valueOf(db.getText());
            DBConsts.DB_USER = String.valueOf(user.getText());
            DBConsts.DB_PASS = String.valueOf(pass.getText());
            Database.getInstance();
            AddFoodTab addFoodTab = AddFoodTab.getInstance();
            FoodTab foodTab = FoodTab.getInstance();
            StatsFoodTab statsFoodTab = StatsFoodTab.getInstance();
            tabPane.getTabs().addAll(foodTab, addFoodTab, statsFoodTab);
            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
            stage.setTitle("PortaPantry");
            stage.setScene(mainScene);
            stage.show();
        });
        loginRoot.add(loginButt,0,5);
        loginRoot.setAlignment(Pos.CENTER);

        Scene loginScene = new Scene(loginRoot, 1024, 768);
        stage.setTitle("PortaPantry Login");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}