package Model;

public abstract class Tower {

    protected String pictureSource;
    protected Position position;
    
    protected int damage;
    protected int cost;
    protected int range;
    protected int bulletspeed;

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
    
    public Position getPosition(){
        return position
    }

    public abstract void shoot(Wave wave); 
}
