
public class ISBN {

	public static void main(String[] args) {

		// Should return Valid
		System.out.println(isbn13("9780316066525"));
		
		// Should convert to valid ISBN-13 number: 9781234567897
		System.out.println(isbn13("123456789X"));
		
		// Should return Valid
		System.out.println(isbn13("9781234567897"));
		
		// Should convert to valid ISBN-13 number: 9780316066525
		System.out.println(isbn13("0316066524"));
		
		// Should return Valid
		System.out.println(isbn13("9780316066525"));
		
		// Should return Invalid
		System.out.println(isbn13("9780316066526"));
		
		// Should return Invalid
		System.out.println(isbn13("8790316066525"));
	}
	
	/**
	 * Returns whether an ISBN-13 number is valid or invalid. Also converts
	 * ISBN-10 numbers to ISBN-13, and returns that converted ISBN-13 number.
	 * @param isbn: String - The ISBN number that is checked for validity, or
	 * is converted to an ISBN-13 number.
	 * @return "Valid" if isbn is a valid ISBN-13, and "Invalid" if not a valid
	 * ISBN-13 number. Also returns a converted ISBN-13 number from a valid ISBN-10
	 * input parameter.
	 */
	public static String isbn13(String isbn) {
		
		// Default return value for function set to Invalid unless told otherwise.
		String isbnOutput = "Invalid";
		
		// If the length of the string is 13 and it begins with 978, then we proceed to
		// test if it is a valid ISBN-13 number.
		if(isbn.length() == 13 && isbn.substring(0, 3).equals("978")) {
			
			// The ISBN 13 sum that will be tested to see if it is divisible by 10.
			int isbn13Sum = 0;
			
			// Alternates between 1 and 3 based on the current index of the ISBN string.
			int alternatingIndex = 1;
			
			for(int i = 0; i < isbn.length(); i++) {
				
				// Alternating index set to 1 if index i is divisible by 2.
				if(i % 2 == 0) {
					alternatingIndex = 1;
				}
				else if(i % 2 == 1) {
					// Alternating index set to 3 if index i is NOT divisible by 2.
					alternatingIndex = 3;
				}
				
				// Gets the current character of the ISBN string at index i.
				char digit_i = isbn.charAt(i);
				
				// If the current character at index i is not a digit, then we set
				// isbn13Sum to a number that is non-divisible by 10.
				if(!Character.isDigit(digit_i)) {
					isbn13Sum = 1;
					break;
				}
				else {
					// If the character at index i is a digit, we add to the sum.
					isbn13Sum += (Character.getNumericValue(digit_i) * alternatingIndex);
				}
				
			}
			
			// If the final isbn13Sum is divisible by 10, we declare the ISBN
			// number valid.
			if(isbn13Sum % 10 == 0) {
				isbnOutput = "Valid";
			}
			
		}
		else if(isbn.length() == 10) {
			
			// The ISBN 10 sum that will be tested to see if it is divisible by 11.
			int isbn10Sum = 0;
			
			// Decreases by 1 every time we iterate through an ISBN character.
			int decreasingIndex = 10;
			
			for(int i = 0; i < isbn.length(); i++) {
				
				// Gets the current character of the ISBN string at index i.
				char digit_i = isbn.charAt(i);
				
				// Checks if the current index is NOT the index of the final character.
				if(i < isbn.length() - 1) {
					
					// If the current character at index i is NOT a digit, we set the isbn10Sum
					// to be a value that is not divisible by 11.
					if(!Character.isDigit(digit_i)) {
						isbn10Sum = 1;
						break;
					}
					else {
						// If the character at index i is a digit, we add to the sum.
						isbn10Sum += (Character.getNumericValue(digit_i) * decreasingIndex);
					}
					
				}
				else {
					
					// Checks if the current index is the index of the final character.
					
					if(Character.isDigit(digit_i)) {
						// If the character at index i is a digit, we add to the sum.
						isbn10Sum += (Character.getNumericValue(digit_i) * decreasingIndex);
					}
					else if(digit_i == 'X') {
						// If the current character at index i is an X, then we replace the
						// number in the calculation (where there is supposed to be a numeric
						// character conversion) to the value of 10.
						isbn10Sum += (10 * decreasingIndex);
					}
					else {
						// If the current character at index i is NOT a digit and is
						// not an X, we set the isbn10Sum to be a value that is not
						// divisible by 11.
						isbn10Sum = 1;
						break;
					}
				}
				
				decreasingIndex--;
				
			}
			
			// If the isbn10Sum is divisible by 11, then the ISBN string
			// is a valid ISBN-10 number, and thus, we can proceed to
			// convert the string to an ISBN-13 number.
			if(isbn10Sum % 11 == 0) {
				
				// Prefixes the ISBN-10 number with 978 and removes the last character.
				isbnOutput = "978" + isbn.substring(0, isbn.length() - 1);
				
				// The ISBN 13 sum that will be tested to see if it is divisible by 10.
				int isbn13Sum = 0;
				
				// Alternates between 1 and 3 based on the current index of the ISBN string.
				int alternatingIndex = 1;
				
				for(int i = 0; i < isbnOutput.length(); i++) {
					
					// Alternating index set to 1 if index i is divisible by 2.
					if(i % 2 == 0) {
						alternatingIndex = 1;
					}
					else if(i % 2 == 1) {
						// Alternating index set to 3 if index i is NOT divisible by 2.
						alternatingIndex = 3;
					}
					
					// Gets the current character of the ISBN string at index i.
					char digit_i = isbnOutput.charAt(i);
					
					// Calculates the current isbn13Sum before the final digit is added.
					isbn13Sum += (Character.getNumericValue(digit_i) * alternatingIndex);
				}
				
				// Determines the new final digit that will be appended to final ISBN output
				// string to make a valid ISBN-13 number.
				int newFinalDigit = 10 - (isbn13Sum % 10);
				
				// New final digit appended to the ISBN output string to make a valid
				// ISBN-13 number.
				isbnOutput += Integer.toString(newFinalDigit);
				
			}
			
		}
		
		return isbnOutput;
	}

}
