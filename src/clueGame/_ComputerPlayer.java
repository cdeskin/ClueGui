package clueGame;

import java.util.HashSet;

public class _ComputerPlayer extends _Player {
	
	public BoardCell pickLocation(HashSet<BoardCell> targets) {
		// if in range of room, go to room
		// unless been in that room recently
		// otherwise, pick a totally random location out of the list
		
		for (BoardCell target : targets) {
			if (target.isDoorway()) {
//				return target
				
			}
		}
		
		return null;
	}
	
}
