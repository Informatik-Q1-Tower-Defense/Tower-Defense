package View;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class LibraryView extends View {

    private Image tower = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/Tower.png");

    public LibraryView(int x, int y, int height) {

        super(60, height);
        super.setCenter(x, y);
    }

    @Override
    public Node[] body() {

        ArrayList<Node> nodes = new ArrayList<Node>();

        boolean condition = true;

        for(int y = 0; y < super.getHeight(); y++) {

            for(int x = 0; x < super.getWidth(); x++) {

                if(condition) {

                    Rectangle rect = new Rectangle();
                    rect.setFill(Color.DARKGREY);
                    rect.setWidth(30);
                    rect.setHeight(30);
                    rect.setLayoutX(x * 30);
                    rect.setLayoutY(y * 30);
                    nodes.add(rect);

                    condition = false;
                }
                else {

                    Rectangle rect = new Rectangle();
                    rect.setFill(Color.LIGHTGRAY);
                    rect.setWidth(30);
                    rect.setHeight(30);
                    rect.setLayoutX(x * 30);
                    rect.setLayoutY(y * 30);
                    nodes.add(rect);

                    condition = true;
                }
            }
        }

        Node[] nodesArray = new Node[nodes.size()];
        return nodes.toArray(nodesArray);
    }

    @Override
    public void update() {

    }
}
