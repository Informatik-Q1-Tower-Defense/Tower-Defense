package Controller;

import View.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewController extends Application {

    protected View view;

    public void start(Stage primaryStage) {

        //view-Object erstellen (Ausgangspunkt des gesamten Programms)

        Pane root = new Pane();
        Scene scene = new Scene(root, this.view.getWidth(), this.view.getHeight());

        root.getChildren().addAll(view.render());

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("Tower Defense");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
