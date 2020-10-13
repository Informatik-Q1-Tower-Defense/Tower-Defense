package View;

import Controller.Player;
import javafx.scene.Node;
import Model.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import java.util.ArrayList;

public class MapView extends View {

    private ImageView[][] map;
    public Map mapData;
    public Wave wave;

    public MapView(Map mapData) {

        super(mapData.width * 30, mapData.height * 30);

        this.mapData = mapData;

        this.map = new ImageView[mapData.width][mapData.height];

        for(int xValue = 0; xValue < mapData.width; xValue++) {

            for(int yValue = 0; yValue < mapData.height; yValue++) {

                this.map[xValue][yValue] = new ImageView(Images.BORDER);
                this.map[xValue][yValue].setLayoutX(xValue * 30);
                this.map[xValue][yValue].setLayoutY(yValue * 30);
                this.map[xValue][yValue].setOnDragOver((evt) -> handleDragOver(evt));

                Position pos = new Position(xValue, yValue);

                this.map[xValue][yValue].setOnDragDropped((evt) -> handleOnDragDropped(evt, pos));
            }
        }

        double randomNumber = 0.0;

        for(Position element: mapData.avaidablePositions) {

            randomNumber = Math.random();

            if (randomNumber < 0.667) {

                this.map[element.x][element.y].setImage(Images.GRASS);
            }
            else {

                this.map[element.x][element.y].setImage(Images.TREE);
            }
        }
        for(Position element: mapData.way) {

            this.map[element.x][element.y].setImage(Images.WAY);
        }

        this.map[mapData.way[0].x][mapData.way[0].y].setImage(Images.PORTAL);
        this.map[mapData.way[mapData.way.length - 1].x][mapData.way[mapData.way.length - 1].y].setImage(Images.TARGET);

        for(Tower tower: mapData.towers) {

            this.map[tower.getPosition().x][tower.getPosition().y].setImage(tower.getImage());
        }
    }

    public void addWave(Wave wave) {

        this.wave = wave;

        for(Enemy enemy: wave.enemyList) {

            Position pos = mapData.way[enemy.getPositionIndex()];

            if(enemy.getPositionIndex() == 0) {

                map[pos.x][pos.y].setImage(Images.PORTALENEMY);
            }
            else if(enemy.getPositionIndex() == mapData.way.length - 1) {

                map[pos.x][pos.y].setImage(Images.TARGETENEMY);
            }
            else {

                map[pos.x][pos.y].setImage(Images.WAYENEMY);
            }
        }
    }

    public void update() {

        for(Tower tower: mapData.towers) {

            this.map[tower.getPosition().x][tower.getPosition().y].setImage(tower.getImage());
        }

        for(Enemy enemy: wave.enemyList) {

            if (enemy != null) {

                Position pos = mapData.way[enemy.getPositionIndex()];

                if (enemy.getPositionIndex() == 0) {

                    map[pos.x][pos.y].setImage(Images.PORTALENEMY);
                } else if (enemy.getPositionIndex() == mapData.way.length - 1) {

                    map[pos.x][pos.y].setImage(Images.TARGETENEMY);
                } else {

                    map[pos.x][pos.y].setImage(Images.WAYENEMY);
                }
            }
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

    private void handleDragOver(DragEvent evt) {

        if (evt.getDragboard().hasString()) {

            evt.acceptTransferModes(TransferMode.ANY);
        }
    }

    private void handleOnDragDropped(DragEvent evt, Position pos) {

        switch (evt.getDragboard().getString()) {

            case "normalTower.png":

                Tower normalTower = Player.buyTower(pos);

                if (normalTower != null) {

                    mapData.addTower(normalTower);
                    update();
                }
                break;

            case "freezeTower.png":

                Tower freezeTower = Player.buyFreezeTower(pos);

                if (freezeTower != null) {

                    mapData.addTower(freezeTower);
                    update();
                }
                break;
        }
    }
}
