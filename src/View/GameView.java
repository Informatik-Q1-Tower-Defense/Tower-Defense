package View;

import Model.Map;
import javafx.scene.Node;

import java.util.ArrayList;

public class GameView extends View {

    private MapView map;
    private LibraryView library;

    public GameView(int x, int y, Map mapData) {

        super(0,0);
        map = new MapView(0,0,mapData);
        library = new LibraryView(map.getWidth(), 0, map.getHeight()/50);
        super.setBounds(map.getWidth() + 10 + library.getWidth(), map.getHeight());
        super.setCenter(x,y);
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
