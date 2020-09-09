package Model;

import java.io.File;
import java.io.FileNotFoundException;
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

		int lengthOfWay = 0;
		int lengthOfTowers = 0;
		int lengthOfAvaidablePositions = 0;

		for(char c: contentCA) {

			if (c == 't') {

				lengthOfTowers++;
			}
			else if (c == '_') {

				lengthOfAvaidablePositions++;
			}
			else if (c == 'S' || c == 'X' || c == '>' || c == '<' || c == 'v' || c == '^') {

				lengthOfWay++;
			}
			else if (c != '#' && c != '\n') {

				throw new IllegalArgumentException("Unkown charracter (" + c + ") in .txt file");
			}
		}

		this.way = new Position[lengthOfWay];
		this.avaidablePositions = new Position[lengthOfAvaidablePositions];
		this.towers = new Tower[lengthOfTowers];
		
		Position currentPosition = new Position(0, 0);

		Position startOfWay = null;
		Position[] way = new Position[lengthOfWay - 1];

		int towerIndex = 0;
		int avaidablePositionIndex = 0;
		int wayIndex = 0;
		
		for(int i = 0; i < contentCA.length; i++) {
			
			if (contentCA[i] != '\n') {

				if (contentCA[i] == 't') {

					Position position = new Position(0,0);
					position.x = currentPosition.x;
					position.y = currentPosition.y;

					this.towers[towerIndex] = new FreezeTower(position);
					towerIndex++;
				}
				else if (contentCA[i] == '_') {

					Position position = new Position(0,0);
					position.x = currentPosition.x;
					position.y = currentPosition.y;

					this.avaidablePositions[avaidablePositionIndex] = position;
					avaidablePositionIndex++;
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

					way[wayIndex] = position;
					wayIndex++;
				}
				
				currentPosition.x++;
			}
			else {

				this.width = currentPosition.x;

				currentPosition.y++;
				currentPosition.x = 0;
			}
		}

		this.way = Position.sortWay(startOfWay, way);

		this.height = currentPosition.y;
	}
}
