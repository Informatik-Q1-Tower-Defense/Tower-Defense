package Model;

import Controller.Player;
import Controller.ViewController;
import java.util.LinkedList;
import javafx.scene.image.Image;

public class NormalTower extends Tower {
  
  private int freezePoints;
  
  public NormalTower(Position pos){

    super(pos);
    
    super.pictureSource = "file:/Users/timjaeger/IdeaProjects/Tower-Defense/pics/normalTower.png"; //Der Image-Konstruktor erwartet eine URL nicht den Pfad
    super.image = new Image(pictureSource);
    super.cost = 150;
    
    this.freezePoints = 10;
  }
    
  public void shoot(Wave wave){
    
    LinkedList<Enemy> enemies = wave.enemyList;
    Position[] way = Player.getMap().way;

    for (int i = 0; i < enemies.size(); i++) {
      double eRange = Math.sqrt(Math.abs((way[enemies.get(i).getPositionIndex()].x-super.position.x)*(way[enemies.get(i).getPositionIndex()].x-super.position.x) + (way[enemies.get(i).getPositionIndex()].y-super.position.y)*(way[enemies.get(i).getPositionIndex()].y-super.position.y))) ;
      if (super.range > eRange) {
        enemies.get(i).hp -= super.damage;
        break;
      } // end of if
    }
  }
  
}
