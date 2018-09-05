package fizzbuzz;

import java.util.Arrays;

public class FizzBuzz {
	private final int fizzNumber;
	private final int buzzNumber;
	private boolean isFizz;
	private boolean isBuzz;
	private String[] values;
	/**
	 * Construct an object that can compute fizzbuzz values for a game of 
	 * Fizz and Buzz.
	 * 
	 * @param fizzNumber: an integer between 1 and 9
	 * @param buzzNumber: an integer between 1 and 9
	 */
	public FizzBuzz(int fizzNumber, int buzzNumber) {
		this.fizzNumber = fizzNumber;
		this.buzzNumber = buzzNumber;
	}

	/**
	 * Returns the fizzbuzz value for n. The rules are:
	 * - if n is divisible by fizzNumber, or contains the digit fizzNumber, return "fizz" 
	 * - if n is divisible by buzzNumber, or contains the digit buzzNumber, return "buzz"
	 * - however, if both the above conditions are true, you must return "fizzbuzz"
	 * - if none of the above conditions is true, return the number itself.
	 *
	 * For example, getValue(1) returns "1".
	 * 
	 * @param n: a positive integer
	 * @return the fizzbuzz value, as a String
	 */
	public String getValue(int n) {
		isFizz = n % fizzNumber == 0 || numberContainsDigit(n, fizzNumber);
		isBuzz = n % buzzNumber == 0 || numberContainsDigit(n, buzzNumber);
		if( n % fizzNumber == 0 || numberContainsDigit(n, fizzNumber) ){

			isFizz = true;
		}else{
			isFizz = false;
		};
		if( n % buzzNumber == 0 || numberContainsDigit(n, buzzNumber) ){
			
			isBuzz = true;
		}else {
//				System.out.println(n+" "+n%buzzNumber+" "+numberContainsDigit(n, buzzNumber)+" "+buzzNumber);
			isBuzz = false;
		}
//		System.out.println(n+" "+buzzNumber+", "+isBuzz+"  "+fizzNumber+", "+isFizz);
		if( isFizz && isBuzz ) {
			return "fizzbuzz";
		}else if(isFizz) {
			return "fizz";
		}else if(isBuzz) {
			return "buzz";
		}
		return Integer.toString(n); // return the number itself as a String
	}
	
	public boolean numberContainsDigit(int n, int d) {
		while( n > 1 ) {
			if ( n % 10 == d ) {
				return true;
			}
			n = Math.round(n/10);
		}
		return false;
	}

	/**
	 * Returns an array of the fizzbuzz values from start to end, inclusive.
	 * 
	 * For example, if the fizz number is 3 and buzz number is 4,
	 * getValues(2,6) should return an array of Strings:
	 * 
	 * {"2", "fizz", "buzz", "5", "fizz"}
	 * 
	 * @param start
	 *            the number to start from; start > 0
	 * @param end
	 *            the number to end at; end >= start
	 * @return the array of fizzbuzz values
	 */
	public String[] getValues(int start, int end) {
		values = new String[(end-start)+1];
		int increment = 0;
		for(int i = start; i <= end; i++) {
			values[increment++] = getValue(i);
		}

//		System.out.println(Arrays.toString(values)+" "+start+" "+ end+" "+fizzNumber+" "+buzzNumber);
		return values;
	}
}
