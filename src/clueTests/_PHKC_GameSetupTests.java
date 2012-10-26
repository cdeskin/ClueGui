package clueTests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame._Board;
import clueGame._Player;

public class _PHKC_GameSetupTests {

	private static _Board board;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { board = new _Board(); }

//	this file will change drastically once config files/code being written
	
//	test to confirm loading the player files is correct
	@Test
	public void testLoadingPeople() {
		_Player somePlayer = board.getPlayer(0);
		assertTrue(somePlayer.isHuman());
		assertFalse(somePlayer.isComputer());
		assertTrue(somePlayer.name.equals(""));
		assertTrue(somePlayer.color.equals(Color.red));
		assertTrue(somePlayer.getLocation());
		
		somePlayer = board.getPlayer(1);
		assertTrue(somePlayer.isComputer());
		assertFalse(somePlayer.isHuman());
		assertTrue(somePlayer.name.equals(""));
		assertTrue(somePlayer.color.equals(Color.red));
		assertTrue(somePlayer.getLocation());
		
		somePlayer = board.getPlayer(2);
		assertTrue(somePlayer.isComputer());
		assertFalse(somePlayer.isHuman());
		assertTrue(somePlayer.name.equals(""));
		assertTrue(somePlayer.color.equals(Color.red));
		assertTrue(somePlayer.getLocation());
	}
	
//	test to confirm loading the cards are correct
	@Test
	public void testLoadingCards() {
		assertTrue(board.deck.size() == /*some number*/);
		int cardsOfTypePerson = 0;
		int cardsOfTypeWeapon = 0;
		int cardsOfTypeRoom = 0;
		
		for (Card someCard : board.deck) {
			if (someCard == Card.CardType.PERSON) ++cardOfTypePerson;
			else if (someCard == Card.CardType.WEAPON) ++cardOfTypeWeapon;
			else if (someCard == Card.CardType.ROOM) ++cardOfTypeRoom;
		}
		
		assertTrue(cardOfTypePerson == /*some number*/);
		assertTrue(cardOfTypeWeapon == /*some number*/);
		assertTrue(cardOfTypeRoom == /*some number*/);
		
		Boolean testBool = false;
		// check for one room
		for (Card someCard : board.deck) {
			if (someCard.name == "") {
				testBool = true; break;
			}
		}
		assertTrue(testBool);
		
		testBool = false;
		// check for one weapon
		for (Card someCard : board.deck) {
			if (someCard.name == "") {
				testBool = true; break;
			}
		}
		assertTrue(testBool);
		
		testBool = false;
		// check for one person
		for (Card someCard : board.deck) {
			if (someCard.name == "") {
				testBool = true; break;
			}
		}
		assertTrue(testBool);
	}
	
//	test to confirm dealing the cards work
	@Test
	public void testDealingCards() {
		// ensures all cards are dealt
		assertTrue(board.deck.size() == 0);
		
		// ensures all players have roughly the same amount of cards
		for (_SomePlayer player : board.allPlayers) {
			assertTrue(player.cards.size >= /*some size*/);
		}
		
		// one card is not given to two different players
		// loop through and add all cards to one array, check array
		
	}

}
