package clueGame;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.*;

public class PlayerDisplay extends JPanel {
	private CardPanel cardPanel;
	static final int PANEL_WIDTH = 150;

	public PlayerDisplay(ArrayList<Card> displayCards) {

		this.setBorder(BorderFactory.createTitledBorder("Player Panel"));

		for(int i = 0; i < displayCards.size(); i++) {
			cardPanel = new CardPanel(displayCards.get(i).type.toString(), displayCards.get(i).name.toString() );
			cardPanel.setVisible(true);
			add(cardPanel);
		}
	}

	@Override
	public Dimension getPreferredSize() {  // sets the size the PlayerDisplay
		return new Dimension(PANEL_WIDTH, 0); // kill the magic numbers!
	}
}
