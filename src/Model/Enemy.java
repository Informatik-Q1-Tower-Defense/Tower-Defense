package Model;

public class Enemy {

    public int hp, speed;
    private int damage;
    private String imageSource = "";
    
    private Position currentPositionIndex;
    
    public Enemy(int damage, int hp, int speed) {
        
        this.currentPositionIndex = 0;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
    }
    
    public int getPositionIndex() {
     
        return this.currentPositionIndex;
    }
    
    public void freeze() {
        
        this.speed -= this.speed / 10; //Ändern
    }
    
    public move() {
        
        this.currentPositionIndex++;
    }
}
