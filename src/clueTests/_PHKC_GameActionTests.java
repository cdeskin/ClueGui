package clueTests;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BoardCell;
import clueGame._Board;
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
		
	}
	
//	test for making a suggestion
	@Test
	public void testMakeSuggestion() {
		
	}

}
