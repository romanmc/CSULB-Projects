package starWars;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.*;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.io.FileNotFoundException;


import javax.swing.*;

/**
 * displays a window for the game
 * @author Roman
 */
public class SW_Window extends JFrame {
	

	/**
	 * creates the window
	 */
	public static void main(String[] args) {
		
		
		System.out.println("What is your name?");
		
		Map newMap = Map.getInstance();
		
		newMap.loadMap(1);
		
		Hero theHero = new Hero(CheckInput.getString(), newMap);

		int direction;

		boolean alive = true;
		
		SW_Window w = new SW_Window(theHero);
		
		
		/*while (alive) {
			
			
			theHero.display();

			direction = CheckInput.getIntRange(1, 4);
			
			
			if ( direction == 1 ) {
				theHero.goNorth();
			}
			else if ( direction == 2 ) {
				theHero.goSouth();
			}
			else if ( direction == 3 ) {
				theHero.goEast();
			}
			else if ( direction == 4 ) {
				theHero.goWest();
			}
			
			
			
			newMap.reveal(theHero.getLocation());
			
			ItemGenerator newIG = new ItemGenerator();
			EnemyGenerator newEG = new EnemyGenerator(newIG);
			
			if ( newMap.getCharAtLoc(theHero.getLocation()) == 'e' ) {
				
				enemyRoom(theHero, newMap, newEG);
			}
			else if ( newMap.getCharAtLoc(theHero.getLocation()) == 'i' ) {
				
				itemRoom(theHero, newMap, newIG);
			}
		
		}*/
		
	}
	
	/**
	 * constructs the window
	 */
	public SW_Window(Hero h) {
		
		setBounds( 100, 100, 500, 500);
		setTitle( "Star Wars Mission" );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setContentPane( new Panel(h) );
		setVisible( true );
		
	}
	/**
	 * creates panel that displays all the stuff on the window
	 * @author Roman
	 *
	 */
	public class Panel extends JPanel implements ActionListener, KeyListener {
		
		private JTextField[][] points = new JTextField[5][5];
		private JTextField[] inv = new JTextField[5];
		private JLabel charInfo, name, hName, level, hLevel, hp, hHP, inventory,
		desc, eHP, eName, eLevel, eHPlbl;
		private JButton fight, run;
		private Hero hero;
		private Character newEnemy;
		boolean fighting = false;
		/**
		 * constructs the panel with all the GUI items
		 */
		public Panel(Hero h) {
			GroupLayout layout1 = new GroupLayout(this);
			this.setLayout(layout1);
			addKeyListener( this );
			setFocusable( true );

			this.hero = h;
			
			Dimension d = new Dimension(60, 60);
			
			for ( int x = 0; x < 5; x++ ) {
				for ( int y = 0; y < 5; y++ ) {
					points[x][y] = new JTextField("");
					points[x][y].setEditable(false);
					points[x][y].setMinimumSize(d);
					points[x][y].setMaximumSize(d);
				}
			}
			
			charInfo = new JLabel("Character Information");
			name = new JLabel("Name: ");
			hName = new JLabel(this.hero.getName());
			level = new JLabel("Level: ");
			hLevel = new JLabel(String.valueOf(hero.getLevel()));
			hp = new JLabel("HP: ");
			hHP = new JLabel(String.valueOf(hero.getHP()));
			
			inventory = new JLabel("Inventory: ");
			
			Dimension d1 = new Dimension(30, 30);
			
			for ( int i = 0; i < 5; i++ ) {
				inv[i] = new JTextField("");
				inv[i].setEditable(false);
				inv[i].setMaximumSize(d1);
				inv[i].setMinimumSize(d1);
			}
		
			desc = new JLabel("");
			eHP = new JLabel("");
			eName = new JLabel("");
			eLevel = new JLabel("");
			eHPlbl = new JLabel("HP: ");
			
			eHPlbl.setVisible(false);
			
			fight = new JButton("Fight!");
			fight.addActionListener(this);
			run = new JButton("Run Away");
			run.addActionListener(this);
			
			fight.setVisible(false);
			run.setVisible(false);
			
			layout1.setVerticalGroup(
					layout1.createSequentialGroup()
					.addGroup(layout1.createParallelGroup()
							.addComponent(points[0][0])
							.addComponent(points[1][0])
							.addComponent(points[2][0])
							.addComponent(points[3][0])
							.addComponent(points[4][0]))
					.addGroup(layout1.createParallelGroup()
							.addComponent(points[0][1])
							.addComponent(points[1][1])
							.addComponent(points[2][1])
							.addComponent(points[3][1])
							.addComponent(points[4][1]))
					.addGroup(layout1.createParallelGroup()
							.addComponent(points[0][2])
							.addComponent(points[1][2])
							.addComponent(points[2][2])
							.addComponent(points[3][2])
							.addComponent(points[4][2]))
					.addGroup(layout1.createParallelGroup()
							.addComponent(points[0][3])
							.addComponent(points[1][3])
							.addComponent(points[2][3])
							.addComponent(points[3][3])
							.addComponent(points[4][3]))
					.addGroup(layout1.createParallelGroup()
							.addComponent(points[0][4])
							.addComponent(points[1][4])
							.addComponent(points[2][4])
							.addComponent(points[3][4])
							.addComponent(points[4][4]))
					.addGap(30)
					.addGroup(layout1.createParallelGroup()
							.addComponent(charInfo)
							.addComponent(inventory)
							.addComponent(desc)
							)
					.addGap(15)
					.addGroup(layout1.createParallelGroup()
							.addComponent(name)
							.addComponent(hName)
							.addComponent(inv[0])
							.addComponent(inv[1])
							.addComponent(inv[2])
							.addComponent(eName)
							)
					.addGroup(layout1.createParallelGroup()
							.addComponent(level)
							.addComponent(hLevel)
							.addComponent(inv[3])
							.addComponent(inv[4])
							.addComponent(eLevel)
							)
					.addGroup(layout1.createParallelGroup()
							.addComponent(hp)
							.addComponent(hHP)
							.addComponent(eHPlbl)
							.addComponent(eHP))
					.addGroup(layout1.createParallelGroup()
							.addComponent(fight)
							.addComponent(run))
							);

			
			layout1.setHorizontalGroup(
					layout1.createParallelGroup()
					.addGroup(layout1.createSequentialGroup()
							.addComponent(points[0][0])
							.addComponent(points[1][0])
							.addComponent(points[2][0])
							.addComponent(points[3][0])
							.addComponent(points[4][0]))
					.addGroup(layout1.createSequentialGroup()
							.addComponent(points[0][1])
							.addComponent(points[1][1])
							.addComponent(points[2][1])
							.addComponent(points[3][1])
							.addComponent(points[4][1]))
					.addGroup(layout1.createSequentialGroup()
							.addComponent(points[0][2])
							.addComponent(points[1][2])
							.addComponent(points[2][2])
							.addComponent(points[3][2])
							.addComponent(points[4][2]))
					.addGroup(layout1.createSequentialGroup()
							.addComponent(points[0][3])
							.addComponent(points[1][3])
							.addComponent(points[2][3])
							.addComponent(points[3][3])
							.addComponent(points[4][3]))
					.addGroup(layout1.createSequentialGroup()
							.addComponent(points[0][4])
							.addComponent(points[1][4])
							.addComponent(points[2][4])
							.addComponent(points[3][4])
							.addComponent(points[4][4]))
					.addGroup(layout1.createSequentialGroup()
							.addComponent(charInfo)
							.addGap(30)
							.addComponent(inventory)
							.addGap(30)
							.addComponent(desc))	
					.addGroup(layout1.createSequentialGroup()
							.addComponent(name)
							.addComponent(hName)
							.addGap(80)
							.addComponent(inv[0])
							.addComponent(inv[1])
							.addComponent(inv[2])
							.addGap(50)
							.addComponent(eName)
							)
					.addGroup(layout1.createSequentialGroup()
							.addComponent(level)
							.addComponent(hLevel)
							.addGap(110)
							.addComponent(inv[3])
							.addComponent(inv[4])
							.addGap(64)
							.addComponent(eLevel)
							)

					.addGroup(layout1.createSequentialGroup()
							.addComponent(hp)
							.addComponent(hHP)
							.addGap(240)
							.addComponent(eHPlbl)
							.addComponent(eHP))
					.addGroup(layout1.createSequentialGroup()
							.addGap(240)
							.addComponent(fight)
							.addGap(20)
							.addComponent(run))
					);
			
			this.updateDisplay();
		}
		/**
		 * will trigger when the player enters a room with an enemy
		 */
		public void enemyRoom() {
			
			fighting = true;
			
			Map m = hero.getMap();
			ItemGenerator newIG = ItemGenerator.getInstance();
			System.out.println("wd");
			EnemyGenerator eg = EnemyGenerator.getInstance(newIG, hero);
			newEnemy = eg.generateEnemy(hero.getLevel());
			System.out.println(newEnemy.toStringz());
			System.out.println(newEnemy.getName());

			String description = "You've encountered a " + newEnemy.getName();
			String enemyName = "Name " + newEnemy.getName();
			String enemyLvl = "Lvl:" + newEnemy.getLevel();		
			String enemyHP = String.valueOf(newEnemy.getHP());
			
			desc.setText(description);
			eHP.setText(enemyHP);
			eName.setText(enemyName);
			eLevel.setText(enemyLvl);
			
			eHPlbl.setVisible(true);
			
			fight.setVisible(true);
			run.setVisible(true);

			m.removeCharAtLoc(hero.getLocation());
						
		}
		/**
		 * will trigger when the player enters a room with an item
	 	 */
		public void itemRoom() {
			System.out.println("bef");
			Map m = hero.getMap();
			System.out.println("map");
			ItemGenerator ig = ItemGenerator.getInstance();
			System.out.println("aft");
			Item randItem = ig.generateItem();	

			hero.pickUpItem(randItem);
			

			
			
			for ( int i = 0; i < 5; i++ ) {
				if ( inv[i].getText().compareTo("") == 0 ) {
					desc.setText("Picked up a " + randItem.getName());
					if ( randItem.getName().compareTo("Med Kit") == 0 ) {
						inv[i].setText("M");
						break;
					}
					else if ( randItem.getName().compareTo("Holocron") == 0 ) {
						inv[i].setText("H");
						break;
					}
					else if ( randItem.getName().compareTo("Key") == 0 ) {
						inv[i].setText("K");
						break;
					}
					else {
						inv[i].setText("A");
						break;
					}
				}
				else {
					desc.setText("Your inventory is full!");
				}
			}

			m.removeCharAtLoc(hero.getLocation());
		}
		/**
		 * will trigger when the player decides to fight an enemy
		 */

		public void fight() {
			
			hero.attack(newEnemy);
			newEnemy.attack(hero);
			eHP.setText(String.valueOf(newEnemy.getHP()));
		
			if ( hero.getHP() <= 0 ) {
				clearFight("Game Over");
				fighting = true;
			}
			else if ( newEnemy.getHP() <= 0 ) {
				
				hero.pickUpItem(newEnemy.getItem());
				for ( int i = 0; i < 5; i++ ) {
					if ( inv[i].getText().compareTo("") == 0 ) {
						desc.setText("Picked up a " + newEnemy.getItem().getName());
						if ( newEnemy.getItem().getName().compareTo("Med Kit") == 0 ) {
							inv[i].setText("M");
							break;
						}
						else if ( newEnemy.getItem().getName().compareTo("Holocron") == 0 ) {
							inv[i].setText("H");
							break;
						}
						else if ( newEnemy.getItem().getName().compareTo("Key") == 0 ) {
							inv[i].setText("K");
							break;
						}
						else {
							inv[i].setText("A");
							break;
						}
					}
					else {
						desc.setText("Your inventory is full!");
					}
					
				}

				clearFight("The " + newEnemy.getName() + " has been defeated!");
			}

		}
		/**
		 * clears some gui stuff after finishing a fight
		 * @param s string that will be set to description depending on
		 * why the fight is finished
		 */
		public void clearFight(String s) {
			fight.setVisible(false);
			run.setVisible(false);
			eHPlbl.setVisible(false);
			fighting = false;
			desc.setText(s);
			eHP.setText("");
			eLevel.setText("");
			eName.setText("");
		}
		/**
		 * updates the panel whenever the user moves or pushes a button
		 */
		public void updateDisplay() {
			System.out.println("update");

			
			hName.setText(hero.getName());
			if ( hero.getHP() > 0 ) {
				hHP.setText(String.valueOf(hero.getHP()));
			}
			else {
				hHP.setText("0");
			}
			
			Point p = hero.getLocation();
			System.out.println(p);

			points[p.x][p.y].setText("*");
			
			if ( hero.charAtLoc() == 'e' ) {
				System.out.println("ene");

				enemyRoom();
			}
			if ( hero.charAtLoc() == 'i' ) {
				System.out.println("item");

				itemRoom();
			}
		}
		/**
		 * provides functionality for the buttons
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
		
			if ( e.getSource() == fight ) {

				fight();
				
				updateDisplay();
				

			}
			else if ( e.getSource() == run ) {
				
				Point p = hero.getLocation();
				points[p.x][p.y].setText(String.valueOf(hero.charAtLoc()));
				
				Random randDirection = new Random();
				int direction = randDirection.nextInt(( 4 - 1 ) + 1 );
					if ( direction == 1 ) {
						hero.goNorth();
					}
					else if ( direction == 2 ) {
						hero.goSouth();
					}
					else if ( direction == 3 ) {
						hero.goWest();
					}
					else {
						hero.goEast();
					}
					
					updateDisplay();
					
					clearFight("you ran away!");
					
			}
			

		
			
		}
		/**
		 * lets the player move the hero using the keys 'WASD'
		 */
		@Override
		public void keyPressed( KeyEvent e ){
			if ( !fighting ) {
				Point p = hero.getLocation();
				points[p.x][p.y].setText(String.valueOf(hero.charAtLoc()));
				
				if ( e.getKeyCode() == KeyEvent.VK_A ) {
					
					hero.goWest();
				}
				else if ( e.getKeyCode() == KeyEvent.VK_W ) {
					
					hero.goNorth();
				}
				else if ( e.getKeyCode() == KeyEvent.VK_D ) {
					
					hero.goEast();
				}
				else if ( e.getKeyCode() == KeyEvent.VK_S ) {
					
					hero.goSouth();
				}
				else {
					return;
				}
				
				updateDisplay();
			}	

		}
		/**
		 * here because they're abstract
		 */
		public void keyReleased( KeyEvent e ) {}
		public void keyTyped( KeyEvent e ) {} 
		
	}

}