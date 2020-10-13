package Model;

import java.util.LinkedList;

public class Wave {
   
    public LinkedList<Enemy> enemyList;
    
    public Wave(double level) {

        enemyList = new LinkedList<Enemy>();
        
        for(int i = 0; i < 10 * level; i++) {
            
            enemyList.add(new Enemy((int) 100, (int) level/10, (int) (1.0/level), (int) level));
        }
    }
}
