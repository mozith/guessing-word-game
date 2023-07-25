package game;

import java.util.Random;

public class Words {

	private String[] randomWords  = {"apple", "banana", "orange", "grape", "kiwi", "mango",
	                                  "lemon", "cherry", "strawberry", "blueberry", "watermelon",
	                                  "pineapple", "papaya", "peach", "apricot", "plum", "pear",
	                                  "avocado", "coconut", "raspberry", "blackberry", "lime",
	                                  "melon", "guava", "cranberry", "fig", "passionfruit",
	                                  "pomegranate", "dragonfruit", "elderberry"};
	
	private Random random = new Random();
	private String selectedWord;
	private char[] letters;
	
	public Words() {
		selectedWord = randomWords[random.nextInt(randomWords.length)];
		letters = new char[selectedWord.length()];
	}
	
	
	public String toString() {
		
		StringBuilder text = new StringBuilder();
		

		for (char letter : letters) {
			text.append(letter == '\0' ? '_' : letter);
			text.append(" ");
		}
			
		return text.toString();
		
	}
	
	public boolean isGuessedRight() {
		for (char letter : letters) {
			if (letter == '\0') {				
				return false;
			}
		}
		return true;
	}


	public boolean guess(char letter) {
		boolean guessedRight = false;
		for (int i = 0; i < selectedWord.length(); i++) {
			if (letter == selectedWord.charAt(i)) {
				letters[i] = letter;
				guessedRight = true;
			}
		}
		return guessedRight;
	}
	
	public char[] getLetters() {
		return letters;
	}
	
	public String selectedWord() {
		return selectedWord;
	}

}
