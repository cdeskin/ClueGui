package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class WalkwayCell extends BoardCell {
	private static final int SCALER = 30;
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
	// paintComponent is called automatically when the frame needs
	// to display (e.g., when the program starts)
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.setColor(Color.YELLOW);
//		g.drawRect(gridX, gridY, 20, 20);
//		System.out.println("painted a cell");
//		
//	}
//	
//	@Override
//	public void updateGridMap() {
//		repaint();
//	}

	
	
}
