package Controller;

import View.*;
import Model.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.File;

public class ViewController extends Application {

    private Stage stage;
    private Thread game;

    public void start(Stage primaryStage) {

        this.stage = primaryStage;

        //view-Object erstellen (Ausgangspunkt des gesamten Programms)

        Player.setMap(new Map("levels/level_05.txt"));
        Player.setMoney(1000);
        Player.setHp(1000000);
        Player.setOnGameOver(() -> {
            game.interrupt();

            MenuView menu = new MenuView();
            menu.setOnSelection((file -> didStartGame(file)));

            show(menu);
        });

        //KonfigurationsTeil

        MenuView menu = new MenuView();
        menu.setOnSelection((file -> didStartGame(file)));

        show(menu);
    }

    private void didStartGame(File file) {

        Map mapData = new Map(file.getPath());
        MapView view = new MapView(mapData);

        show(new GameView(0, 0, view));

        game = new Thread(new GameController(view, 1));
        game.setDaemon(true);
        game.start();
    }

    private void show(View view) {

        Pane root = new Pane();
        Scene scene = new Scene(root, view.getWidth(), view.getHeight());

        Node[] nodes = view.render();

        for(Node node: nodes) {

            root.getChildren().add(node);
        }

        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setTitle("Tower Defense");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
