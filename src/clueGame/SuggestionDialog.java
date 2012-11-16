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

public class SuggestionDialog extends JDialog {
	public JComboBox<String> personCombo, roomCombo, weaponCombo;
	private String roomName;

	public SuggestionDialog(String roomName) {  //constructor
		this.setTitle("Make a Suggestion");
		this.setSize(new Dimension(750,200) );
		this.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		this.roomName = roomName;
		addElements();
	}

	public void addElements() {
		setLayout(new GridLayout(0,3));

		JLabel personLabel = new JLabel("Person Suggestion");
		JLabel roomLabel = new JLabel("Room Suggestion");
		JLabel weaponLabel = new JLabel("Weapon Suggestion");

		personCombo = new JComboBox<String>();
		personCombo.addItem("Miss Scarlet");
		personCombo.addItem("Mr. Green");
		personCombo.addItem("Miss Peacock");
		personCombo.addItem("Colonel Mustard");
		personCombo.addItem("Miss White");
		personCombo.addItem("Professor Plum");

		roomCombo = new JComboBox<String>();
		roomCombo.addItem(roomName);
		roomCombo.setEnabled(false);

		weaponCombo = new JComboBox<String>();
		weaponCombo.addItem("Candlestick");
		weaponCombo.addItem("Lead Pipe");
		weaponCombo.addItem("Rope");
		weaponCombo.addItem("Knife");
		weaponCombo.addItem("Revolver");
		weaponCombo.addItem("Wrench");
		weaponCombo.addItem("Gossip");
		weaponCombo.addItem("Death Stare");

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
