package Model;

public class Enemy {
    
    public static Position spawn;

    private int damage, hp, speed;
    private String imageSource = "";
    
    private Position currentPosition;
    
    public Enemy(int damage, int hp, int speed) {
        
        this.currentPosition = Enemy.spawn;
        
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
    }
    
    public walk() {
        
        //code
    }
}
