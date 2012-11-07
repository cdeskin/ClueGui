package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WalkwayCell extends BoardCell {
	static final int SCALER = Board.SCALER;
	private int gridY;
	private int gridX;

	public WalkwayCell(int row, int column) {
		this.row = row;
		this.column = column;
		this.gridY = row*SCALER;  
		this.gridX = column*SCALER;
	}
	
	public boolean isWalkway() { 
		return true;
		}

	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(gridX, gridY, SCALER, SCALER);
		g.setColor(Color.BLACK);
		g.drawRect(gridX, gridY, SCALER, SCALER);
	}

	
	
}
