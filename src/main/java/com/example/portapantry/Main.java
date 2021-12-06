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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {

    public static TabPane tabPane;

    @Override
    public void start(Stage stage) throws Exception {

        //Main scene
        BorderPane mainRoot = new BorderPane();
        MenuBar menu = new MenuBar();

        Menu fileMenu = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e->{
            System.exit(0);
        });
        fileMenu.getItems().add(exit);
        menu.getMenus().addAll(fileMenu);
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

        HBox images = new HBox();

        Image fridge = new Image("file:src/main/java/com/example/portapantry/imgs/fridge.jpg");
        Image arrow = new Image("file:src/main/java/com/example/portapantry/imgs/arrow.jpg");
        Image phone = new Image("file:src/main/java/com/example/portapantry/imgs/smartphone.jpg");

        HBox fridgeContainer = new HBox();
        fridgeContainer.getStyleClass().add("image-container");
        ImageView fridgeView = new ImageView();
        fridgeView.setImage(fridge);
        fridgeContainer.getChildren().add(fridgeView);

        ImageView arrowView = new ImageView();
        arrowView.setImage(arrow);

        HBox phoneContainer = new HBox();
        phoneContainer.getStyleClass().add("image-container");
        ImageView phoneView = new ImageView();
        phoneView.setImage(phone);
        phoneContainer.getChildren().add(phoneView);

        images.getChildren().addAll(fridgeContainer, arrowView, phoneContainer);
        images.setAlignment(Pos.CENTER);

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
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(
                        "src/main/java/com/example/portapantry/database/userInfo.txt"));
                bw.write(db.getText() + "\n" + user.getText() + "\n" + pass.getText());
                bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            String dbName = "";
            String dbUser = "";
            String dbPass = "";
            try {
                BufferedReader br = new BufferedReader(new FileReader(
                        "src/main/java/com/example/portapantry/database/userInfo.txt"));
                dbName = br.readLine();
                dbUser = br.readLine();
                dbPass = br.readLine();
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            DBConsts.DB_NAME = dbName;
            DBConsts.DB_USER = dbUser;
            DBConsts.DB_PASS = dbPass;
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

        loginContent.getChildren().addAll(welcome, instructs, images, dbInput, userInput, passInput, button);
        loginContent.setAlignment(Pos.CENTER);

        loginRoot.setCenter(loginContent);
        Scene loginScene = new Scene(loginRoot, 1024, 768);
        mainRoot.getStylesheets().add("/Styles.css");
        loginScene.getStylesheets().add("/Styles.css");

        stage.setTitle("PortaPantry Login");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}