package Model;

import Controller.ViewController;

public class FreezeTower extends Tower {
  
  private int freezePoints;
  
  public FreezeTower(Position pos){

    super(pos);
    
    super.pictureSource = "/pics/freezeTower.png";
    super.cost = 150;
    
    this.freezePoints = 10;
  }
  
  public void shoot(Wave wave){
    Enemy[] enemies = wave.enemies;

    Position[] way = ViewController.mapData.way;

    for (int i = 0; i < enemies.length; i++) {
      double eRange = Math.sqrt(Math.abs((way[enemies[i].getPositionIndex()].x-super.getPosition().x)*(way[enemies[i].getPositionIndex()].x-super.getPosition().x) + (way[enemies[i].getPositionIndex()].y-super.getPosition().y)*(way[enemies[i].getPositionIndex()].y-super.getPosition().y))) ;
      if (super.range > eRange) {
        enemies[i].hp -= super.damage;
        enemies[i].freeze(freezePoints);
        break;
      } // end of if
    }
  }
  
}
