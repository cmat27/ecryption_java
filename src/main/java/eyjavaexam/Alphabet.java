package eyjavaexam;

/**
 * 
 * This test is the sole property of EY and may not be shared without EY's express consent.  All rights reserved.
 *
 */

public class Alphabet {
	public static Alphabet NUMBERS = new Alphabet(48, 58);
	public static Alphabet UPPERCASE = new Alphabet(65, 91);
	public static Alphabet LOWERCASE = new Alphabet(97, 123);
	public static Alphabet UPPPERCASE_QWERTY = new Alphabet("QWERTYUIOPASDFGHJKLZXCVBNM");
	
	char[] validChars;
	
	public Alphabet(String validChars) {
		this(validChars.toCharArray());
	}

	public Alphabet(char[] validChars) {
		System.out.println(validChars);
		this.validChars = validChars;
	}

	public Alphabet(int start, int endNonIncl) {
		validChars = new char[endNonIncl - start];
		for(int i=start, vindex = 0; i<endNonIncl; i++, vindex++) {
			validChars[vindex] = (char)i;

		}
	}

	public Alphabet plus(Alphabet a) {
		char[] chars = new char[validChars.length + a.validChars.length];
		
	System.arraycopy(validChars, 0, chars, 0, validChars.length);
	System.arraycopy(a.validChars, 0, chars, validChars.length, a.validChars.length);
		return new Alphabet(chars);
	}


}
