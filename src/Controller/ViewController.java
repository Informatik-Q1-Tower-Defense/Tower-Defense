package Controller;

import View.*;
import Model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ViewController extends Application {

    private View view;

    public static Map mapData;
    public static Player player = new Player(100, 1000);

    public void start(Stage primaryStage) {

        //view-Object erstellen (Ausgangspunkt des gesamten Programms)

        ViewController.mapData = new Map("levels/level_05.txt");

        this.view = new GameView(0, 0, ViewController.mapData);

        Pane root = new Pane();
        Scene scene = new Scene(root, this.view.getWidth(), this.view.getHeight());

        Node[] nodes = this.view.render();

        for(Node node: nodes) {

            root.getChildren().add(node);
        }

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("Tower Defense");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
