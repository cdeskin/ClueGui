package clueGame;

import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;


public class DetectiveNotes extends JDialog {
	public DetectiveNotes() {  //constructor
		this.setTitle("Detective Notes");
		this.setSize(new Dimension(500,500) );
		addElements();
	}
	public void addElements() {
		setLayout(new GridLayout(0,2));
		PeoplePanel peoplePanel = new PeoplePanel();
		add(peoplePanel);
		PeopleGuess peopleGuess = new PeopleGuess();
		add(peopleGuess);
		RoomPanel roomPanel = new RoomPanel();
		add(roomPanel);
		RoomGuess roomGuess = new RoomGuess();
		add(roomGuess);
		WeaponPanel weaponPanel = new WeaponPanel();
		add(weaponPanel);
		WeaponGuess weaponGuess = new WeaponGuess();
		add(weaponGuess);
	}
	
	public class PeoplePanel extends JPanel {
		private Checkbox missScarlet, mrGreen, missPeacock, colonelMustard, missWhite, professorPlum;
		public PeoplePanel(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("People"));
			
			missScarlet = new Checkbox("Miss Scarlet");
			mrGreen = new Checkbox("Mr. Green");
			missPeacock = new Checkbox("Miss Peacock");
			colonelMustard = new Checkbox("Colonel Mustard");
			missWhite = new Checkbox("Miss White");
			professorPlum = new Checkbox("Professor Plum");
			
			add(missScarlet);
			add(mrGreen);
			add(missPeacock);
			add(colonelMustard);
			add(missWhite);
			add(professorPlum);
		}
	}
	
	public class RoomPanel extends JPanel {
		private Checkbox kitchen, lounge, consevatory, study, billiardRoom, ballroom, diningRoom, hall, library;
		public RoomPanel(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Room"));
			
			kitchen = new Checkbox("Kitchen");
			lounge = new Checkbox("Lounge");
			consevatory = new Checkbox("Conservatory");
			study = new Checkbox("Study");
			billiardRoom = new Checkbox("Billiard Room");
			ballroom = new Checkbox("Ballroom");
			diningRoom = new Checkbox("Dining Room");
			hall = new Checkbox("Hall");
			library = new Checkbox("Library");
			
			add(kitchen);
			add(lounge);
			add(consevatory);
			add(study);
			add(billiardRoom);
			add(ballroom);
			add(diningRoom);
			add(hall);
			add(library);
		}
	}
	
	public class WeaponPanel extends JPanel {
		private Checkbox candlestick, leadPipe, rope, knife, revolver, wrench, gossip, deathStare;
		public WeaponPanel(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Weapons"));
			
			candlestick = new Checkbox("Candlestick");
			leadPipe = new Checkbox("Lead Pipe");
			rope = new Checkbox("Rope");
			knife = new Checkbox("Knife");
			revolver = new Checkbox("Revolver");
			wrench = new Checkbox("Wrench");
			gossip = new Checkbox("Gossip");
			deathStare = new Checkbox("Death Stare");
			
			add(candlestick);
			add(leadPipe);
			add(rope);
			add(knife);
			add(revolver);
			add(wrench);
			add(gossip);
			add(deathStare);
		}
	}
	
	public class PeopleGuess extends JPanel {
		private JComboBox<String> combo;
		public PeopleGuess(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Person Guess"));
			
			combo = new JComboBox<String>();
			combo.addItem("Miss Scarlet");
			combo.addItem("Mr. Green");
			combo.addItem("Miss Peacock");
			combo.addItem("Colonel Mustard");
			combo.addItem("Miss White");
			combo.addItem("Professor Plum");

			add(combo);
		}
	}
	
	public class RoomGuess extends JPanel {
		private JComboBox<String> combo;
		public RoomGuess(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Room Guess"));
			
			combo = new JComboBox<String>();
			combo.addItem("Kitchen");
			combo.addItem("Lounge");
			combo.addItem("Conservatory");
			combo.addItem("Study");
			combo.addItem("Billiard Room");
			combo.addItem("Ballroom");
			combo.addItem("Hall");
			combo.addItem("Dining Room");
			combo.addItem("Library");

			add(combo);
		}
	}
	
	public class WeaponGuess extends JPanel {
		private JComboBox<String> combo;
		private Checkbox candlestick, leadPipe, rope, knife, revolver, wrench;
		public WeaponGuess(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Weapon Guess"));
			
			combo = new JComboBox<String>();
			combo.addItem("Candlestick");
			combo.addItem("Lead Pipe");
			combo.addItem("Rope");
			combo.addItem("Knife");
			combo.addItem("Revolver");
			combo.addItem("Wrench");
			combo.addItem("Gossip");
			combo.addItem("Death Stare");

			add(combo);
		}
	}
	

}

