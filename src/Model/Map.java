package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Map {

	//Kommentar
	
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
			
			throw new IllegalArgumentException("File not Found");
		}
		
		char[] contentCA = content.toCharArray();
		
		Position currentPosition = new Position(0, 0);
		
		for(char c: contentCA) {
			
			if (c != '\n') {
				
				switch(c) {
				
				case '#':
					
				case 't':
					
				case '_':
					
				case 'S':
					
				case 'X':
					
				case '>':
					
				case '<':
					
				case 'V':
					
				case '^':
					
				default:
					
				}
				
				currentPosition.x++;
			}
			else {
				
				currentPosition.y++;
				currentPosition.x = 0;
			}
		}
	}
}
