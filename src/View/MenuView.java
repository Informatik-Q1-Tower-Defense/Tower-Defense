package View;

import Controller.Action;
import javafx.scene.Node;
import javafx.scene.control.Button;

import java.io.File;
import java.util.ArrayList;

public class MenuView extends View {

    private File[] files;
    private Selection selection;

    public MenuView() {

        super(0,0);

        files = new File("levels/").listFiles();

        int width = 0;

        if (files.length >= 2) {

            width = 260;
        }
        else {

            width = 140;
        }

        int height = ((int) Math.ceil((double) files.length / 2.0) - 1) * 120 + 140;

        super.setBounds(width, height);
        super.setCenter(0, 0);
    }

    public void setOnSelection(Selection selection) {

        this.selection = selection;
    }

    @Override
    public Node[] body() {

        ArrayList<Node> nodes = new ArrayList<Node>();

        int x = 0;
        int y = 20;

        for(int i = 0; i < files.length; i++) {

            Button btn = new Button("Level Nr." + i);
            btn.setPrefSize(100, 100);

            if(i % 2 == 0) {

                x = 20;
                btn.setLayoutX(x);
                btn.setLayoutY(y);
                y += 120;
            }
            else {

                x = 140;
                btn.setLayoutX(x);
                btn.setLayoutY(y);
            }
            File currentFile = files[i];

            btn.setOnAction((evt) -> selection.selected(currentFile));

            nodes.add(btn);
        }

        Node[] nodesArray = new Node[nodes.size()];
        return nodes.toArray(nodesArray);
    }

    @Override
    public void update() {

    }
}
