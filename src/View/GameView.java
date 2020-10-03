package View;

import Model.Map;
import javafx.scene.Node;
import Model.Wave;
import java.util.ArrayList;

public class GameView extends View {

    public MapView map;
    private LibraryView library;

    public GameView(int x, int y, Map mapData) {

        super(0,0);
        map = new MapView(0,0,mapData);
        library = new LibraryView(map.getWidth(), 0, map.getHeight()/60);
        super.setBounds(map.getWidth() + library.getWidth(), map.getHeight());
        super.setCenter(x,y);

        Wave wave = new Wave(1);
        map.addWave(wave);
        wave.enemyList.getFirst().move();
        this.update();
    }

    @Override
    public Node[] body() {

        ArrayList<Node> nodes = new ArrayList<Node>();

        Node[] mapView = map.render();

        for(Node node: mapView) {

            nodes.add(node);
        }

        Node[] libraryView = library.render();

        for(Node node: libraryView) {

            nodes.add(node);
        }

        Node[] nodesArray = new Node[nodes.size()];
        return nodes.toArray(nodesArray);
    }

    @Override
    public void update() {

        map.update();
        library.update();
    }
}
