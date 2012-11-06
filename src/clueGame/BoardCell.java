package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import clueGame.RoomCell.DoorDirection;

public class BoardCell extends JPanel{
	public int row;
	public int column;
// graphics	
	DoorDirection doorDirection;
//	private int gridY;
//	private int gridX;
//	private int pixelsPerRow = 660/22;   //magic numbers!
//	private int pixelsPerCol = 660/23;
	
	public BoardCell() {
		
		this.repaint();
	}
	
	public BoardCell(int row, int col) {
		this.row = row;
		this.column = col;
//		this.gridY = row*pixelsPerRow;  
//		this.gridX = column*pixelsPerCol;
//		repaint();
	}
	
	public boolean isWalkway() {
		if(!(this.isRoom())){
			return true;
		}
		return false;
	}
	
	public boolean isRoom() { return false; }
	
	public boolean isDoorway() {
		if (this.isRoom()) {
			return true;
		}
		return false;
	}
	
	public DoorDirection getDoorDirection() { return doorDirection; }
	

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
//	public void updateGridMap() {
//		repaint();
//	}
//	
	
	
}
