package clueGame;

import java.awt.Color;
import java.util.ArrayList;

public abstract class _Player {
	
	// instance variables
	public String name;
	public Color color;
	// then a variable to hold a list of cards.
	ArrayList<_Card> cards;
	
	public _Player(){
		super();
		this.color = Color.black;
		this.name = "Captain Cadaver";
		this.cards = new ArrayList<_Card>();
	}
	
	public _Player(String name, Color color, ArrayList<_Card> cards) {
		super();
		this.name = name;
		this.color = color;
		this.cards = cards;
	}
	
	// Helpers for test purposes
	public void giveCard(_Card card){
		//Add card to players card array
	}
	public boolean hasCard(_Card card){
		//return true if the card is in the players card array
		return false;	
	}
}
