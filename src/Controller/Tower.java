package Controller;
import Model.Position;

public class Tower {

    private Position position;
    private int damage;
    private int cost;
    private int range;
    private int bulletspeed;

    public Tower(Position pos){

        this.position = pos;

        this.damage = 20;
        this.cost = 100;
        this.range = 3;
        this.bulletspeed = 5; //Schüsse pro Sekunde
    }

    public int getCost(){
        return this.cost;
    }

    public void shoot(Wave wave) {
        Enemy[] enemies = wave.enemies;
        for (int i = 0; i < enemies.length; i++) {
            eRange = Math.sqrt(Math.abs((enemies[i].getX()-postion.x)*(enemies[i].getX()-postion.x) + (enemies[i].getY()-postion.y)*(enemies[i].getY()-postion.y))) ;
            if (this.range > eRange) {
                enemies[i].hp -= this.damage;
                break;
            } // end of if
        }
    }
}
