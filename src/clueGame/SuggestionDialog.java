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

public class SuggestionDialog extends JDialog {
	public JComboBox<String> personCombo, roomCombo, weaponCombo;
	private String roomName;
	private ArrayList<Card> peopleDeck, weaponDeck;

	public SuggestionDialog(String roomName, ArrayList<Card> peopleDeck, ArrayList<Card> weaponDeck) {  //constructor
		this.setTitle("Make a Suggestion");
		this.setSize(new Dimension(750,200) );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.roomName = roomName;
		this.peopleDeck = peopleDeck;
		this.weaponDeck = weaponDeck;
		addElements();
	}

	public void addElements() {
		setLayout(new GridLayout(0,3));

		JLabel personLabel = new JLabel("Person Suggestion");
		JLabel roomLabel = new JLabel("Room Suggestion");
		JLabel weaponLabel = new JLabel("Weapon Suggestion");

		roomCombo = new JComboBox<String>();
		roomCombo.addItem(roomName);
		roomCombo.setEnabled(false);

		personCombo = new JComboBox<String>();
		for(Card tempCard : peopleDeck){
			personCombo.addItem(tempCard.name);
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
		JButton suggestButton = new JButton("Suggest");
		add(suggestButton);
		suggestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				setVisible(false);
				//send info to makeAccusation in board

			}
		});
	}
}
