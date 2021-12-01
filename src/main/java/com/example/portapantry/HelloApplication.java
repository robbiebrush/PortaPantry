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

<<<<<<< HEAD
/**
 * Javafx Class HelloApplication
 * displays the main GUI screen
 */
=======
>>>>>>> cbc0a7c69b4c6611d5d41c809afe784e4cff3a56
public class HelloApplication extends Application {
    public static TabPane tabPane;
    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< HEAD

=======
//        CoinTable coinTable = new CoinTable();
//        for (Coin coin: coinTable.getAllCoins()) {
//            System.out.println(coin.getName());
//        }
>>>>>>> cbc0a7c69b4c6611d5d41c809afe784e4cff3a56
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
<<<<<<< HEAD
        stage.setTitle("Portapantry");
=======
        stage.setTitle("Hello!");
>>>>>>> cbc0a7c69b4c6611d5d41c809afe784e4cff3a56
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
<<<<<<< HEAD
}



=======
}
>>>>>>> cbc0a7c69b4c6611d5d41c809afe784e4cff3a56
