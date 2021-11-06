package Main;

import DatabaseClasses.Database;
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
    Scene scene1, scene2, scene3, scene4, scene5;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Database.getInstance();
        Text text = new Text();
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        text.setText("Hi how are you");
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
    }

    public static void main(String[] args) {
        launch();
    }
}
