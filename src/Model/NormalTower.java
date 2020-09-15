package Model;

import Controller.ViewController;
import java.util.LinkedList;

public class NormalTower extends Tower {
  
  private int freezePoints;
  
  public NormalTower(Position pos){

    super(pos);
    
    super.pictureSource = "/pics/normalTower.png";
    super.image = new Image(pictureSource);
    super.cost = 150;
    
    this.freezePoints = 10;
  }
    
  public void shoot(Wave wave){
    
    LinkedList<Enemy> enemies = wave.enemyList;
    Position[] way = ViewController.mapData.way;

    for (int i = 0; i < enemies.size(); i++) {
      double eRange = Math.sqrt(Math.abs((way[enemies.get(i).getPositionIndex()].x-super.position.x)*(way[enemies.get(i).getPositionIndex()].x-super.position.x) + (way[enemies.get(i).getPositionIndex()].y-super.position.y)*(way[enemies.get(i).getPositionIndex()].y-super.position.y))) ;
      if (super.range > eRange) {
        enemies.get(i).hp -= super.damage;
        break;
      } // end of if
    }
  }
  
}
