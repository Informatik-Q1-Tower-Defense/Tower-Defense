package Model;

import javafx.scene.image.Image;

public abstract class Tower {

    protected Image image;
    protected Position position;
    
    protected int damage;
    protected int cost;
    protected int range;
    protected int bulletspeed;

    public Tower(Position pos){

        this.position = pos;

        this.damage = 20;
        this.range = 3;
        this.bulletspeed = 5; //Schüsse pro Sekunde
    }

    public boolean equals(Object obj) {

        Tower tower = (Tower) obj;

        if (tower.position.equals(this.position)) {

            return true;
        }
        else {

            return false;
        }
    }

    public Image getImage(){
        return this.image;
    }

    public int getCost(){
        return this.cost;
    }
    
    public Position getPosition(){
        return position;
    }

    public abstract void shoot(Wave wave); 
}
