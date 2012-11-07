package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class RoomCell extends BoardCell {
	//graphics
	static final int SCALER = Board.SCALER;
	private int gridY;
	private int gridX;


	public enum DoorDirection { UP, DOWN, LEFT, RIGHT, NONE }
	
	DoorDirection doorDirection;
	char initial;
	
	public RoomCell(int row, int column, String token) {
		this.row = row;
		this.column = column;
		this.initial = token.charAt(0);
		this.doorDirection = findDoorDirection(token);
		//graphics
		this.gridY = row*SCALER;
		this.gridX = column*SCALER;
	}
	
	public DoorDirection findDoorDirection(String direction) {
		if (direction.length() == 1) {
			return DoorDirection.NONE;
		} 
		else {
			switch (direction.charAt(1)){
				case 'U':
					return DoorDirection.UP;
				case 'D':
					return DoorDirection.DOWN;
				case 'L':
					return DoorDirection.LEFT;
				case 'R':
					return DoorDirection.RIGHT;
				default :
					return DoorDirection.NONE;
			}
		}
	}
	
	public boolean isRoom() { return true; }

	// for graphics
	public DoorDirection getDoorDirection() { return doorDirection; }

	public char getInitial() { return initial; }
	
	public boolean isDoorway() {
		if(this.doorDirection != DoorDirection.NONE){
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {  //, int gridX, int gridY, DoorDirection doorDirection
		g.setColor(Color.BLUE);
		
		if(doorDirection == DoorDirection.RIGHT) {   
			g.fillRect(gridX +(SCALER-5), gridY, 5, SCALER); // right
			}
		if(doorDirection == DoorDirection.LEFT) {  
			g.fillRect(gridX, gridY, 5, SCALER);  // left
			}
		if(doorDirection == DoorDirection.UP) {    
			g.fillRect(gridX, gridY, SCALER, 5);  // up correct
			}
		if(doorDirection == DoorDirection.DOWN) {    
			g.fillRect(gridX, gridY +(SCALER-5), SCALER, 5); //down
			}
		// next if() just checks grid alignment, disable for pretty-print
		if(this.doorDirection != DoorDirection.NONE) {
			g.setColor(Color.BLACK);
			g.drawRect(gridX, gridY, SCALER, SCALER);

		}


	}

	
}
