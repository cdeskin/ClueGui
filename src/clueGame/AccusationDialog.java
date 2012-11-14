package clueGame;

import java.awt.Checkbox;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class AccusationDialog extends JDialog {
	public AccusationDialog() {  //constructor
		this.setTitle("Accusation");
		this.setSize(new Dimension(750,200) );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		addElements();
	}
	
	public void addElements() {
		setLayout(new GridLayout(0,3));
		PersonAccusation peopleAccusation = new PersonAccusation();
		add(peopleAccusation);
		RoomAccusation roomAccusation = new RoomAccusation();
		add(roomAccusation);
		WeaponAccusation weaponAccusation = new WeaponAccusation();
		add(weaponAccusation);
		JButton accuseButton = new JButton("Accuse!");
		add(accuseButton);
		accuseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				setVisible(false);
				//send info to makeAccusation in board
				
			}
		});
	}
	
	public class PersonAccusation extends JPanel {
		private JComboBox<String> combo;
		public PersonAccusation(){
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
	
	public class RoomAccusation extends JPanel {
		private JComboBox<String> combo;
		public RoomAccusation(){
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
	
	public class WeaponAccusation extends JPanel {
		private JComboBox<String> combo;
		private Checkbox candlestick, leadPipe, rope, knife, revolver, wrench;
		public WeaponAccusation(){
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Weapon Guess"));
			
			combo = new JComboBox<String>();
			combo.addItem("Candlestick");
			combo.addItem("Lead Pipe");
			combo.addItem("Rope");
			combo.addItem("Knife");
			combo.addItem("Revolver");
			combo.addItem("Wrench");

			add(combo);
		}
	}
}
