package clueGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import clueGame._Card.CardType;

public class _Board {
	
////////////////////////////////
//  configuration files
//
	
//	private static final String boardConfigFile = "config/others/ST_ClueBoardConfig.csv";
//	private static final String boardLegendFile = "config/others/ST_ClueLegend.txt";
//	private static final String boardConfigFile = "config/others/CR_ClueLayout.csv";
//	private static final String boardLegendFile = "config/others/CR_ClueLegend.txt";
	private static final String boardConfigFile = "config/PHKC_ClueLayout.csv";
	private static final String boardLegendFile = "config/PHKC_ClueLegend.txt";
//	CluePlayers
	private static final String boardPlayersFile = "config/PHKC_CluePlayers.txt";
	private static final String boardCardsFile = "config/PHKC_ClueCards.txt";
	
//
////////////////////////////////
	
////////////////////////////////
//  declaration of variables
//
	
	ArrayList<BoardCell> cells = new ArrayList<BoardCell>();
	Map<Character,String> rooms = new HashMap<Character,String>();	
	
	private Map<Integer, LinkedList<Integer>>adjList = new HashMap<Integer, LinkedList<Integer>>();
	private HashSet<BoardCell> targets;
	
	int numRows;
	int numColumns;
	int index;
	
	private boolean[] visited;
	
//
////////////////////////////////
	
////////////////////////////////
//  ClueGameBoard part 1
//  constructor with initial setup shenanigans
//
	
	public _Board() throws FileNotFoundException, BadConfigFormatException{
		loadConfigFiles();
		calcAdjacencies();
	}

	public void loadConfigFiles() throws FileNotFoundException, BadConfigFormatException {
		loadConfigLegend();
		loadConfigBoard();
		loadCluePlayerConfigFiles();
	}
	
	public void loadConfigLegend() {
		try {
			FileReader reader = new FileReader(boardLegendFile);
			Scanner in = new Scanner(reader);
			while (in.hasNext()) {
				String input = in.nextLine();
				String[] tokens = input.split(",");
				if (tokens.length != 2) {
					throw new BadConfigFormatException("Error with legend file.");
				}
				Character key = new Character(tokens[0].charAt((0)));
				rooms.put(key, tokens[1].trim());
			}
		} catch (BadConfigFormatException e) {
			System.out.println(e);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	public void loadConfigBoard() {
		try {
			FileReader reader = new FileReader(boardConfigFile);
			Scanner in = new Scanner(reader);
			while (in.hasNext()) {
				String input = in.nextLine();
				
				String[] tokens = input.split(",");
				
				if (input.length() < 1) {
					throw new BadConfigFormatException("Error with board config file.");
				}
				
				for (int i = 0; i < tokens.length; i++) {
					if (tokens[i].equalsIgnoreCase("W")) {
						cells.add(new WalkwayCell(numRows, i));
					} else {
						cells.add(new RoomCell(numRows, i, tokens[i]));
					}
				}
				
				numRows++;
			}
			
			numColumns = (cells.size() / numRows);
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (BadConfigFormatException e) {
			System.out.println(e);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void calcAdjacencies() {
		for (int x = 0; x < numRows; x++) {
			for (int y = 0; y < numColumns; y++) {
				LinkedList<Integer> list = new LinkedList<Integer>();
				
				int index = calcIndex(x, y);
				
				if(getCellAt(index).isWalkway()){
					if (x > 0) {
						int attempt = calcIndex(x-1, y);
						if (validMove(index, attempt)){
							list.add(attempt);
						}
					}
					if (y > 0){
						int attempt = calcIndex(x, y-1);
						if (validMove(index, attempt)){
							list.add(attempt);
						}
					}
					if (x != numRows-1) {
						int attempt = calcIndex(x+1, y);
						if (validMove(index, attempt)){
							list.add(attempt);
						}
					}
					if (y != numColumns-1) {
						int attempt = calcIndex(x, y+1);
						if (validMove(index, attempt)){
							list.add(attempt);
						}
					}
				}
				
				else if(getCellAt(index).isRoom()){
					RoomCell r = getRoomCellAt(x, y);
					
					if(r.isDoorway()){
						switch (r.doorDirection){
						case DOWN:
							if(validMove(index, calcIndex(x+1, y))){
								list.add(calcIndex(x+1, y));
							}
							break;
						case UP:
							if(validMove(index,calcIndex(x-1, y))){
								list.add(calcIndex(x-1, y));
							}
							break;
						case LEFT:
							if(validMove(index, calcIndex(x, y-1))){
								list.add(calcIndex(x, y-1));
							}
							break;
						case RIGHT:
							if(validMove(index,calcIndex(x, y+1))){
								list.add(calcIndex(x, y+1));
							}
							break;
						default:
							
						}
					}
				}
						
				adjList.put(index, list);
			}
		}
	}
//	helper method for calcAdjancencies
	public boolean validMove(int current, int attempt){
		if (getCellAt(attempt).isWalkway()){
			return true;
		}
		else if(getCellAt(attempt).isRoom()){
			RoomCell r = getRoomCellAt(attempt);
			
			if(r.isDoorway()){
				switch (r.doorDirection){
				case DOWN:
					if (current == calcIndex(r.row+1, r.column)){
						return true;
					}
					break;
				case UP:
					if (current == calcIndex(r.row-1, r.column)){
						return true;
					}
					break;
				case LEFT:
					if (current == calcIndex(r.row, r.column-1)){
						return true;
					}
					break;
				case RIGHT:
					if (current == calcIndex(r.row, r.column+1)){
						return true;
					}
					break;
				default:
					
				}
			}
		}
	
		return false;
	}
	
//
////////////////////////////////
	
////////////////////////////////
//	ClueGameBoard part i
//	calcIndex instance method and getters
//	
	
//	instance method calcIndex
	public int calcIndex(int row, int column) { return ((numColumns)*row) + column; }
//	get get get your getters
	public RoomCell getRoomCellAt(int row, int column) {
		index = calcIndex(row, column);
		if ((cells.get(index)).isRoom()) {
			return (RoomCell) cells.get(index);
		} 
		
		return null;
	}
	
	public RoomCell getRoomCellAt(int index) {
		if ((cells.get(index)).isRoom()) {
			return (RoomCell) cells.get(index);
		}
		
		return null;
	}

	public BoardCell getCellAt(int index) { return cells.get(index); }

	public Map<Character, String> getRooms() { return rooms; }

	public int getNumRows() { return numRows; }

	public int getNumColumns() { return numColumns; }
	
//	
////////////////////////////////
	
////////////////////////////////
//	ClueGameBoard part ii	
//	calcTargets and getters
//	
	
	public void calcTargets(int index, int steps) {
		visited = new boolean[getNumColumns()*getNumRows()];
		targets = new HashSet<BoardCell>();
		
		LinkedList<Integer> path = new LinkedList<Integer>();
		
		visited[index] = true;
		
		visitTargets(adjList.get(index), path, steps);
	}
//	helper method for calcTargets, recursive
	public void visitTargets(LinkedList<Integer> adjacents, LinkedList<Integer> path, int steps) {
		
		LinkedList<Integer> adjacentsClone = new LinkedList<Integer>();
		adjacentsClone.addAll(adjacents);
		
 		for (Iterator<Integer> itr = adjacentsClone.iterator(); itr.hasNext();) {
			
			int current = itr.next();
			
			if (getCellAt(current).isRoom()) {
				targets.add(getCellAt(current));
			}
			
			else {
			
				path.addLast(current);
				visited[current] = true;
				
				if (path.size() == steps) { targets.add(getCellAt(current)); }
				else {
					LinkedList<Integer>	list = new LinkedList<Integer>();
					list.addAll(adjList.get(current));
					
					for (Iterator<Integer> itr2 = list.iterator(); itr2.hasNext();){
						int node = itr2.next();
						
						if(visited[node]) {
							itr2.remove();
						}
					}
					
					if (list.size() > 0) {
						visitTargets(list, path, steps);
					}
				}
				
				visited[current] = false;
				
				path.removeLast();
				
			}
			
 		}
 		
	}
//	getters
	public HashSet<BoardCell> getTargets() { return targets; }
	
	public LinkedList<Integer> getAdjList(int cell) { return adjList.get(cell); }

//	
////////////////////////////////
	
////////////////////////////////
//	CluePlayers
//	
	
//	variables
	public ArrayList<_Player> allPlayers = new ArrayList<_Player>();
	public _Player getPlayer(int index) { return allPlayers.get(index); }
	
	public ArrayList<_Card> deck = new ArrayList<_Card>();
	public ArrayList<_Card> dealDeck = new ArrayList<_Card>();
	
	HashSet<_Card> cardsSeen = new HashSet<_Card>();
	public ArrayList<_Card> solution = new ArrayList<_Card>();
	
//	variables to hold list of cards, list of computer 
//	players, one human player, and an indicator of whose turn it is
	
//	i say we have one ArrayList of Players, instantiate in order of file
	
////////////////////////////////
//	GameSetup section
//	

	public void loadCluePlayerConfigFiles() throws FileNotFoundException, BadConfigFormatException {
		// create players
		loadCluePlayers();
		// generate cards
		loadClueCards();
		// deal cards
		dealClueCards();
	}
	
	public void loadCluePlayers() throws FileNotFoundException, BadConfigFormatException {
		FileReader reader = new FileReader(boardPlayersFile);
		Scanner in = new Scanner(reader);
		while (in.hasNext()) {
			String input = in.nextLine();
			String[] tokens = input.split(",");
			if (tokens.length != 4) { throw new BadConfigFormatException("Unexpected notation in players file."); }
			
			if (tokens[0].equalsIgnoreCase("human")) { allPlayers.add(new _HumanPlayer(tokens[1], tokens[2], Integer.parseInt(tokens[3]))); }
			else if (tokens[0].equalsIgnoreCase("computer")) { allPlayers.add(new _ComputerPlayer(tokens[1], tokens[2], Integer.parseInt(tokens[3]))); }
			else { throw new BadConfigFormatException("Unexpected notation in players file."); }
		}
	}
	
	public void loadClueCards() throws FileNotFoundException, BadConfigFormatException {
		FileReader reader = new FileReader(boardCardsFile);
		Scanner in = new Scanner(reader);
		while (in.hasNext()) {
			String input = in.nextLine();
			String[] tokens = input.split(",");
			if (tokens.length != 2) { throw new BadConfigFormatException("Unexpected notation in cards file."); }
			
			if (tokens[0].equalsIgnoreCase("person")) { deck.add(new _Card(tokens[1], CardType.PERSON)); }
			else if (tokens[0].equalsIgnoreCase("room")) { deck.add(new _Card(tokens[1], CardType.ROOM)); }
			else if (tokens[0].equalsIgnoreCase("weapon")) { deck.add(new _Card(tokens[1], CardType.WEAPON)); }
			else { throw new BadConfigFormatException("Unexpected notation in cards file."); }
		}
	}
	
	public void dealClueCards() {
		
		Random hazard = new Random();
		int playerIndex = 0;
		_Card someCard;

		dealDeck.addAll(deck);
		
		// create solution set
		while (true) {
			someCard = dealDeck.get(hazard.nextInt(dealDeck.size()));
			if (someCard.type == CardType.PERSON){
				dealDeck.remove(someCard);
				solution.add(someCard);
				break;
			}
		}
		while (true) {
			someCard = dealDeck.get(hazard.nextInt(dealDeck.size()));
			if (someCard.type == CardType.ROOM){
				dealDeck.remove(someCard);
				solution.add(someCard);
				break;
			}
		}
		while (true) {
			someCard = dealDeck.get(hazard.nextInt(dealDeck.size()));
			if (someCard.type == CardType.WEAPON){
				dealDeck.remove(someCard);
				solution.add(someCard);
				break;
			}
		}
		
		// deal out rest of cards
		while (!dealDeck.isEmpty()) {
			someCard = dealDeck.get(hazard.nextInt(dealDeck.size()));
			dealDeck.remove(someCard);
			allPlayers.get(playerIndex).cards.add(someCard);
			
			++playerIndex;
			if (playerIndex == allPlayers.size()) playerIndex = 0;
		}
	}

//	
////////////////////////////////

////////////////////////////////
//	 GameAction section
//	
	
	//Return true if accusation is true, false otherwise
	public boolean checkAccusation(String person, String room, String weapon){
		ArrayList<_Card> accusation = new ArrayList<_Card>();
		accusation.add(new _Card(person, _Card.CardType.PERSON));
		accusation.add(new _Card(room, _Card.CardType.ROOM));
		accusation.add(new _Card(weapon, _Card.CardType.WEAPON));
		
		if(solution.containsAll(accusation))
			return true;
		else
			return false;
	}
	
	//returns a card from a player or null card if no players have any of suggested cards
	public _Card disproveSuggestion(int currentPlayer, String person, String room, String weapon){
		int numPlayers = allPlayers.size();
		Random numGenerator = new Random();
		_Card personCard = new _Card(person, _Card.CardType.PERSON);
		_Card roomCard = new _Card(room, _Card.CardType.ROOM);
		_Card weaponCard = new _Card(weapon, _Card.CardType.WEAPON);
		
		//generate a random starting index that is not the index of the current player
		int startIndex = numGenerator.nextInt(numPlayers);
		while (startIndex == currentPlayer){
			startIndex = numGenerator.nextInt(numPlayers);
		}
		int currentIndex = startIndex;
		
		//there ought to be a better way to do this.
		//way overcomplicated loop structure to wrap at end and skip current player
		if(startIndex < currentPlayer)
		{
			while(currentIndex < currentPlayer){
				boolean[] matches = checkCards(currentIndex, personCard, roomCard, weaponCard);
				
				_Card returnCard = getReturnCard(matches, personCard, roomCard, weaponCard);
				
				if(returnCard.type != _Card.CardType.NULL)
					return returnCard;
				
				currentIndex++;
			}
			currentIndex++;
			while(currentIndex < numPlayers){
				boolean[] matches = checkCards(currentIndex, personCard, roomCard, weaponCard);
				
				_Card returnCard = getReturnCard(matches, personCard, roomCard, weaponCard);
				
				if(returnCard.type != _Card.CardType.NULL)
					return returnCard;
				
				currentIndex++;
			}
			currentIndex=0;
			while(currentIndex < startIndex){
				boolean[] matches = checkCards(currentIndex, personCard, roomCard, weaponCard);
				
				_Card returnCard = getReturnCard(matches, personCard, roomCard, weaponCard);
				
				if(returnCard.type != _Card.CardType.NULL)
					return returnCard;
				
				currentIndex++;
			}
		} 
		
		else if(startIndex > currentPlayer){
			while(currentIndex < numPlayers){
				boolean[] matches = checkCards(currentIndex, personCard, roomCard, weaponCard);
				
				_Card returnCard = getReturnCard(matches, personCard, roomCard, weaponCard);
				
				if(returnCard.type != _Card.CardType.NULL)
					return returnCard;
				
				currentIndex++;
			}
			currentIndex=0;
			while(currentIndex < currentPlayer){
				boolean[] matches = checkCards(currentIndex, personCard, roomCard, weaponCard);
				
				_Card returnCard = getReturnCard(matches, personCard, roomCard, weaponCard);
				
				if(returnCard.type != _Card.CardType.NULL)
					return returnCard;
				
				currentIndex++;
			}
			currentIndex++;
			while(currentIndex < startIndex){
				boolean[] matches = checkCards(currentIndex, personCard, roomCard, weaponCard);
				
				_Card returnCard = getReturnCard(matches, personCard, roomCard, weaponCard);
				
				if(returnCard.type != _Card.CardType.NULL)
					return returnCard;
				
				currentIndex++;
			}
		}
		
		return new _Card("null", _Card.CardType.NULL);
	}
	
	//give a card to player at [index] in the player array
	public void giveCard(int index, _Card card){
		allPlayers.get(index).giveCard(card);
	}
	
	//add items to the array of cards that have been seen. Mostly for testing
	public void updateSeen(String person, String room, String weapon){
		cardsSeen.add(new _Card(person, _Card.CardType.PERSON));
		cardsSeen.add(new _Card(room, _Card.CardType.ROOM));
		cardsSeen.add(new _Card(weapon, _Card.CardType.WEAPON));
	}
	
	//returns 3 cards, person, room, and weapon
	public HashSet<_Card> makeSuggestion(){
		return new HashSet<_Card>();
	}
	
	public boolean[] checkCards(int index, _Card personCard, _Card roomCard, _Card weaponCard){
		boolean[] returnArray = {false, false, false};
		if(allPlayers.get(index).hasCard(personCard))
			returnArray[0]=true;
		if(allPlayers.get(index).hasCard(roomCard))
			returnArray[1]=true;
		if(allPlayers.get(index).hasCard(weaponCard))
			returnArray[2]=true;
		
		return returnArray;
	}
	
	public _Card getReturnCard(boolean[] matches, _Card personCard, _Card roomCard, _Card weaponCard){
		Random numGenerator = new Random();
		int numMatches = 0;
		
		for(boolean check: matches){
			if(check)
				numMatches++;
		}
		
		if(numMatches > 1){
			int returnChoice = numGenerator.nextInt(numMatches);
			
			if(returnChoice == 0)
				return personCard;
			else if(returnChoice == 1)
				return roomCard;
			else if(returnChoice == 2)
				return weaponCard;
		} else if (numMatches > 0){
			if(matches[0])
				return personCard;
			else if(matches[1])
				return roomCard;
			else if(matches[2])
				return weaponCard;
		}
		
		return new _Card("null", _Card.CardType.NULL);
	}
	
//	
////////////////////////////////
	
////////////////////////////////
//	main method, for debugging purposes
//	
	
	public static void main(String[] args) throws FileNotFoundException, BadConfigFormatException {
		System.out.println("Hello world!!\n");
		
		@SuppressWarnings("unused")
		_Board board = new _Board();
		
//		System.out.println("Starting positions for players (given by index): ");
//		System.out.println("Miss Scarlet: " + board.calcIndex(13, 22));
//		System.out.println("Mr. Green: " + board.calcIndex(21, 6));
//		System.out.println("Mrs. Peacock: " + board.calcIndex(0, 4));
//		System.out.println("Colonel Mustard: " + board.calcIndex(21, 15));
//		System.out.println("Mrs. White: " + board.calcIndex(13, 0));
//		System.out.println("Professor Plum: " + board.calcIndex(0, 19));
	
		System.out.println("\nGoodbye world..");
	}
	
//	
////////////////////////////////
//		  END OF FILE		  //	
////////////////////////////////
	
}
