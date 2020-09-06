package View;

import javafx.scene.Node;
import Model.Position;

public abstract class View {

    public Position center;
    private int width, height;

    private Node[] content;
    private View[] views;
}
