package View;

import Model.Map;
import javafx.scene.Node;
import java.util.ArrayList;

public class GameView extends View {

    public MapView map;
    private LibraryView library;

    public GameView(int x, int y, MapView map) {

        super(0,0);
        this.map = map;
        this.map.setCenter(0, 0);
        library = new LibraryView(map.getWidth(), 0, map.getHeight()/60);
        super.setBounds(map.getWidth() + library.getWidth(), map.getHeight());
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
