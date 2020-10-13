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

        for(int i = 0; i < wayLength; i++) {

            currentWave.enemyList.getFirst().move();

            map.update();

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
