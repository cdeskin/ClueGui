package clueGame;

import java.util.HashSet;
import java.util.Random;

public class _ComputerPlayer extends _Player {
	
	public _ComputerPlayer() {
		super("Captain Cadaver", "black", 0);
	}
	
	public _ComputerPlayer(String name, String color, int startingIndexedLocation) {
		super(name, color, startingIndexedLocation);
	}
	
	@Override
	public boolean isComputer() { return true; }

	public BoardCell lastRoom = new BoardCell();

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
	
}
