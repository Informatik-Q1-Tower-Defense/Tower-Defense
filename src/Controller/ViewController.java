package Controller;

import View.*;
import Model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ViewController extends Application {

    protected View view;

    public void start(Stage primaryStage) {

        //view-Object erstellen (Ausgangspunkt des gesamten Programms)

        Map map = new Map("Path");

        this.view = new MapView(0, 0, map);

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
