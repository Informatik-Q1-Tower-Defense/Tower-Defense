package Model;

import java.util.LinkedList;

public class Wave {
   
    LinkedList<Enemy> enemyList; // Import fehlte
    
    public Wave(int amount) {
        
        for(int i = 0; i < amount; i++) {
            
            enemyList.add(new Enemy(5, 50, 1, 25));
        }
    }
}
