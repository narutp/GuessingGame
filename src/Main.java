
/**
 * A main class that run the program by create a Guessing game and Game console.
 * @author Narut Poovorakit
 *
 */
public class Main {
	public static void main(String[] args) {
		GuessingGame game = new GuessingGame(20);
		GameConsole ui = new GameConsole();
		ui.play(game);
	}
}
