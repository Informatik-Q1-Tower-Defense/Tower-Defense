package Controller;

import Model.*;

public class Player {

    public int money;
    public int hp;

    public Player(int hpTemp, int moneyTemp){
        this.money = moneyTemp;
        this.hp = hpTemp;
    }

    public void buy(Tower tower, Position pos){

        tower = new FreezeTower(pos);
        this.money -=  tower.getCost();
        
        if ( this.money < 0) {
            this.money += tower.getCost();
            tower = null;
        }
    }

    public FreezeTower buyFreezeTower(Position pos) {

        FreezeTower tower = new FreezeTower(pos);

        this.money -=  tower.getCost();

        if (this.money < 0) {
            this.money += tower.getCost();
            tower = null;
        }

        return tower;
    }

    public NormalTower buyTower(Position pos) {

        NormalTower tower = new NormalTower(pos);

        this.money -=  tower.getCost();

        if (this.money < 0) {
            this.money += tower.getCost();
            tower = null;
        }

        return tower;
    }
}
