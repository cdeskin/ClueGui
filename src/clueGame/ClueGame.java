package clueGame;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

//graphics imports
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.MenuBar;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//team imports
import clueGame.Card.CardType;
import clueGame.Board;

public class ClueGame extends JFrame {
	private java.awt.Color userColor;
	private DetectiveNotes detectiveNotes;



	
	public ClueGame() throws FileNotFoundException, BadConfigFormatException {  //constructor
		//Board board = new Board();
		this.setTitle("Clue Game");
		this.setSize(new Dimension(820,780) );

		
		addElements();
		//addGridElements();
		detectiveNotes = new DetectiveNotes();
		detectiveNotes.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	} // end default constructor

	public void addElements(){
		JMenuBar menubar=new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem show = new JMenuItem("Show Detective Notes");
		JMenuItem Exit = new JMenuItem("Exit");
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		show.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Show detective notes");
				detectiveNotes.setVisible(true);
			}
		});
		
		fileMenu.add(Exit);
		fileMenu.add(show);
		menubar.add(fileMenu);
		this.setJMenuBar(menubar); 

	} 
	
//	public void addGridElements(ArrayList<Player> allPlayers) { //public void addGridElements(ArrayList<Player> allPlayers)
//		setLayout(new BorderLayout());
//		
//		//Pass info to playerDisplay
//		ArrayList<Card> displayCards = new ArrayList<Card>();
//		displayCards = allPlayers.get(0).getPlayerCards();
//		PlayerDisplay playerDisplay = new PlayerDisplay(displayCards);
//		GameControlPanel gameControlPanel = new GameControlPanel();	
//		
//		//next 5 lines for debugging - shows what cards a player has
//		int playerNumber = 2;
//		for(int i = 0; i < displayCards.size(); i++) {
//			displayCards = allPlayers.get(playerNumber).getPlayerCards();
//			System.out.println("size: " + displayCards.size());
//			System.out.println("Player: " + allPlayers.get(playerNumber).name.toString()  +","  + displayCards.get(i).type.toString() + ", "  + displayCards.get(i).name.toString());
//		}
//
//
//		playerDisplay.setVisible(true);
//		add(playerDisplay, BorderLayout.EAST);
//		gameControlPanel.setVisible(true);
//		add(gameControlPanel, BorderLayout.SOUTH);
//	}


}
