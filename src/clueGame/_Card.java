package clueGame;

public class _Card {
	
	// enum type for Card, null is used for disproveSuggestion
	public enum CardType { PERSON, WEAPON, ROOM, NULL };
	
	// instance variables
	public String name;
	public CardType type;
	
	// constructor
	public _Card(String name, CardType someCardType) {
		this.name = name;
		this.type = someCardType;
	}

}
