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

    public abstract void shoot(Wave wave); 
}
