package Controller;

import View.*;
import Model.*;

public class GameController implements Runnable {

    private MapView map;
    private int wayLength;
    private Wave currentWave;
    private int startlevel;

    public GameController(MapView map, int level) {

        this.map = map;
        this.startlevel = level;
        wayLength = map.mapData.way.length;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName());

        for (int level = startlevel; level <= 10; level++) {

            System.out.println("Welle");

            currentWave = Wave.getWave(level);
            map.addWave(currentWave);

            while(currentWave.size() > 0) {

                currentWave.forEach((enemy -> {
                    moveEnemy(enemy);
                }));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void moveEnemy(Enemy enemy) {

        System.out.println(Thread.currentThread().getName());

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
            currentWave.remove(enemy);

            Position position = map.mapData.way[enemy.getPositionIndex()];

            map.map[position.x][position.y].setImage(Images.TARGET);
        }

        map.update();
    }
}
