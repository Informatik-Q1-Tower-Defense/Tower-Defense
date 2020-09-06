package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Controller.Tower;

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
				
				content += sc.nextLine();
			}
			sc.close();
		}
		catch(FileNotFoundException e) {
			
			throw new IllegalArgumentException("File not found");
		}

		System.out.println(content);
		
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
			else if (c == 'S' || c == 'X' || c == '>' || c == '<' || c == 'V' || c == '^') {

				lengthOfWay++;
			}
			else if (c != '#') {

				throw new IllegalArgumentException("Unkown charracter in .txt file");
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

					this.towers[towerIndex] = new Tower(currentPosition);
					towerIndex++;
				}
				else if (contentCA[i] == '_') {

					this.avaidablePositions[avaidablePositionIndex] = currentPosition;
					avaidablePositionIndex++;
				}
				else if (contentCA[i] == 'S') {

					startOfWay = currentPosition;
				}
				else if (contentCA[i] == 'X' || contentCA[i] == '>' || contentCA[i] == '<' || contentCA[i] == 'V' || contentCA[i] == '^') {

					way[wayIndex] = currentPosition;
					wayIndex++;
				}
				
				currentPosition.x++;
			}
			else {
				
				currentPosition.y++;
				currentPosition.x = 0;
			}
		}

		this.way = Position.sortWay(startOfWay, way);

		this.width = currentPosition.x;
		this.height = currentPosition.y;
	}
}
