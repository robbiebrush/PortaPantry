package com.example.portapantry;

import com.example.portapantry.database.Database;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HelloApplication extends Application {

    Stage window;
    Scene mainScene, viewScene, addScene, editScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Database.getInstance();
        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setText("Welcome to your PortaPantry!");
        window = primaryStage;
        StackPane root = new StackPane();
        VBox vbox = new VBox(10);

        Button viewPantry = new Button("View your Pantry");
        viewPantry.setOnAction(e-> window.setScene(viewScene));

        StackPane root2 = new StackPane();
        Menu fileMenu = new Menu("food inventory");
        MenuBar menu = new MenuBar();
        menu.getMenus().addAll(fileMenu);
        root2.getChildren().add(menu);
        root2.setAlignment(Pos.TOP_LEFT);
        viewScene = new Scene(root2, 1024 ,768);

        Button addPantry = new Button("Add to Pantry");
        addPantry.setOnAction(e-> window.setScene(addScene));

        StackPane root3 = new StackPane();
        addScene = new Scene(root3, 1024 ,768);
        Menu fileMenu2 = new Menu("add a food");
        MenuBar menu2 = new MenuBar();
        menu2.getMenus().addAll(fileMenu2);
        root3.getChildren().add(menu2);
        root3.setAlignment(Pos.TOP_LEFT);

        Button editPantry = new Button("Edit your Pantry");
        editPantry.setOnAction(e-> window.setScene(editScene));

        StackPane root4 = new StackPane();
        editScene = new Scene(root4, 1024 ,768);
        Menu fileMenu3 = new Menu("update a food");
        MenuBar menu3 = new MenuBar();
        menu3.getMenus().addAll(fileMenu3);
        root4.getChildren().add(menu3);
        root4.setAlignment(Pos.TOP_LEFT);

        vbox.getChildren().addAll(text, viewPantry, addPantry, editPantry);
        root.getChildren().add(vbox);
        vbox.setAlignment(Pos.CENTER);
        window.setTitle("PortaPantry");

        mainScene = new Scene(root, 1024, 768);
        window.setScene(mainScene);
        window.show();
    }

    public static void main(String[] args) {
        launch();
    }
}