package clueGame;

public class _Card {
	
	// enum type for Card
	public enum CardType { PERSON, WEAPON, ROOM };
	
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
