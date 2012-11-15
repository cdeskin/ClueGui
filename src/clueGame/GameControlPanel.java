package clueGame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class GameControlPanel extends JPanel {
	private JButton nextButton, accButton;
	private int dieRoll;
	public String playerTurn;
	public String playerGuess;
	public String playerResult;
	public boolean nextPushed;
	public boolean accPushed;
	public Die die;
	


	public GameControlPanel() {
		//super();
		this.nextPushed = false;
		this.accPushed = false;
		
		this.setLayout(new GridLayout(2,4));
		setBorder(BorderFactory.createTitledBorder("Game Control Panel"));
		addElements();
	}
	
	

	public void addElements() {
		WhoseTurn whoseTurn = new WhoseTurn();
		//GameButtons gameButtons = new GameButtons();
		nextButton = new JButton("Next Player");
		accButton = new JButton("Make an accusation");
		

		die = new Die(8);
		
		Guess guess = new Guess();
		GuessResult guessResult = new GuessResult();
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
	
	
// classes
	public class WhoseTurn extends JPanel {
		public WhoseTurn() {
			setLayout(new GridLayout(1,0));
			// no border
			JLabel whoLabel = new JLabel("Whose Turn?");
			JTextField whoName = new JTextField(" ", 10);
			whoName.setText("A Player");

			add(whoLabel);
			add(whoName);

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
		public Guess() {
			setLayout(new GridLayout(2,0));
			setBorder(BorderFactory.createTitledBorder("Guess"));
			JLabel guessLabel = new JLabel("Guess");
			JTextField guessText = new JTextField(" ", 30);
			
			add(guessLabel);
			add(guessText);
		}
	}
	
	public class GuessResult extends JPanel {
		public GuessResult() {
			setLayout(new GridLayout(2,0));
			setBorder(BorderFactory.createTitledBorder("Guess Result"));
			JLabel guessResultLabel = new JLabel("Guess");
			JTextField guessResultText = new JTextField(" ", 30);
			
			add(guessResultLabel);
			add(guessResultText);
		}
	}
	
	
}


