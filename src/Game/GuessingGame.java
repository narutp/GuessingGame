package Game;

import java.util.Random;
/**
 * Game of guessing a secret number by try to choose a number from
 * 1 to the upperbound or a max number
 * @author Narut Poovorakit
 *
 */
public class GuessingGame {
	/**
	 * upperBound is a limit number that guessing
	 */
	private int upperBound;
	/**
	 * secret is a number that want user to guess
	 */
	private int secret; 
	/**
	 * hint is a message to tell whether the number is smaller or larger
	 */
	private String hint; 
	/**
	 * count is a number of how many guess that user guess until it correct
	 */
	private int count;
	
	/**
	 * 
	 * Initialize a game
	 * @param upperBound is the max value for the secret number
	 */
	public GuessingGame(int upperBound) { // constructor
		this.upperBound = upperBound;
		this.count = 0;
		this.secret = getRandomNumber(this.upperBound);
		this.hint = "I'm thinking of a number between 1 and " + this.upperBound;
	}
	
	/**
	 * A guess method that check whether the number that
	 * user guess is correct match to the secret number or not
	 * @param number is a number that user guessing
	 * @return a true or false answer including set the hint message
	 */
	public boolean guess(int number) {
		this.count++;
		if(number == this.secret) {
			setHint("Correct. The secret is " + secret);
			return true;
		}
		if(number > secret) {
			setHint("Sorry, your guess is too big");
			return false;
		}
		else {
			setHint("Sorry, your guess is too small");
			return false;
		}
		
	}
	
	/**
	 * Return a hint based on the most recent guess.
	 * @return hint based on most recent guess
	 */
	public String getHint() {
		return this.hint;
	}
	
	/**
	 * Return a limit upper bound number of value of guessing
	 * @return upper bound of a guess number
	 */
	public int getUpperBound() {
		return this.upperBound;
	}
	/**
	 * Set a hint message
	 * @param hint is a message that tell user small or larger
	 */
	protected void setHint(String hint) {
		this.hint = hint;
	}
	
	/**
	 * Create a random number between 1 and limit.
	 * @param limit is the upper limit for random number
	 * @return a random number between 1 and limit (inclusive)
	 */
	private int getRandomNumber(int limit) {
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		return rand.nextInt(limit) +1;
	}
	
	/**
	 * 
	 * @return count is a number of how many guess that user guess until it correct
	 */
	public int getCount() {
		return this.count;
	}
}
