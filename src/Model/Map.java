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

					towers.add(new FreezeTower(position));
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
}
