package clueGame;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class CardPanel extends JPanel {
	
	public CardPanel(String cardTypeData, String cardNameData) {
		Color color = new Color(225,225,225);
		setLayout(new GridLayout(4,0));
		setBorder(BorderFactory.createTitledBorder("Card"));
		this.setBackground(color);

		JLabel cardLabel = new JLabel(cardTypeData);
		JTextField cardName = new JTextField(cardNameData);
		add(cardLabel);
		add(cardName);
		
	}

}
