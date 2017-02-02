import java.util.Scanner;

/**
 * GameConsole is a class that act as a UI of the program.
 * 
 * @author Narut Poovorakit
 *
 */
public class GameConsole {

	/**
	 * A method play is to run the process of the game or initial the game
	 * 
	 * @param game
	 *            is a GuessingGame object that contain the algorithm of the
	 *            game.
	 * @return a secret number
	 */
	public int play(GuessingGame game) {
		boolean check = false;
		String title = "Guessing Game";
		String temp = "What is your guess?";
		System.out.println(title);
		System.out.println(game.getHint());
		System.out.println(temp);

		Scanner scanner = new Scanner(System.in);
		int input = 0;
		while (!check) {
			input = scanner.nextInt();
			if (input < 1 || input > game.getUpperBound()) {
				System.out.println("Your guess is out of bound, What is your guess?");
				continue;
			}
			check = game.guess(input);
			String hint = game.getHint();
			System.out.println(hint);
			if (!check)
				System.out.println(temp);

		}
		System.out.println("You used " + game.getCount() + " guesses.");
		return input;

	}
}
