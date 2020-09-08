package Model;

public abstract class Tower {

    private String pictureSource;
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

    public void setCost(int newValue) {

        this.cost = newValue;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getPictureSource(){
        return this.pictureSource;
    }

    public void setPictureSource(String newValue) {

        this.pictureSource = newValue;
    }

    public int getDamage() {

        return this.damage;
    }

    public int getRange() {

        return this.range;
    }

    public abstract void shoot(Wave wave); /*{
        Enemy[] enemies = wave.enemies;
        for (int i = 0; i < enemies.length; i++) {
            double enemyDistance = Math.sqrt(Math.abs((enemies[i].getX()-position.x)*(enemies[i].getX()-position.x) + (enemies[i].getY()-position.y)*(enemies[i].getY()-position.y))) ;
            if (this.range > enemyDistance) {
                enemies[i].hp -= this.damage;
                break;
            } // end of if
        }
    }*/
}
