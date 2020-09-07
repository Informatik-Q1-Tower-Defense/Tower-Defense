package View;

import javafx.scene.Node;
import Model.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class MapView extends View {

    private Rectangle[][] map;

    public MapView(int x, int y, Map mapData) {

        super(mapData.width * 30, mapData.height * 30);
        super.setCenter(x,y);

        this.map = new Rectangle[mapData.width][mapData.height];

        for(int xValue = 0; x < mapData.width; xValue++) {

            for(int yValue = 0; x < mapData.height; yValue++) {

                this.map[xValue][yValue] = new Rectangle();
                this.map[xValue][yValue].setHeight(30);
                this.map[xValue][yValue].setWidth(30);
                this.map[xValue][yValue].setLayoutX(xValue * 30);
                this.map[xValue][yValue].setLayoutY(yValue * 30);
                this.map[xValue][yValue].setFill(Color.GRAY);
            }
        }

        for(Position element: mapData.avaidablePositions) {

            this.map[element.x][element.y].setFill(Color.YELLOW);
        }
        for(Position element: mapData.way) {

            this.map[element.x][element.y].setFill(Color.BLUE);
        }
        for(Tower tower: mapData.towers) {

            this.map[tower.getPosition().x][tower.getPosition().y].setFill(Color.RED);
        }
    }

    public Node[] body() {

        ArrayList<Node> nodes = new ArrayList<Node>();

        for(Rectangle[] column: this.map) {

            for(Rectangle rect: column) {

                nodes.add(rect);
            }
        }

        Node[] nodesArray = new Node[nodes.size()];
        return nodes.toArray(nodesArray);
    }
}
