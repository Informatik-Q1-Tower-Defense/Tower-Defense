package Model;

import javafx.geometry.Pos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {

	public int width, height;
	
	public Position[] avaidablePositions;
	public Position[] way;
	public Tower[] towers;

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
		ArrayList<Position> avaidablePositions = new ArrayList<Position>();
		ArrayList<Tower> towers = new ArrayList<Tower>();
		
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
		Tower[] towersRaw = new Tower[towers.size()];
		Position[] avaidablePositionsRaw = new Position[avaidablePositions.size()];

		this.way = Position.sortWay(startOfWay, way.toArray(unsortedWay));
		this.towers = towers.toArray(towersRaw);
		this.avaidablePositions = avaidablePositions.toArray(avaidablePositionsRaw);

		this.height = currentPosition.y;
	}

	public void addTower(Tower tower) {

		for(Position element: this.avaidablePositions) {

			if (tower.getPosition().x == element.x && tower.getPosition().y == element.y) {

				ArrayList<Tower> towers = new ArrayList<Tower>();

				for(Tower towersElement: this.towers) {

					towers.add(towersElement);
				}

				towers.add(tower);

				Tower[] newTowers = new Tower[towers.size()];

				this.towers = towers.toArray(newTowers);

				break;
			}
		}
	}

	public void removeTowerAt(Position position) {

		for(int i = 0; i < this.towers.length; i++) {

			if (this.towers[i].getPosition().x == position.x && this.towers[i].getPosition().y == position.y) {

				ArrayList<Tower> towers = new ArrayList<Tower>();

				for(int index = 0; index < this.towers.length; index ++) {

					if (index != i) {

						towers.add(this.towers[index]);
					}
				}

				Tower[] newTowers = new Tower[towers.size()];

				this.towers = towers.toArray(newTowers);

				break;
			}
		}
	}
}
