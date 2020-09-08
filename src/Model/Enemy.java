package Model;

import Controller.Player;
public class Enemy {

    public int hp, speed;
    private int damage;
    private String imageSource = "";
    public double win;
    
    private int currentPositionIndex;
    
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
    
    public void freeze(int freezePower) {
        
        this.speed -= freezePower;
    }
    
    public void move() {
        
        this.currentPositionIndex++;
    }
    
    public void onDamage(Tower tower, Player player) {

        hp -= tower.getDamage();
        
        if(hp <= 0) {
            player.money += win;
        }
        
    }
    
    public void onReachEnd(Player player) {
        player.hp -= damage;
    }
    
}
