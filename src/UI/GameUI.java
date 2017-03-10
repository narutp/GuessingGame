package UI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Game.GuessingGame;

/**
 * A graphic user interface of game.
 * @author Narut Poovorakit
 * @version 10.03.2017
 *
 */
public class GameUI extends JFrame {
	
	/** Components attribute */
	private JFrame frame;
	private JTextField inputField;
	private JPanel panel;
	private JTextArea textArea;
	private JLabel countLabel;
	
	/** Game reference */
	private GuessingGame game;
	
	/** Count how much time user guess */
	private int count = 0;
	
	/**
	 * Create graphic user interface 
	 * @param game is a game algorithm.
	 */
	public GameUI(GuessingGame game) {
		super("Guess A Number");
		this.game = game;
		frame = this;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}
	
	/**
	 * Create all the components and set the window frame.
	 */
	private void initComponents() {
		panel = new JPanel();
		inputField = new JTextField(12);
		JLabel guessLabel = new JLabel("Enter your guess");
		JButton enterButton = new JButton("Enter");
		JButton quitButton = new JButton("Give up");
		textArea = new JTextArea("Hint");
		countLabel = new JLabel("You used 0 guess");
		
		//Edit Components
		
		//Listener
		EnterButtonListener enterListener = new EnterButtonListener();
		QuitButtonListener quitListener = new QuitButtonListener();
		
		enterButton.addActionListener(enterListener);
		quitButton.addActionListener(quitListener);
		
		//panel
		panel.setLayout(new FlowLayout());
		panel.add(guessLabel);
		panel.add(inputField);
		panel.add(enterButton);
		panel.add(quitButton);
		
		//frame
		frame.add(textArea, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(countLabel, BorderLayout.SOUTH);
		frame.pack();
	}
	
	/**
	 * When user click the enter button and run the algorithm.
	 *
	 */
	class EnterButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int input = Integer.parseInt(inputField.getText());
			game.guess(input);
			count++;
			if (input < 1 || input > game.getUpperBound()) {
				textArea.setText("Your guess is out of bound, What is your guess?");
			}
			textArea.setText(game.getHint());
			countLabel.setText("You used " + count + " guesses");
		}
	}
	
	/**
	 * When user click the give up button and run the quit algorithm.
	 *
	 */
	class QuitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			count = 0;
			textArea.setText("Hint");
			countLabel.setText("You used 0 guess");
		}
	}
	
	/**
	 * Set the frame to visible to user to see.
	 */
	public void run() {
		frame.setVisible(true);
	}
}
