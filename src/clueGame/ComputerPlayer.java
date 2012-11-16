package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Random;

import javax.swing.JFrame;

public class ComputerPlayer extends Player {
	//graphics
	static final int GRID_COLUMNS = Board.GRID_COLUMNS;
	private int gridY;
	private int gridX;
	Color cColor;
	private String personSuggestion, roomSuggestion, weaponSuggestion;
	public boolean lastWasRoom = false;
	private SuggestionDialog suggestionDialog;
	
	
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
					//suggestionDialog = new SuggestionDialog(target.getRoomName());
					//suggestionDialog.setVisible(true);
					//suggestionDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					//personSuggestion = (String) suggestionDialog.personCombo.getSelectedItem();
					//weaponSuggestion = (String) suggestionDialog.weaponCombo.getSelectedItem();
					lastWasRoom = true;
					return target;				
			}
		}
		
		targets.remove(lastRoom);
		lastWasRoom = false;
		
		targetChoice = numGenerator.nextInt(targets.size());
		targetArray = targets.toArray(new BoardCell[targets.size()]);
		
		return targetArray[targetChoice];
	}
	
	public String getPersonSuggestion() {
		return personSuggestion;
	}

	public String getRoomSuggestion() {
		return roomSuggestion;
	}

	public String getWeaponSuggestion() {
		return weaponSuggestion;
	}

	// location of player
    public void setLocation( int indexedLocation) {
         this.indexedLocation = indexedLocation;
        int row = indexedLocation / GRID_COLUMNS;
        int column = indexedLocation - (GRID_COLUMNS * row);
        this.gridY = row*SCALER;  
        this.gridX = column*SCALER;
        
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
