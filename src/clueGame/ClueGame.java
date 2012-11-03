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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.MenuBar;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//team imports
import clueGame.Card.CardType;

public class ClueGame extends JFrame {
	private java.awt.Color userColor;
	private JTextField name;
	// board panel is already defined?
	//private ourpanelclass localname = new ourPanelClass();
	//private ourpanelclass localname = new ourPanelClass();
	
	public ClueGame() {  //constructor
		setTitle("Clue Game");
		setSize(new Dimension(500,500) );
		
		JLabel nameLabel = new JLabel("Name");
		name = new JTextField(20);
		add(nameLabel, BorderLayout.NORTH);
		add(name, BorderLayout.CENTER);
		
		JButton nameButton = new JButton("OK");
		add(nameButton, BorderLayout.SOUTH);
	}

	
	public static void main(String[] args) throws FileNotFoundException, BadConfigFormatException {
		System.out.println("Hello world!!!\n");
		
		@SuppressWarnings("unused")
		ClueGame clueGame= new ClueGame();
		Board board = new Board();
		
		
		
		clueGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clueGame.setVisible(true);
		
		
//		System.out.println("Starting positions for players (given by index): ");
//		System.out.println("Miss Scarlet: " + board.calcIndex(13, 22));
//		System.out.println("Mr. Green: " + board.calcIndex(21, 6));
//		System.out.println("Mrs. Peacock: " + board.calcIndex(0, 4));
//		System.out.println("Colonel Mustard: " + board.calcIndex(21, 15));
//		System.out.println("Mrs. White: " + board.calcIndex(13, 0));
//		System.out.println("Professor Plum: " + board.calcIndex(0, 19));
	
		System.out.println("\nGoodbye world..");

	}

}
