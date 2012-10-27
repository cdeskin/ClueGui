package clueTests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BoardCell;
import clueGame._Board;
import clueGame._Card;
import clueGame._ComputerPlayer;

public class _PHKC_GameActionTests {

	private static _Board board;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { board = new _Board(); }
	
//	this file will change drastically once config files/code being written
	
//	test for checking an accusation
	@Test
	public void testCheckAccusation() {
		_Solution solution = new _Solution(/*3 cards*/);
		Boolean check = board.checkAccusation("person", "room", "weapon");
		assertTrue(check);
	}
	
//	test for selecting a targetLocation, for computers
	@Test
	public void testSelectLocationComputer() {
		// taken from assignment write up, subject to change
		_ComputerPlayer player = new _ComputerPlayer();
		board.calcTargets(board.calcIndex(14, 0), 2);
		int loc_12_0_Tot = 0;
		int loc_14_2_Tot = 0;
		int loc_15_1_Tot = 0;
		for (int i = 0; i < 100; ++i) {
			BoardCell selected = player.pickLocation(board.getTargets());
			if (selected == board.getCellAt(board.calcIndex(12, 0))) ++loc_12_0_Tot;
			else if (selected == board.getCellAt(board.calcIndex(14, 2))) ++loc_14_2_Tot;
			else if (selected == board.getCellAt(board.calcIndex(15, 1))) ++loc_15_1_Tot;
		}
		assertEquals(100, loc_12_0_Tot + loc_14_2_Tot + loc_15_1_Tot);
		assertTrue(loc_12_0_Tot > 10);
		assertTrue(loc_14_2_Tot > 10);
		assertTrue(loc_15_1_Tot > 10);
	}
	
//	test for disproving a suggestion
	@Test
	public void testDisproveSuggestion() {
		//Reset any changes made by other tests
		board = new _Board();
		//Make a suggestion on a new board, no players should have any of the cards so should return a null card
		assertEquals(board.disproveSuggestion("person", "room", "weapon"), _Card.CardType.NULL);
		
		//deal some cards, multiple can be dealt and tested
		board.giveCard(0, new _Card("person", _Card.CardType.PERSON)); 
		
		//make a sugguestion that includes 1 card that has been dealt, 
		//make sure the card we want is returned
		//repeat for room, and weapon
		assertEquals(board.disproveSuggestion("person", "room", "weapon"), new _Card("person", _Card.CardType.PERSON));
		
		//idea: call disproveSuggestion 25 times with all args being cards held by a player 
		//      then make sure we were returned, at least once, a room, a person, and a weapon
		//      and they are the right ones
		HashSet<_Card> returnedCards = new HashSet<_Card>();
		board.giveCard(1, new _Card("room", _Card.CardType.ROOM));
		for(int i = 0; i<25; i++){
			returnedCards.add(board.disproveSuggestion("person", "room", "weapon"));
		}
		//we should get a person, a room, and a weapon
		assertTrue(returnedCards.size() == 3);
		assertTrue(returnedCards.contains(new _Card("person", _Card.CardType.PERSON)));
		assertTrue(returnedCards.contains(new _Card("room", _Card.CardType.ROOM)));
		assertTrue(returnedCards.contains(new _Card("weapon", _Card.CardType.WEAPON)));
		
		//idea: call disprove suggestion with a room held by one player and weapon held
		//      by another player, the first match found will be returned so if random
		//      starting point is working, we should eventually get both cards returned
		//      (Suggested room should not be held by any players)
		returnedCards = new HashSet<_Card>();
		//deal a card to a second player
		board.giveCard(0, new _Card("person", _Card.CardType.PERSON));
		for(int i = 0; i<25; i++){
			returnedCards.add(board.disproveSuggestion("person", "room", "weapon"));
		}
		assertTrue(returnedCards.size() == 2);
		assertTrue(returnedCards.contains(new _Card("person", _Card.CardType.PERSON)));
		assertTrue(returnedCards.contains(new _Card("weapon", _Card.CardType.WEAPON)));
	}
	
//	test for making a suggestion
	@Test
	public void testMakeSuggestion() {
		//add one or more things to seen array
		board.updateSeen("person", "room", "weapon");
		//call make suggestion a bunch of times and make sure we don't get one of the cards in the seen array
		for(int i=0; i<25;i++){
			HashSet<_Card> suggested = board.makeSuggestion();
			//make sure it didn't suggest more or less than 3 cards
			assertTrue(suggested.size() == 3);
			//make sure the cards added to seen array are not suggested (add more as needed)
			assertFalse(suggested.contains(new _Card("person", _Card.CardType.PERSON)));
		}
	    
	}

}
