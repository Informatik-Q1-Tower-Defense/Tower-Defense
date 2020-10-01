package Model;
import java.util.LinkedList;
import Controller.Player;

public class FreezeTower extends Tower {
  
  private int freezePoints;
  
  public FreezeTower(Position pos){

    super(pos);

    super.image = Images.FREEZETOWER;
    super.cost = 200;
    
    this.freezePoints = 10;
  }
  
  public void shoot(Wave wave){
    LinkedList<Enemy> enemies = wave.enemyList;

    Position[] way = Player.getMap().way;

    for (int i = 0; i < enemies.size(); i++) {
      double eRange = Math.sqrt(Math.abs((way[enemies.get(i).getPositionIndex()].x-super.position.x)*(way[enemies.get(i).getPositionIndex()].x-super.position.x) + (way[enemies.get(i).getPositionIndex()].y-super.position.y)*(way[enemies.get(i).getPositionIndex()].y-super.position.y))) ;
      if (super.range > eRange) {
        enemies.get(i).hp -= super.damage;
        enemies.get(i).freeze(freezePoints);
        break;
      } // end of if
    }
  }
  
}
