package Model;

import Controller.Player;
public class Enemy {

    public int hp, speed;
    private int damage;
    private int win;
    
    private int currentPositionIndex;
    
    public Enemy(int level) {
        
        this.currentPositionIndex = 0;

        if (level < 1 || level > 10) {

            throw new IllegalArgumentException("Lebel 1-10");
        }

        switch(level) {

            case 1:
                this.hp = 10;
                this.damage = 10;
                this.win = 10;
                this.speed = 5;

            case 2:
                this.hp = 20;
                this.damage = 20;
                this.win = 20;
                this.speed = 5;

            case 3:
                this.hp = 30;
                this.damage = 30;
                this.win = 30;
                this.speed = 4;

            case 4:
                this.hp = 40;
                this.damage = 40;
                this.win = 40;
                this.speed = 4;

            case 5:
                this.hp = 50;
                this.damage = 50;
                this.win = 50;
                this.speed = 3;

            case 6:
                this.hp = 60;
                this.damage = 60;
                this.win = 60;
                this.speed = 3;

            case 7:
                this.hp = 70;
                this.damage = 70;
                this.win = 70;
                this.speed = 2;

            case 8:
                this.hp = 80;
                this.damage = 80;
                this.win = 80;
                this.speed = 2;

            case 9:
                this.hp = 90;
                this.damage = 90;
                this.win = 90;
                this.speed = 1;

            case 10:
                this.hp = 100;
                this.damage = 100;
                this.win = 100;
                this.speed = 1;
        }
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
    
    /*public void onDamage(int damage) {

        hp -= damage;

        if (hp <= 0) {

            Player.enemygetKilled(this);
        }
    }
    
    public void onReachEnd() {

        Player.enemyReachedEnd(this);
    }*/
    
}
