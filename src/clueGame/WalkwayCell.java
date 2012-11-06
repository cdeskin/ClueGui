package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WalkwayCell extends BoardCell {
	private int gridY;
	private int gridX;
	private int pixelsPerRow = 660/22;   //magic numbers!
	private int pixelsPerCol = 660/23;

	public WalkwayCell(int row, int column) {
		this.row = row;
		this.column = column;
		this.gridY = row*pixelsPerRow;  
		this.gridX = column*pixelsPerCol;
		repaint();
		
	}
	
	public boolean isWalkway() { 
		return true;
		}

	// paintComponent is called automatically when the frame needs
	// to display (e.g., when the program starts)
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.drawRect(gridX, gridY, 20, 20);
		System.out.println("painted a cell");
		
	}
	
	@Override
	public void updateGridMap() {
		repaint();
	}

	
	
}
