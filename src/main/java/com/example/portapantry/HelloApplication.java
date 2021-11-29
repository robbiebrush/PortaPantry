package com.example.portapantry;

import com.example.portapantry.database.Database;
<<<<<<< HEAD
import com.example.portapantry.forms.AddFood;
import com.example.portapantry.forms.RemoveFood;
import com.example.portapantry.forms.StatisticsTab;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5;



    @Override
    public void start(Stage primaryStage) throws Exception {


        AddFood addfood = AddFood.getInstance();
        RemoveFood removefood = RemoveFood.getInstance();
        StatisticsTab statisticsTab = StatisticsTab.getInstance();
        tabPane.getTabs().addAll(addfood, removefood, statisticsTab);
        Database.getInstance();
        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setText("PortaPantry");
        window = primaryStage;
        StackPane root = new StackPane();
        VBox vbox = new VBox(10);

        Button button1 = new Button("view your food");
        button1.setOnAction(e-> window.setScene(scene2));

        StackPane root2 = new StackPane();
        Menu fileMenu = new Menu("food inventory");
        MenuBar menu = new MenuBar();
        menu.getMenus().addAll(fileMenu);
        root2.getChildren().add(menu);
        root2.setAlignment(Pos.TOP_LEFT);
        scene2 = new Scene(root2, 1024 ,768);

        Button button2 = new Button("add a food");
        button2.setOnAction(e-> window.setScene(scene3));

        StackPane root3 = new StackPane();
        scene3 = new Scene(root3, 1024 ,768);
        Menu fileMenu2 = new Menu("add a food");
        MenuBar menu2 = new MenuBar();
        menu2.getMenus().addAll(fileMenu2);
        root3.getChildren().add(menu2);
        root3.setAlignment(Pos.TOP_LEFT);

        Button button3 = new Button("update a food");
        button3.setOnAction(e-> window.setScene(scene4));

        StackPane root4 = new StackPane();
        scene4 = new Scene(root4, 1024 ,768);
        Menu fileMenu3 = new Menu("update a food");
        MenuBar menu3 = new MenuBar();
        menu3.getMenus().addAll(fileMenu3);
        root4.getChildren().add(menu3);
        root4.setAlignment(Pos.TOP_LEFT);

        Button button4 = new Button("delete a food");
        button4.setOnAction(e-> window.setScene(scene5));

        StackPane root5 = new StackPane();
        scene5 = new Scene(root5, 1024 ,768);
        Menu fileMenu4 = new Menu("delete a food");
        MenuBar menu4 = new MenuBar();
        menu4.getMenus().addAll(fileMenu4);
        root5.getChildren().add(menu4);
        root5.setAlignment(Pos.TOP_LEFT);

        vbox.getChildren().addAll(text, button1, button2, button3, button4);
        root.getChildren().add(vbox);
        vbox.setAlignment(Pos.CENTER);
        window.setTitle("My First Project");

        scene1 = new Scene(root, 1024, 768);
        window.setScene(scene1);
        window.show();
=======
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
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
    }

    public static void main(String[] args) {
        launch();
    }
<<<<<<< HEAD
}

=======
}
>>>>>>> bfa115722bc2d07599529a3a6bf1019fe377970f
