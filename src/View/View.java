package View;

import javafx.scene.Node;
import Model.Position;
import java.util.ArrayList;

public abstract class View {

    private Position center;
    private int width, height;

    public View(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public final void setCenter(int x, int y) {

        this.center = new Position(x, y);
    }

    public final Position getCenter() {

        return this.center;
    }

    public final void setBounds(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public final int getWidth() {

        return this.width;
    }

    public final int getHeight() {

        return this.height;
    }

    abstract public Node[] body();

    public final Node[] render() {

        ArrayList<Node> nodes = new ArrayList<Node>();

        Node[] rawNodes = this.body();

        for (Node node: rawNodes) {

            node.setLayoutX(node.getLayoutX() + this.center.x);
            node.setLayoutY(node.getLayoutY() + this.center.y);

            nodes.add(node);
        }

        Node[] nodesArray = new Node[nodes.size()];
        return nodes.toArray(nodesArray);
    }
}
