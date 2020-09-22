package Model;

import java.util.LinkedList;

public class Wave {
   
    LinkedList<Enemy> enemyList;
    
    public Wave(int amount) {
        
        for(int i = 0; i < amount; i++) {
            
            enemyList.add(new Enemy(5, 50, 1, 25));
        }
    }
    
    public void move() {
       
       enemyList.forEach((enemy) -> {enemy.move();});
    }
}
