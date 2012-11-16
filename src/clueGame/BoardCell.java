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
	static final int SCALER = Board.SCALER;
	private int gridY;
	private int gridX;

	
	public BoardCell() {
		
		this.repaint();
	}
	
	public BoardCell(int row, int col) {
		super();
		this.row = row;
		this.column = col;
		this.gridY = row*SCALER;
		this.gridX = column*SCALER;

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
	
	public void draw(Graphics g) {

	}
	
	public void drawTargets(Graphics g) {
		
	}
	

	
	
}
