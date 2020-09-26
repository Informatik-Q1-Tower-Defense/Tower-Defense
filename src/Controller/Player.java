package Controller;

import Model.*;

public class Player {

    private static int money;
    private static int hp;
    private static Map map;

    private static Action onGameOver;

    /*public void buy(Tower tower, Position pos){

        tower = new FreezeTower(pos);
        this.money -=  tower.getCost();
        
        if ( this.money < 0) {
            this.money += tower.getCost();
            tower = null;
        }
    }*/

    public static int getMoney() {
        return money;
    }

    protected static void setMoney(int newValue) {
        money = newValue;
    }

    public static int getHp() {
        return hp;
    }

    protected static void setHp(int newValue) {
        hp = newValue;
    }

    public static Map getMap() {
        return map;
    }

    protected static void setMap(Map newValue) {
        map = newValue;
    }

    protected static void setOnGameOver(Action action) {
        onGameOver = action;
    }

    public static void enemyReachedEnd(Enemy enemy) {
        hp -= enemy.getDamage();

        if(hp <= 0) {
            onGameOver.action();
        }
        else{
           wave.enemyList.remove(enemy);
        }
    }

    public static void enemygetKilled(Enemy enemy) {

        money += enemy.getWin();
        wave.enemyList.remove(enemy);
    }

    public static FreezeTower buyFreezeTower(Position pos) {

        FreezeTower tower = new FreezeTower(pos);
        money -=  tower.getCost();

        if (money < 0) {
            money += tower.getCost();
            tower = null;
        }

        return tower;
    }

    public static NormalTower buyTower(Position pos) {

        NormalTower tower = new NormalTower(pos);
        money -=  tower.getCost();

        if (money < 0) {
            money += tower.getCost();
            tower = null;
        }

        return tower;
    }
}
