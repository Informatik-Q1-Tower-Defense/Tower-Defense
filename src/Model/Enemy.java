package Model;

import Controller.Player;
public class Enemy {

    public int hp, speed;
    private int damage;
    private int win;
    
    private int currentPositionIndex;
    
    public Enemy(int damage, int hp, int speed, int win) {
        
        this.currentPositionIndex = 0;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
        this.win = win;
    }

    public int getDamage() {

        return damage;
    }

    public int getWin() {

        return win;
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
    
    public void onDamage(int damage) {

        hp -= damage;

        if (hp <= 0) {

            Player.enemygetKilled(this);
        }
    }
    
    public void onReachEnd() {

        Player.enemyReachedEnd(this);
    }
    
}
