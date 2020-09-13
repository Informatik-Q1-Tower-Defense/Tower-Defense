package Model;

import Controller.ViewController;

public class FreezeTower extends Tower {
  
  private int freezePoints;
  
  public FreezeTower(Position pos){

    super(pos);
    
    super.pictureSource = "/pics/freezeTower.png";
    super.image = new Image(pictureSource);
    super.cost = 200;
    
    this.freezePoints = 10;
  }
  
  public void shoot(Wave wave){
    Enemy[] enemies = wave.enemies;

    Position[] way = ViewController.mapData.way;

    for (int i = 0; i < enemies.length; i++) {
      double eRange = Math.sqrt(Math.abs((way[enemies[i].getPositionIndex()].x-super.position.x)*(way[enemies[i].getPositionIndex()].x-super.position.x) + (way[enemies[i].getPositionIndex()].y-super.position.y)*(way[enemies[i].getPositionIndex()].y-super.position.y))) ;
      if (super.range > eRange) {
        enemies[i].hp -= super.damage;
        enemies[i].freeze(freezePoints);
        break;
      } // end of if
    }
  }
  
}
