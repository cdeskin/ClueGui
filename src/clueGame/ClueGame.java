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
		this.setSize(new Dimension(820,880) );
		addElements();
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
		JLabel nameLabel = new JLabel("Name");
		add(nameLabel, BorderLayout.EAST);

	
	} 


}
