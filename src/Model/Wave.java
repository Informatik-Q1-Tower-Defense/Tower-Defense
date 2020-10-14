package Model;

import java.util.LinkedList;

public class Wave {
   
    public LinkedList<Enemy> enemyList;
    
    public Wave(int level) { //level 1-10

        if (level == 0) {

            enemyList = new LinkedList<Enemy>();
        }
        else {

            enemyList = new Wave(level - 1).enemyList;

            for(int i = 0; i < 20 / level; i++) {

                enemyList.add(new Enemy(level));
            }
        }
    }
}
