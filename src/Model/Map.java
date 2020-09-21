package Model;

import javafx.geometry.Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Map {

	public int width, height;
	
	public ArrayList<Position> avaidablePositions;
	public Position[] way;
	public ArrayList<Tower> towers;

	private HashMap<Position, Effect> specialArea;

	public Map(String filePath) {
		
		String content = "";
		
		try {
			
			File file = new File(filePath);
			Scanner sc = new Scanner(file);
			
			while(sc.hasNextLine()) {
				
				content += sc.nextLine() + "\n";
			}
			sc.close();
		}
		catch(FileNotFoundException e) {

			throw new IllegalArgumentException("File not found");
		}
		
		char[] contentCA = content.toCharArray();

		ArrayList<Position> way = new ArrayList<Position>();
		avaidablePositions = new ArrayList<Position>();
		towers = new ArrayList<Tower>();
		
		Position currentPosition = new Position(0, 0);

		Position startOfWay = null;
		
		for(int i = 0; i < contentCA.length; i++) {
			
			if (contentCA[i] != '\n') {

				if (contentCA[i] == 't') {

					Position position = new Position(0,0);
					position.x = currentPosition.x;
					position.y = currentPosition.y;

					towers.add(new NormalTower(position));
				}
				else if (contentCA[i] == '_') {

					Position position = new Position(0,0);
					position.x = currentPosition.x;
					position.y = currentPosition.y;

					avaidablePositions.add(position);
				}
				else if (contentCA[i] == 'S') {

					Position position = new Position(0,0);
					position.x = currentPosition.x;
					position.y = currentPosition.y;

					startOfWay = position;
				}
				else if (contentCA[i] == 'X' || contentCA[i] == '>' || contentCA[i] == '<' || contentCA[i] == 'v' || contentCA[i] == '^') {

					Position position = new Position(0,0);
					position.x = currentPosition.x;
					position.y = currentPosition.y;

					way.add(position);
				}
				
				currentPosition.x++;
			}
			else {

				this.width = currentPosition.x;

				currentPosition.y++;
				currentPosition.x = 0;
			}
		}

		Position[] unsortedWay = new Position[way.size()];

		this.way = Position.sortWay(startOfWay, way.toArray(unsortedWay));

		this.height = currentPosition.y;
	}

	public void addTower(Tower tower) {

		if (avaidablePositions.contains(tower.position)) {

			avaidablePositions.remove(tower.position);
			towers.add(tower);
		}
	}

	public void removeTowerAt(Position position) {

		towers.forEach((tower) -> {

			if (tower.position.equals(position)) {

				towers.remove(tower);
			}
		});
	}

	public Effect getEffectOn(Position position) {

		Effect effect = specialArea.get(position);

		if (effect == null) {

			return new Effect(Effect.Type.NONE, null);
		}

		return effect;
	}

	public void addEffectOn(Effect effect, Position position) {

		for(Position wayElement: way) {

			if (position.equals(wayElement)) {

				specialArea.put(position, effect);
				break;
			}
		}
	}
}
