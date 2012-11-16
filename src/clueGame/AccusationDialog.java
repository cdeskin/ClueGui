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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccusationDialog extends JDialog {
	public JComboBox<String> personCombo, roomCombo, weaponCombo;
	
	public AccusationDialog() {  //constructor
		this.setTitle("Make an Accusation");
		this.setSize(new Dimension(750,200) );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		addElements();
	}
	
	public void addElements() {
		setLayout(new GridLayout(0,3));
		
		JLabel personLabel = new JLabel("Person Accusation");
		JLabel roomLabel = new JLabel("Room Accusation");
		JLabel weaponLabel = new JLabel("Weapon Accusation");
	
		personCombo = new JComboBox<String>();
		personCombo.addItem("Miss Scarlet");
		personCombo.addItem("Mr. Green");
		personCombo.addItem("Mrs. Peacock");
		personCombo.addItem("Colonel Mustard");
		personCombo.addItem("Mrs. White");
		personCombo.addItem("Professor Plum");
		
		roomCombo = new JComboBox<String>();
		roomCombo.addItem("Kitchen");
		roomCombo.addItem("Lounge");
		roomCombo.addItem("Conservatory");
		roomCombo.addItem("Study");
		roomCombo.addItem("Billiard Room");
		roomCombo.addItem("Ballroom");
		roomCombo.addItem("Hall");
		roomCombo.addItem("Dining Room");
		roomCombo.addItem("Library");
		
		weaponCombo = new JComboBox<String>();
		weaponCombo.addItem("Candlestick");
		weaponCombo.addItem("Lead Pipe");
		weaponCombo.addItem("Rope");
		weaponCombo.addItem("Knife");
		weaponCombo.addItem("Revolver");
		weaponCombo.addItem("Wrench");
		weaponCombo.addItem("Gossip");
		weaponCombo.addItem("Death Glare");

		add(personLabel);
		add(roomLabel);
		add(weaponLabel);
		add(personCombo);
		add(roomCombo);
		add(weaponCombo);
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
	
	
}
