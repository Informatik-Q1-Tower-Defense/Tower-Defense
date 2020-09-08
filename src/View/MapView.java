package View;

import javafx.scene.Node;
import Model.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class MapView extends View {

    private ImageView[][] map;

    private Image border = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/Border.png");
    private Image grass = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/Grass.png");
    private Image tower = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/Tower.png");
    private Image way = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/Way.png");
    private Image tree = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/Tree.png");

    public MapView(int x, int y, Map mapData) {

        super(mapData.width * 30, mapData.height * 30);
        super.setCenter(x,y);

        this.map = new ImageView[mapData.width][mapData.height];

        for(int xValue = 0; xValue < mapData.width; xValue++) {

            for(int yValue = 0; yValue < mapData.height; yValue++) {

                this.map[xValue][yValue] = new ImageView(this.border);
                this.map[xValue][yValue].setLayoutX(xValue * 30);
                this.map[xValue][yValue].setLayoutY(yValue * 30);
            }
        }

        double randomNumber = 0.0;

        for(Position element: mapData.avaidablePositions) {

            randomNumber = Math.random();

            if (randomNumber < 0.667) {

                this.map[element.x][element.y].setImage(this.grass);
            }
            else {

                this.map[element.x][element.y].setImage(this.tree);
            }
        }
        for(Position element: mapData.way) {

            this.map[element.x][element.y].setImage(this.way);
        }
        for(Tower tower: mapData.towers) {

            this.map[tower.getPosition().x][tower.getPosition().y].setImage(this.tower);
        }
    }

    public Node[] body() {

        ArrayList<Node> nodes = new ArrayList<Node>();

        for(ImageView[] column: this.map) {

            for(ImageView imageView: column) {

                nodes.add(imageView);
            }
        }

        Node[] nodesArray = new Node[nodes.size()];
        return nodes.toArray(nodesArray);
    }
}
