

public class FreezeTower extends Tower{
  
  private int freezePoints;
  
  public FreezeTower(Position pos){
    super(pos);
    
    super.pictureSource = "";
    super.cost = 150;
    
    this.freezePoints = 10;
  }
  
  public void shoot(Wave wave){
    Enemy[] enemies = wave.enemies;
    for (int i = 0; i < enemies.length; i++) {
      double eRange = Math.sqrt(Math.abs((enemies[i].getX()-position.x)*(enemies[i].getX()-position.x) + (enemies[i].getY()-position.y)*(enemies[i].getY()-position.y))) ;
      if (this.range > eRange) {
        enemies[i].hp -= this.damage;
        enemies[i].freeze(freezePoints);
        break;
      } // end of if
    }
  }
  
}
