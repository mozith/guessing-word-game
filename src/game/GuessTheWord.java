package game;

import java.util.Scanner;

public class GuessTheWord {

	private boolean play = true;
	private Words randomWord = new Words();
	private Scanner input = new Scanner(System.in);
	private int rounds = 10;
	private char lastRound;
	private StringBuilder guessedLetter = new StringBuilder();

	public void start() {
		do {
			showWord();
			getInput();
			checkInput();
		} while (play);
	}

	void showWord() {
		System.out.println("You have " + rounds + " tries left.");
		System.out.println("The letters you have guessed: " + guessedLetter);
		System.out.println(randomWord);
	}

	void getInput() {
		System.out.println("Enter a letter to guess the word: ");
		String userGuess = input.nextLine();

		if (userGuess.length() > 1) {
			if (userGuess.equals(randomWord.selectedWord())) {
				System.out.println("grats you won!");
				System.out.println("The word is: " + randomWord.selectedWord());
				play = false;
			} else {
				System.out.println("Sorry, that's not the word we're looking for.");
			}
		} else if (userGuess.length() == 1) {
			lastRound = userGuess.charAt(0);
			guessedLetter.append(lastRound).append(", ");
		}

		lastRound = userGuess.charAt(0);
	}

	void checkInput() {
		boolean isGuessedRight = randomWord.guess(lastRound);

		if (isGuessedRight) {
			if (randomWord.isGuessedRight()) {
				System.out.println("Grats you won!");
				System.out.println("The word is: " + randomWord);
				play = false;
			}
		}

		else {
			rounds--;

			if (rounds == 0) {
				System.out.println("Game Over. You Lose.");
				play = false;
			}
		}
	}

	public void end() {
		input.close();

	}

}
