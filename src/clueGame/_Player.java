package clueGame;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class _Player {
	
//	instance variables
	public String name;
	public Color color;
	public ArrayList<_Card> cards;
	public int indexedLocation;
	
	public _Player(String name, String color, int startingIndexedLocation) {
		this.name = name;
		this.color = convertColor(color);
		indexedLocation = startingIndexedLocation;
		cards = new ArrayList<_Card>();
	}
	public Color convertColor(String strColor) {
		Color color;
		try {
			Field field = Class.forName("java.awt.Color").getField(strColor.trim());
			color = (Color) field.get(null);
		}
		catch (Exception e) {
			color = null;
		}
		return color;
	}
	
	public boolean isHuman() { return false; }
	public boolean isComputer() { return false; }
	
//	disprove suggestion
	public _Card disproveSuggestion(String cardName) {
		for (_Card someCard : cards) {
			if (someCard.name.equalsIgnoreCase(cardName)) {
				return someCard;
			}
		}
		return new _Card();
	}
	
	// Helpers for test purposes
	public void giveCard(_Card card){
		//Add card to players card array
		if(!cards.contains(card))
			cards.add(card);
	}
	public boolean hasCard(_Card card){
		if(cards.contains(card))
			return true;
		else
			return false;	
	}

}
