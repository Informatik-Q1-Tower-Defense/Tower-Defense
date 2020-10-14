package Model;

import java.util.LinkedList;

public class Wave extends LinkedList<Enemy> {

    public static Wave getWave(int level) {

        if (level == 0) {

            return new Wave();
        }
        else {

            Wave wave = getWave(level - 1);

            for(int i = 0; i < 20 / level; i++) {

                wave.add(new Enemy(level));
            }

            return wave;
        }
    }
}
