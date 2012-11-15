package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class RoomCell extends BoardCell {
	//graphics
	static final int SCALER = Board.SCALER;
	private int gridY;
	private int gridX;
	private boolean nameCell;

	public enum DoorDirection { UP, DOWN, LEFT, RIGHT, NONE }
	
	DoorDirection doorDirection;
	char initial;
// graphics
	String roomName;
	
	public RoomCell(int row, int column, String token, String roomName) {
		super();
		this.row = row;
		this.column = column;
		this.initial = token.charAt(0);
		this.roomName = roomName;  //graphics
		this.nameCell = false;  //for graphics room name display
		
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
				case 'N' :  { // detect a cell with name - for graphics
					this.nameCell = true;
					return DoorDirection.NONE;
				}
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
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(gridX, gridY, SCALER, SCALER);  //draw basic room shape
		
		if(nameCell) {
			g.setColor(Color.BLACK);
			g.drawString(roomName.toUpperCase(), gridX, gridY);
		}
		

		
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
//		if(this.doorDirection != DoorDirection.NONE) {
//			g.setColor(Color.BLACK);
//			g.drawRect(gridX, gridY, SCALER, SCALER);
//		}


	}
	
	public void drawTargets(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(gridX, gridY, SCALER, SCALER);  //draw basic room shape
	}

	
}
