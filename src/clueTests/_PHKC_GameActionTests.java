package clueTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BoardCell;
import clueGame._Board;
import clueGame._Card;
import clueGame._Card.CardType;
import clueGame._ComputerPlayer;
import clueGame._Player;

public class _PHKC_GameActionTests {

	private static _Board board;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { board = new _Board(); }
		
//	test for checking an accusation
	@Test
	public void testCheckAccusation() {
		ArrayList<_Card> solutionSet = board.solution;
		// test if accusation is correct
		assertTrue(board.checkAccusation(solutionSet.get(0), solutionSet.get(1), solutionSet.get(2)));
		// test if accusation is wrong
		// wrong person
		assertFalse(board.checkAccusation(new _Card(), solutionSet.get(1), solutionSet.get(2)));
		// wrong room
		assertFalse(board.checkAccusation(solutionSet.get(0), new _Card(), solutionSet.get(2)));
		// wrong weapon
		assertFalse(board.checkAccusation(solutionSet.get(0), solutionSet.get(1), new _Card()));
		// all wrong
		assertFalse(board.checkAccusation(new _Card(), new _Card(), new _Card()));
	}
	
//	test for selecting a targetLocation, for computers
	@Test
	public void testSelectLocationComputer() {
		_ComputerPlayer player = new _ComputerPlayer();
		BoardCell selected;
		
		// tests that don't include a room
		board.calcTargets(board.calcIndex(14, 0), 2);
		int loc_12_0_Tot = 0;
		int loc_14_2_Tot = 0;
		int loc_15_1_Tot = 0;
		for (int i = 0; i < 100; ++i) {
			selected = player.pickLocation(board.getTargets());
			if (selected == board.getCellAt(board.calcIndex(12, 0))) ++loc_12_0_Tot;
			else if (selected == board.getCellAt(board.calcIndex(14, 2))) ++loc_14_2_Tot;
			else if (selected == board.getCellAt(board.calcIndex(15, 1))) ++loc_15_1_Tot;
		}
		assertEquals(100, loc_12_0_Tot + loc_14_2_Tot + loc_15_1_Tot);
		assertTrue(loc_12_0_Tot > 10);
		assertTrue(loc_14_2_Tot > 10);
		assertTrue(loc_15_1_Tot > 10);
		
		// tests that include a room
		board.calcTargets(board.calcIndex(14, 4), 1);
		int loc_13_4_Tot = 0;
		int loc_15_4_Tot = 0;
		int loc_14_3_Tot = 0;
		int loc_14_5_Tot = 0;
		for (int i = 0; i < 100; ++i) {
			selected = player.pickLocation(board.getTargets());
			if (selected == board.getCellAt(board.calcIndex(13, 4))) ++loc_13_4_Tot;
			else if (selected == board.getCellAt(board.calcIndex(15, 4))) ++loc_15_4_Tot;
			else if (selected == board.getCellAt(board.calcIndex(14, 3))) ++loc_14_3_Tot;
			else if (selected == board.getCellAt(board.calcIndex(14, 5))) ++loc_14_5_Tot;
		}
		assertEquals(100, loc_13_4_Tot);
		assertEquals(0, loc_15_4_Tot);
		assertEquals(0, loc_14_3_Tot);
		assertEquals(0, loc_14_5_Tot);
		
		// tests that include a room
		// but sets the last room visted;
		board.calcTargets(board.calcIndex(14, 4), 1);
		player.lastRoom = board.getCellAt(board.calcIndex(13, 4));
		loc_13_4_Tot = 0;
		loc_15_4_Tot = 0;
		loc_14_3_Tot = 0;
		loc_14_5_Tot = 0;
		for (int i = 0; i < 100; ++i) {
			selected = player.pickLocation(board.getTargets());
			if (selected == board.getCellAt(board.calcIndex(13, 4))) ++loc_13_4_Tot;
			else if (selected == board.getCellAt(board.calcIndex(15, 4))) ++loc_15_4_Tot;
			else if (selected == board.getCellAt(board.calcIndex(14, 3))) ++loc_14_3_Tot;
			else if (selected == board.getCellAt(board.calcIndex(14, 5))) ++loc_14_5_Tot;
		}
		assertEquals(0, loc_13_4_Tot);
		assertTrue(loc_15_4_Tot > 10);
		assertTrue(loc_14_3_Tot > 10);
		assertTrue(loc_14_5_Tot > 10);
	}
	
//	test for disproving suggestion
	@Test
	public void testDisproveSuggestion() {
		// rather than creating new cards
		// just use load file and creatively test, taking advantage of random nature!
		// this method --> boss status bro
		
		ArrayList<_Card> cardsHeldByComputers = new ArrayList<_Card>();
		for (_Player somePlayer : board.allPlayers) { cardsHeldByComputers.addAll(somePlayer.cards); }
		cardsHeldByComputers.removeAll(board.allPlayers.get(0).cards);
		
		Random hazard = new Random();
		_Card someCard; 
		_Card personCard;
		_Card roomCard; 
		_Card weaponCard;
		
		// all players, one correct match
		// via person
		while (true) {
			someCard = cardsHeldByComputers.get(hazard.nextInt(cardsHeldByComputers.size()));
			if (someCard.type == CardType.PERSON) {
				personCard = someCard;
				break;
			}
		}
		someCard = board.disproveSuggestion(0, personCard.name, board.solution.get(1).name, board.solution.get(2).name);
		assertTrue(someCard.name.equalsIgnoreCase(personCard.name));
		// via room
		while (true) {
			someCard = cardsHeldByComputers.get(hazard.nextInt(cardsHeldByComputers.size()));
			if (someCard.type == CardType.ROOM){
				roomCard = someCard;
				break;
			}
		}
		someCard = board.disproveSuggestion(0, board.solution.get(0).name, roomCard.name, board.solution.get(2).name);
		assertTrue(someCard.name.equalsIgnoreCase(roomCard.name));
		// via weapon
		while (true) {
			someCard = cardsHeldByComputers.get(hazard.nextInt(cardsHeldByComputers.size()));
			if (someCard.type == CardType.WEAPON){
				weaponCard = someCard;
				break;
			}
		}
		someCard = board.disproveSuggestion(0, board.solution.get(0).name, board.solution.get(1).name, weaponCard.name);
		assertTrue(someCard.name.equalsIgnoreCase(weaponCard.name));
		// via NULL (meaning no one could disprove the suggestion)
		someCard = board.disproveSuggestion(0, board.solution.get(0).name, board.solution.get(1).name, board.solution.get(2).name);
		assertTrue(someCard.type == CardType.NULL);
		
		// all players, multiple matches
		// make sure that different cards are given each time.
		int personCardReturned = 0;
		int roomCardReturned = 0;
		int weaponCardReturned = 0;
		for (int i = 0; i < 100; ++i) {
			someCard = board.disproveSuggestion(0, personCard.name, roomCard.name, weaponCard.name);
			if (someCard.name.equalsIgnoreCase(personCard.name)) ++personCardReturned;
			else if (someCard.name.equalsIgnoreCase(roomCard.name)) ++roomCardReturned;
			else if (someCard.name.equalsIgnoreCase(weaponCard.name)) ++weaponCardReturned;
		}
		assertEquals(100, personCardReturned + roomCardReturned + weaponCardReturned);
		assertTrue(personCardReturned > 10);
		assertTrue(roomCardReturned > 10);
		assertTrue(weaponCardReturned > 10);
		
		// all players, no matches (repeat of via NULL test, just many iterations)
		// this ensures that all players are queried
		int nullCardReturned = 0;
		for (int i = 0; i < 100; ++i) {
			someCard = board.disproveSuggestion(0, board.solution.get(0).name, board.solution.get(1).name, board.solution.get(2).name);
			if (someCard.type == CardType.NULL) ++nullCardReturned; 
		}
		assertEquals(100, nullCardReturned);
	}
	
//	test for making a suggestion
	/*
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
	    
	}*/

}
