package View;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

import java.util.ArrayList;

public class LibraryView extends View {

    private String[] towers = {"normalTower", "freezeTower"};
    private int rows, columns;

    public LibraryView(int x, int y, int rows) {

        super(120, rows * 60);
        super.setCenter(x, y);

        this.rows = rows;
        this.columns = 2;
    }

    @Override
    public Node[] body() {

        ArrayList<Node> nodes = new ArrayList<Node>();

        for(int row = 0; row < rows; row++) {

            for (int column = 0; column < columns; column++) {

                Image img;

                try {

                    img = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/" + towers[row * columns + column] + ".png");
                }
                catch(IndexOutOfBoundsException e) {

                    img = new Image("file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/placeholder.png");
                }

                ImageView imageView = new ImageView();
                imageView.setImage(img);
                imageView.setFitHeight(60);
                imageView.setFitWidth(60);
                imageView.setLayoutX(column * 60);
                imageView.setLayoutY(row * 60);

                imageView.setOnDragDetected((evt) -> handleOnDragDetected(evt, imageView));

                nodes.add(imageView);
            }
        }

        Node[] nodesArray = new Node[nodes.size()];
        return nodes.toArray(nodesArray);
    }

    @Override
    public void update() {

    }

    private void handleOnDragDetected(MouseEvent evt, ImageView element) {

        Dragboard db = element.startDragAndDrop(TransferMode.ANY);

        ClipboardContent cb = new ClipboardContent();
        cb.putImage(element.getImage());
        cb.putString(element.getImage().getUrl().substring(54));

        db.setContent(cb);
        evt.consume();;
    }
}
