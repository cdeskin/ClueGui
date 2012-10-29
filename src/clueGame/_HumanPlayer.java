package clueGame;

public class _HumanPlayer extends _Player {

	public _HumanPlayer(String name, String color, int startingIndexedLocation) {
		super(name, color, startingIndexedLocation);
	}
	
	@Override
	public boolean isHuman() { return true; }
	
}