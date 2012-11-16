package clueGame;

import java.awt.Checkbox;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccusationDialog extends JDialog {
	public JComboBox<String> personCombo, roomCombo, weaponCombo;
	public ArrayList<Card> peopleDeck, roomDeck, weaponDeck;
	
	public AccusationDialog(ArrayList<Card> peopleDeck, ArrayList<Card> roomDeck, ArrayList<Card> weaponDeck) {  //constructor
		this.setTitle("Make an Accusation");
		this.setSize(new Dimension(750,200) );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.peopleDeck = peopleDeck;
		this.roomDeck = roomDeck;
		this.weaponDeck = weaponDeck;
		addElements();
	}
	
	public void addElements() {
		setLayout(new GridLayout(0,3));
		
		JLabel personLabel = new JLabel("Person Accusation");
		JLabel roomLabel = new JLabel("Room Accusation");
		JLabel weaponLabel = new JLabel("Weapon Accusation");
	
		personCombo = new JComboBox<String>();
		for(Card tempCard : peopleDeck){
			personCombo.addItem(tempCard.name);
		}
		
		roomCombo = new JComboBox<String>();
		for(Card tempCard : roomDeck){
			roomCombo.addItem(tempCard.name);
		}
		
		weaponCombo = new JComboBox<String>();
		for(Card tempCard : weaponDeck){
			weaponCombo.addItem(tempCard.name);
		}

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
