package starWars;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * functionality for the map for star wars game
 * @author Roman
 *
 */
public class Map {
	/**
	 * array of characters that is the set of rooms in the map
	 */
	private char[][] map = new char[5][5];
	/**
	 * array that show which characters have already been revealed
	 */
	private boolean[][] revealed = new boolean[5][5];
	/**
	 * makes map a singleton where the instance is null by default
	 */
	private static Map instance = null;
	/**
	 * constructor for map
	 */
	
	private Map() {
		
	}
	/**
	 * lets the program get a single instance of a map
	 * @return the instance
	 */
	public static Map getInstance() {
		if ( instance == null ) {
			instance = new Map();
		}
		return instance;
	}
	/**
	 * will decide which map should be loaded
	 * @param mapNum the number of the map that will be loaded
	 */
	public void loadMap(int mapNum) {
		
		for ( int i = 0; i < 5; i++ ) {
			for ( int j = 0; j < 5; j++ ) {
				revealed[i][j] = false;
			}
		} 
		
		
		try {
			if (mapNum == 1) {

				File map1File = new File("/Users/Roman/CSULB-Projects/Star Wars/src/starWars/Map1.txt");

				Scanner map1SC = new Scanner(map1File);
				
				while (map1SC.hasNextLine()) {
					
					
					for ( int x = 0; x < 5; x++ ) {
						char[] charLine = map1SC.nextLine().replace(" ", "").toCharArray();
						for ( int y  = 0; y < 5; y++) {
							
							
							map[x][y] = charLine[y];
							
							
						}

					}
							
				}
				
				map1SC.close();


			}

	

			else if (mapNum == 2) {
				File map2File = new File("/Users/Roman/CSULB-Projects/Star Wars/src/starWars/Map2.txt");
				
				Scanner map2SC = new Scanner(map2File);
				
				while (map2SC.hasNextLine()) {
					char[] charLine = map2SC.nextLine().toCharArray();
					
					for ( int x = 0; x < 5; x++ ) {
						for ( int y  = 0; y < 5; y++) {
							map[x][y] = charLine[y];
						}

					}
					
					
				}
				
				map2SC.close();


			}

			else if (mapNum == 3) {

				File map3File = new File("/Users/Roman/CSULB-Projects/Star Wars/src/starWars/Map3.txt");

				Scanner map3SC = new Scanner(map3File);

				while (map3SC.hasNextLine()) {
					char[] charLine = map3SC.nextLine().toCharArray();
					
					for ( int x = 0; x < 5; x++ ) {
						for ( int y  = 0; y < 5; y++) {
							map[x][y] = charLine[y];
						}

					}
					
					
				}

				map3SC.close();
	
			}
		
		} catch ( FileNotFoundException e ) {
			System.out.println("file not found");
		}
		
		
	}
	/**
	 * finds the character at the location of the hero to
	 * know what kind of room the hero is in
	 * @param p the point that the hero is at
	 * @return the character at the point
	 */
	public char getCharAtLoc(Point p) {
		return map[p.y][p.x];
	}
	
	public void displayMap(Point p) {
		
		System.out.println(p.y);
		System.out.println(p.x);
		revealed[p.y][p.x] = true;
		
		String[] displayTextMap = new String[25];
		int i = 0;
		for ( int y = 0; y < 5; y++ ) {
			for ( int x = 0; x < 5; x++ ) {
				if ( p.x == x && p.y == y ) {
					displayTextMap[i] = "* ";
				}
				else if ( revealed[y][x] == false ) {
					displayTextMap[i] = "X ";
				}
				else {
					String tile = map[y][x] + " ";
					
					displayTextMap[i] = tile;
				}
				i++;
			}
		}
		i = 0;
		for ( int y = 0; y < 5; y++ ) {
			for ( int x = 0; x < 5; x++ ) {
				System.out.print(displayTextMap[i]);
				i++;
			}
		}
		
		
	}
	/**
	 * will find where the hero is intended to start
	 * @return the point location of the 's' on the map
	 */
	public Point findStart() {
		
		for ( int x = 0; x < 5; x++ ) {
			for ( int y = 0; y < 5; y++ ) {
				if( map[x][y] == 's')
					{
						Point start = new Point (y,x);
						return start;
								
					}
			}
		}
		
		return null;



	}
	/**
	 * changes the location from an X to whatever character relates to
	 * the room after the character has already visited it
	 * @param p the point where the hero visited
	 */
	public void reveal(Point p) {
		revealed[p.y][p.x] = true;
	}
	/**
	 * gets rid of the X from the location the hero has already visited
	 * @param p the point where the hero visited
	 */
	public void removeCharAtLoc(Point p) {
		map[p.y][p.x] = 'n';
	}
	
}
