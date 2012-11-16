package clueGame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class GameControlPanel extends JPanel {
	private JButton nextButton, accButton;
//	private int dieRoll;
	public String playerTurn;
	public int playerNumber;
	public String playerGuess;
	public String playerResult;
	public boolean nextPushed;
	public boolean accPushed;
	public Die die;
	public Guess guess;
	public GuessResult guessResult;
	public WhoseTurn whoseTurn;
	


	public GameControlPanel() {
		//super();
		this.nextPushed = false;
		this.accPushed = false;
		this.playerNumber = 0;  //start with Miss. Scarlet
		
		this.setLayout(new GridLayout(2,4));
		setBorder(BorderFactory.createTitledBorder("Game Control Panel"));
		addElements();
	}
	
	

	public void addElements() {
		whoseTurn = new WhoseTurn();
		//GameButtons gameButtons = new GameButtons();
		nextButton = new JButton("Next Player");
		accButton = new JButton("Make an accusation");

		die = new Die(0);  //8 is a test value
		
		guess = new Guess();
		guessResult = new GuessResult();
		add(whoseTurn);
		//add(gameButtons);
		add(nextButton);
		add(accButton);
		add(die);
		add(guess);
		add(guessResult);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				//System.out.println("NextButton pushed - send a control signal, " + nextPushed);
				// how do we get this info to board?
				nextPushed = true;
				
			}
		});

		accButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				accPushed = true;
			}
		});		
	}

	@Override
	public Dimension getPreferredSize() {  // sets the size the PlayerDisplay
		return new Dimension(0, 150); // kill the magic numbers!
	}
	

	
	public boolean getNextButton() {
		if(nextPushed) {
			nextPushed = false;
			//System.out.println("At getNextButton");
			return true;
		}
		return false;
	}
	
	public boolean getAccButton() {
		if(accPushed) {
			accPushed = false;
			return true;
		}
		return false;
	}
	
	public void setDieRoll(int dieRoll) {
		die.setRoll(dieRoll);
		
	}
	
	public void setGuessText(String guessText) {
		guess.setGuessText(guessText);
		
	}
	
	public void setGuessResult(String guessResultText) {
		guessResult.setGuessResult(guessResultText);
		
	}
	
	public void setTurn(String theName) {
		whoseTurn.setTurn(theName);
		
	}
	
	public void setPlayerNumber(int increment) {
		this.playerNumber = playerNumber + increment;
		if(this.playerNumber == 6) { this.playerNumber = 0; }  // Miss Scarlet not skipped
		if(this.playerNumber == 7) { this.playerNumber = 1; }  // Miss Scarlet skipped
	}
	
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	
// classes
	public class WhoseTurn extends JPanel {
		public JTextField whoName;
		public WhoseTurn() {
			setLayout(new GridLayout(1,0));
			// no border
			JLabel whoLabel = new JLabel("Whose Turn?");
			whoName = new JTextField(" ", 10);
			whoName.setText("Press Next to Start");

			add(whoLabel);
			add(whoName);

		}
		public void setTurn(String name) {
			this.whoName.setText(name);
		}
	}

	
	public class Die extends JPanel {
		public JTextField numRoll;
	
		public Die(int dieRoll) {
			setLayout(new GridLayout(0,2));
			setBorder(BorderFactory.createTitledBorder("Die"));
			JLabel roll = new JLabel("Roll");
			numRoll = new JTextField();
			numRoll.setText(Integer.toString(dieRoll));
			
			add(roll);
			add(numRoll);
		}
		public void setRoll(int roll) {
			this.numRoll.setText(Integer.toString(roll));
		}
	}
	
	public class Guess extends JPanel {
		public JTextField guessText;
		public Guess() {
			setLayout(new GridLayout(2,0));
			setBorder(BorderFactory.createTitledBorder("Guess"));
			JLabel guessLabel = new JLabel("Guess");
			guessText = new JTextField(" ", 30);
			
			add(guessLabel);
			add(guessText);
		}
		public void setGuessText(String guess) {
			this.guessText.setText(guess);
		}
	}
	
	public class GuessResult extends JPanel {
		public JTextField guessResultText;
		public GuessResult() {
			setLayout(new GridLayout(2,0));
			setBorder(BorderFactory.createTitledBorder("Guess Result"));
			JLabel guessResultLabel = new JLabel("Guess");
			guessResultText = new JTextField(" ", 30);
			
			add(guessResultLabel);
			add(guessResultText);
		}
		public void setGuessResult(String guessResult) {
			this.guessResultText.setText(guessResult);
		}
	}
	
	
}


