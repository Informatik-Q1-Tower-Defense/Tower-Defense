package Controller;

import View.*;
import Model.*;

public class GameController implements Runnable {

    private MapView map;
    private int wayLength;
    private Wave currentWave;

    public GameController(MapView map) {

        this.map = map;
        wayLength = map.mapData.way.length;
    }

    @Override
    public void run() {

        currentWave = new Wave(1);

        map.addWave(currentWave);

        moveEnemy(currentWave.enemyList.getFirst());
        moveEnemy(currentWave.enemyList.getFirst());
        moveEnemy(currentWave.enemyList.get(2));

        for(int i = 0; i < wayLength - 1; i++) {

            moveEnemy(currentWave.enemyList.getFirst());
            moveEnemy(currentWave.enemyList.get(1));
            moveEnemy(currentWave.enemyList.get(2));

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    private void moveEnemy(Enemy enemy) {

        Position pos = map.mapData.way[enemy.getPositionIndex()];

        if (enemy.getPositionIndex() != 0 && enemy.getPositionIndex() != wayLength - 1) {

            map.map[pos.x][pos.y].setImage(Images.WAY);
        }
        else if (enemy.getPositionIndex() == 0) {

            map.map[pos.x][pos.y].setImage(Images.PORTAL);
        }
        else {

            map.map[pos.x][pos.y].setImage(Images.TARGET);
        }
        enemy.move();

        if (enemy.getPositionIndex() == wayLength - 1) {

            Player.enemyReachedEnd(enemy);

            Position position = map.mapData.way[enemy.getPositionIndex()];

            map.map[position.x][position.y].setImage(Images.TARGET);
        }

        map.update();
    }
}
