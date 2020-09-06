package View;

import javafx.scene.Node;
import Model.Position;

public abstract class View {

    public Position center;

    public View(Position center) {

        this.center = center;
    }

    abstract protected Node[] getElements();

    public final Node[] render() {

        Node[] elements = this.getElements();

        for(Node element: elements) {

            element.setLayoutX(element.getLayoutX() + this.center.x);
            element.setLayoutY(element.getLayoutY() + this.center.y);
        }

        return elements;
    }
}
