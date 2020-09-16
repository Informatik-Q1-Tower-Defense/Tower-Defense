package Model;

import java.util.LinkedList;

public class Wave {
    
    private int amount;
    LinkedList<Enemy> enemyList; // Import fehlte
    
    public Wave(int amount) {
        
        this.amount = amount;

        //Bisherige Methode start() in den Konstruktor verschieben und in start() die Fortbewegung der Enemies programmieren.
    }
    
    public void start(){

        for(int i = 0; i < amount; i++) {

            /*enemyList.add((new Enemy(5, 50, 1, 25)).walk());
            Thread.sleep(1);*/
            // Hier wird nur die LinkedList erstellt.
            //Der Code würde so auch nicht funktionieren, weil jeder Gegner nur einmalig nach vorne gehen würde.
            enemyList.add((new Enemy(5, 50, 1, 25)));
        }
    }
}
