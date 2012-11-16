package clueGame;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.*;


public class DetectiveNotes extends JDialog {
	ArrayList<Card> peopleDeck, roomDeck, weaponDeck;
	public DetectiveNotes(ArrayList<Card> peopleDeck, ArrayList<Card> roomDeck, ArrayList<Card> weaponDeck) {  //constructor
		this.setTitle("Detective Notes");
		this.setSize(new Dimension(500,500) );
		this.peopleDeck = peopleDeck;
		this.roomDeck = roomDeck;
		this.weaponDeck = weaponDeck;
		addElements();
	}
	public void addElements() {
		setLayout(new GridLayout(0,2));
		PeoplePanel peoplePanel = new PeoplePanel(peopleDeck);
		add(peoplePanel);
		PeopleGuess peopleGuess = new PeopleGuess(peopleDeck);
		add(peopleGuess);
		RoomPanel roomPanel = new RoomPanel(roomDeck);
		add(roomPanel);
		RoomGuess roomGuess = new RoomGuess(roomDeck);
		add(roomGuess);
		WeaponPanel weaponPanel = new WeaponPanel(weaponDeck);
		add(weaponPanel);
		WeaponGuess weaponGuess = new WeaponGuess(weaponDeck);
		add(weaponGuess);
	}
	
	public class PeoplePanel extends JPanel {
		public PeoplePanel(ArrayList<Card> peopleDeck){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("People"));
			
			for(Card tempCard : peopleDeck)
				add(new Checkbox(tempCard.name));
		}
	}
	
	public class RoomPanel extends JPanel {
		public RoomPanel(ArrayList<Card> roomDeck){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Room"));
			
			for(Card tempCard : roomDeck)
				add(new Checkbox(tempCard.name));
		}
	}
	
	public class WeaponPanel extends JPanel {
		public WeaponPanel(ArrayList<Card> weaponDeck){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Weapons"));
			
			for(Card tempCard : weaponDeck)
				add(new Checkbox(tempCard.name));
		}
	}
	
	public class PeopleGuess extends JPanel {
		private JComboBox<String> combo;
		public PeopleGuess(ArrayList<Card> peopleDeck){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Person Guess"));
			
			combo = new JComboBox<String>();
			for(Card tempCard : peopleDeck){
				combo.addItem(tempCard.name);
			}

			add(combo);
		}
	}
	
	public class RoomGuess extends JPanel {
		private JComboBox<String> combo;
		public RoomGuess(ArrayList<Card> roomDeck){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Room Guess"));
			
			combo = new JComboBox<String>();
			for(Card tempCard : roomDeck){
				combo.addItem(tempCard.name);
			}

			add(combo);
		}
	}
	
	public class WeaponGuess extends JPanel {
		private JComboBox<String> combo;
		private Checkbox candlestick, leadPipe, rope, knife, revolver, wrench;
		public WeaponGuess(ArrayList<Card> weaponDeck){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Weapon Guess"));
			
			combo = new JComboBox<String>();
			for(Card tempCard : weaponDeck){
				combo.addItem(tempCard.name);
			}

			add(combo);
		}
	}
	

}

