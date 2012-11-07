package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HumanPlayer extends Player {
	//graphics	
	static final int SCALER = Board.SCALER;
	static final int GRID_COLUMNS = Board.GRID_COLUMNS;
	private int gridY;
	private int gridX;
	Color color;

	public HumanPlayer(String name, String color, int startingIndexedLocation) {
		super(name, color, startingIndexedLocation);
		// need to convert index to row/column
		//graphics
		int row =  startingIndexedLocation / GRID_COLUMNS; 
		int column = startingIndexedLocation - (GRID_COLUMNS * row);
		this.gridY = row*SCALER;  
		this.gridX = column*SCALER;

	}

	@Override
	public boolean isHuman() { return true; }

	//graphics
	public void draw(Graphics g) {
		//System.out.println("GridX: " + gridX + ", GridY: "+ gridY);
		g.setColor(Color.RED);
		g.fillOval(gridX, gridY, SCALER, SCALER);
		g.setColor(Color.BLACK);
		g.drawOval(gridX, gridY, SCALER, SCALER);
	}

}