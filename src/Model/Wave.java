package Model;

public class Wave {

    Linkedlist<Enemy> enemyList;
    
    public Wave(int amount) {
        
        for(int i = 0; i < amount; i++) {
            
            enemyList.add(new Enemy(10, 40, 40, 50));
        }
    }
    
}
