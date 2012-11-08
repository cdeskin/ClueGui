package clueGame;

import java.awt.*;
import java.io.FileNotFoundException;
import javax.swing.*;


public class DetectiveNotes extends JFrame {
	public DetectiveNotes() {  //constructor
		this.setTitle("Detective Notes");
		this.setSize(new Dimension(500,500) );
		addElements();
	}
	public void addElements() {
		setLayout(new GridLayout(0,2));
		PeoplePanel peoplePanel = new PeoplePanel();
		add(peoplePanel);
		
		RoomPanel roomPanel = new RoomPanel();
		add(roomPanel);
		
		WeaponPanel weaponPanel = new WeaponPanel();
		add(weaponPanel);
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
		private Checkbox candlestick, leadPipe, rope, knife, revolver, wrench;
		public WeaponPanel(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Weapons"));
			
			candlestick = new Checkbox("Candlestick");
			leadPipe = new Checkbox("Lead Pipe");
			rope = new Checkbox("Rope");
			knife = new Checkbox("Knife");
			revolver = new Checkbox("Revolver");
			wrench = new Checkbox("Wrench");
			
			add(candlestick);
			add(leadPipe);
			add(rope);
			add(knife);
			add(revolver);
			add(wrench);
		}
	}
}

