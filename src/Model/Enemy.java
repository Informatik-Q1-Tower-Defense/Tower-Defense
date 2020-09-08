package Model;

public class Enemy {

    public int hp, speed;
    private int damage;
    private String imageSource = "";
    public double win;
    
    private Position currentPositionIndex;
    
    public Enemy(int damage, int hp, int speed, int win) {
        
        this.currentPositionIndex = 0;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
        this.win = win;
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
    
    public void onDamage() {
        hp -= Tower.damage;
        
        if(hp <= 0) {
            Player.Money += win;
        }
        
    }
    
    public void onReachEnd() {
        Player.hp -= damage;
    }
    
}
