package Model;

public class Tower {

    private String pictureSource = "/pics/Tower.png";
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

    public Position getPosition() {
        return this.position;
    }

    public String getPictureSource(){
        return this.pictureSource;
    }

    public void shoot(Wave wave) {
        Enemy[] enemies = wave.enemies;
        for (int i = 0; i < enemies.length; i++) {
            double eRange = Math.sqrt(Math.abs((enemies[i].getX()-position.x)*(enemies[i].getX()-position.x) + (enemies[i].getY()-position.y)*(enemies[i].getY()-position.y))) ;
            if (this.range > eRange) {
                enemies[i].hp -= this.damage;
                break;
            } // end of if
        }
    }
}