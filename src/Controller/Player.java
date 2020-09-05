package Controller;

import Model.Position;

public class Player {

    private int money;
    private int hp;

    public Player(int hpTemp, int moneyTemp){
        this.money = moneyTemp;
        this.hp = hpTemp;
    }

    public void buy(Tower tower, Position pos){
        tower = new Tower(pos);
        this.money -=  tower.getCost();
        if ( this.money < 0) {
            this.money += tower.getCost();
        }
        tower = null;
    }

}
