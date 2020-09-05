package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {

	private int width, height;
	
	private Position[] avaidablePositions;
	private Position[] way;
	private Tower[] towers;

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
		
		for(int i = 0; i < contentCA.length; i++) {
			
			if (contentCA[i] != '\n') {

				if (contentCA[i] == 't') {

					this.towers[i] = new Tower(currentPosition);
				}
				else if (contentCA[i] == '_') {

					this.avaidablePositions[i] = currentPosition;
				}
				else if (contentCA[i] == 'S' || contentCA[i] == 'X' || contentCA[i] == '>' || contentCA[i] == '<' || contentCA[i] == 'V' || contentCA[i] == '^') {

					this.way[i] = currentPosition;
				}
				
				currentPosition.x++;
			}
			else {
				
				currentPosition.y++;
				currentPosition.x = 0;
			}
		}

		this.width = currentPosition.x;
		this.height = currentPosition.y;
	}
}
