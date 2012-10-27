package clueGame;

public class _Card {
	
	// enum type for Card, null is used for disproveSuggestion
	public enum CardType { PERSON, WEAPON, ROOM, NULL };
	
	// instance variables
	public String cardName;
	public CardType cardType;
	
	// constructors
	public _Card() {
		
	}
	
	public _Card(String name, CardType someCardType) {
		cardName = name;
		cardType = someCardType;
	}

}
