package clueGame;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class HumanPlayer extends Player {

	public HumanPlayer(String name, String color, int startingIndexedLocation) {
		super(name, color, startingIndexedLocation);
	}
	
	@Override
	public boolean isHuman() { return true; }
	

	
}