package clueGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class CardPanel extends JPanel {
	
	public CardPanel(String cardTypeData, String cardNameData) {
		Color color = new Color(225,225,225);
		setLayout(new GridLayout(4,0));
		setPreferredSize(new Dimension(100, 100));
		setBorder(BorderFactory.createTitledBorder(cardTypeData));
		this.setBackground(color);

		JTextField cardName = new JTextField(cardNameData);
		add(cardName);
		
	}

}
