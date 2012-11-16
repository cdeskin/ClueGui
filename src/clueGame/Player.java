package clueGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;

public abstract class Player {
	
//	instance variables
	public String name;
	public Color color;
	public ArrayList<Card> cards;
	public int indexedLocation;
//graphics
	static final int SCALER = Board.SCALER;
	//static final int GRID_COLUMNS = Board.GRID_COLUMNS;
	
	public Player(String name, String color, int startingIndexedLocation) {
		this.name = name;
		this.color = convertColor(color);
		indexedLocation = startingIndexedLocation;
		cards = new ArrayList<Card>();
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
	public BoardCell pickLocation(HashSet<BoardCell> targets) {return new BoardCell();}
	
//	disprove suggestion
	public Card disproveSuggestion(String cardName) {
		for (Card someCard : cards) {
			if (someCard.name.equalsIgnoreCase(cardName)) {
				return someCard;
			}
		}
		return new Card();
	}
	
	// Helpers for test purposes
	public void giveCard(Card card){
		//Add card to players card array
		if(!cards.contains(card))
			cards.add(card);
	}
	public boolean hasCard(Card card){
		if(cards.contains(card))
			return true;
		else
			return false;	
	}
	
	// location of player
	public void setLocation( int indexedLocation) {
		this.indexedLocation = indexedLocation;
	}
	
	public int getLocation () {
		return indexedLocation;
	}
	
	//graphics
	public ArrayList<Card> getPlayerCards() {
		return cards;
	}
	

	
//graphics - passed to HumanPlayer and ComputerPlayer
	public void draw(Graphics g) {
	}



}
