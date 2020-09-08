package Model;

public class Enemy {

    public int hp, speed;
    public int freezedSpeed;
    private int damage;
    private String imageSource = "";
    
    public Position currentPositionIndex;
    
    public Enemy(int damage, int hp, int speed) {
        
        this.currentPositionIndex = 0;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
    }
    
    public move() {
        
        this.currentPositionIndex++;
    }
}
