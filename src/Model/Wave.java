package Model;

public class Wave {
    
    private int amount;
    Linkedlist<Enemy> enemyList;
    
    public Wave(int amount) {
        
        this.amount = amount;
    }
    
    public void start(){
        for(int i = 0; i < amount; i++) {
            enemyList.add((new Enemy(5, 50, 1, 25)).walk());
            Thread.sleep(1);
        }   
    }
}
