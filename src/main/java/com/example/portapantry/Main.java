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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        BorderPane loginRoot = new BorderPane();
        VBox loginContent = new VBox();

        HBox welcome = new HBox();
        Text labelWelcome = new Text("Welcome to PortaPantry");
        labelWelcome.setTextAlignment(TextAlignment.CENTER);
        welcome.getChildren().add(labelWelcome);
        welcome.setAlignment(Pos.CENTER);

        HBox instructs = new HBox();
        Text labelInstructions = new Text("Please enter your database,\nusername, and password.");
        labelInstructions.setTextAlignment(TextAlignment.CENTER);
        instructs.getChildren().add(labelInstructions);
        instructs.setAlignment(Pos.CENTER);

        HBox dbInput = new HBox();
        Text labelDB = new Text("Database: ");
        TextField db = new TextField();
        dbInput.getChildren().addAll(labelDB, db);
        dbInput.setAlignment(Pos.CENTER);

        HBox userInput = new HBox();
        Text labelUser = new Text("Username: ");
        TextField user = new TextField();
        userInput.getChildren().addAll(labelUser, user);
        userInput.setAlignment(Pos.CENTER);

        HBox passInput = new HBox();
        Text labelPass = new Text("Password: ");
        TextField pass = new TextField();
        passInput.getChildren().addAll(labelPass, pass);
        passInput.setAlignment(Pos.CENTER);

        HBox button = new HBox();
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
        loginButt.setAlignment(Pos.CENTER);
        button.getChildren().add(loginButt);
        button.setAlignment(Pos.CENTER);

        loginContent.getChildren().addAll(welcome, instructs, dbInput, userInput, passInput, button);
        loginContent.setAlignment(Pos.CENTER);

        loginRoot.setCenter(loginContent);

        Scene loginScene = new Scene(loginRoot, 1024, 768);
        stage.setTitle("PortaPantry Login");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}