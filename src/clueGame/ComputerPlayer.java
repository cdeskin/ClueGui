package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Random;

public class ComputerPlayer extends Player {
	//graphics
	static final int GRID_COLUMNS = Board.GRID_COLUMNS;
	private int gridY;
	private int gridX;
	Color cColor;
	
	
	public ComputerPlayer() {
		super("Captain Cadaver", "black", 0);
		
	}
	
	public ComputerPlayer(String name, String color, int startingIndexedLocation) {
		super(name, color, startingIndexedLocation);
//graphics
		// need to convert index to row/column
		int row =  startingIndexedLocation / GRID_COLUMNS;
		int column = startingIndexedLocation - (GRID_COLUMNS * row);
		this.gridY = row*SCALER;  
		this.gridX = column*SCALER;
		cColor = convertColor(color);
	}
	
	@Override
	public boolean isComputer() { return true; }

	public BoardCell lastRoom;

	public BoardCell pickLocation(HashSet<BoardCell> targets) {
		Random numGenerator = new Random();
		int targetChoice;
		BoardCell[] targetArray;
		// if in range of room, go to room
		// unless been in that room recently
		// otherwise, pick a totally random location out of the list
		
		for (BoardCell target : targets) {
			if (target.isDoorway()) {
				if(!target.equals(lastRoom))
					return target;				
			}
		}
		
		targets.remove(lastRoom);
		
		targetChoice = numGenerator.nextInt(targets.size());
		targetArray = targets.toArray(new BoardCell[targets.size()]);
		
		return targetArray[targetChoice];
	}
	
	//graphics
	public void draw(Graphics g) {
		//System.out.println("GridX: " + gridX + ", GridY: "+ gridY);
		if(cColor == Color.YELLOW) {cColor = new Color(204,199,41);}
		g.setColor(cColor);
		g.fillOval(gridX, gridY, SCALER, SCALER);
		g.setColor(Color.BLACK);
		g.drawOval(gridX, gridY, SCALER, SCALER);
	}


}
