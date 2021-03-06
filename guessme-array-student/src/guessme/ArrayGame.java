package guessme;

import java.util.Arrays;

/**
 * An Array-based implementation of the Guess-A-Number game
 */
public class ArrayGame {

	// stores the next number to guess
	private int guess;
	private int[] guesses = new int[9000];
	private int guessIndex = 0;
	private boolean[] candidates = new boolean[9000];
//	private int lowestCandidate = 1000;
//	private int maxMatches = 0;
	private boolean gameOver = false;
	// TODO: declare additional data members, such as arrays that store
	// prior guesses, eliminated candidates etc.

	// NOTE: only primitive type arrays are allowed, such as int[], boolean[] etc.
	// You MAY NOT use any Collection type (such as ArrayList) provided by Java.
	
	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary,
	 * but DO NOT remove any provided method, otherwise your
	 * code will fail the JUnit tests!
	 * Also DO NOT create any new Java files, as they will
	 * be ignored by the autograder!
	 *******************************************************/
	
	// ArrayGame constructor method
	public ArrayGame() {
		for(int i = 0; i < candidates.length; i++) {
			candidates[i] = true;
		}
		// TODO
	}
	
	// Resets data members and game state so we can play again
	public void reset() {
		for(int i = 0; i < candidates.length; i++) {
			candidates[i] = true;
		}
		gameOver = false;
//		maxMatches = 0;
		guesses = new int[9000];
		guessIndex = 0;
		guess = 0;
		// TODO
	}
	public static boolean contains(int[] arr, int item) {
		Arrays.sort(arr);
	    int index = Arrays.binarySearch(arr, item);
	    return index >= 0;
	 }
	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		// TODO
		return contains(guesses, n);
		
	}
	
	// Returns the number of guesses so far.
	public int numGuesses() {
		if(guessIndex < 1) {
			return 0;
		}
		return priorGuesses().length;
	}
	
	/**
	 * Returns the number of matches between integers a and b.
	 * You can assume that both are 4-digits long (i.e. between 1000 and 9999).
	 * The return value must be between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example:
	 *   1234 and 4321 have 0 match;
	 *   1234 and 1114 have 2 matches (1 and 4);
	 *   1000 and 9000 have 3 matches (three 0's).
	 */
	public static int numMatches(int a, int b) { // DO NOT remove the static qualifier
		// TODO
		int matches = 0;
		for(int i = 0; i < 4; i++) {
			if(a % 10 == b % 10) {
				matches++;
			}
			a = Math.round(a/10);
			b = Math.round(b/10);
		}
		return matches;
	}
	
	/**
	 * Returns true if the game is over; false otherwise.
	 * The game is over if the number has been correctly guessed
	 * or if all candidates have been eliminated.
	 */
	public boolean isOver() {
		return gameOver;
	}
	
	// Returns the guess number and adds it to the list of prior guesses.
	
	public int getGuess() {
		for(int i = 0; i < candidates.length; i++) {
			if(candidates[i]) {
				guess = i+1000;
				guesses[guessIndex++] = guess;
				return guess;
			}
		}
		return 1000;
	}
	
	/**
	 * Updates guess based on the number of matches of the previous guess.
	 * If nmatches is 4, the previous guess is correct and the game is over.
	 * Check project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if all candidates
	 * have been eliminated (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {
		if(nmatches == 4) {
			gameOver = true;
		}
		int tempIndex = guessIndex;
		if(guesses[tempIndex] == 0) {
			tempIndex--;
		}
		boolean k = false;
		for(int i = 0; i < candidates.length; i++) {
			if(numMatches(i+1000, guesses[tempIndex]) != nmatches) {
//				System.out.println(i+1000);
				candidates[i] = false;
			}else {
				if(candidates[i] == true) {
					if(!k) {
						k = !k;
					}
				}
				
			}
		}
		
		if(!k) {

			gameOver = true;
			return false;
		}
//		
		return true;
	}
	
	public int[] priorGuesses() {
		// TODO
		if(guessIndex < 1) {
			return null;
		}
		return Arrays.copyOfRange(guesses, 0, guessIndex); 
	}
}
