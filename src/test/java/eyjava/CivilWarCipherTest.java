package eyjavaexam;

import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 
 * This test is the sole property of EY and may not be shared without EY's express consent.  All rights reserved.
 *
 */

public class CivilWarCipherTest {
	
	@Test
	public void test1() {
		CivilWarCipher enc = new CivilWarCipher(
				"YES", 
				Alphabet.UPPPERCASE_QWERTY
		);
		String plainText = "AT MIDNIGHT ATTACK";
		String encrypted = enc.encrypt(plainText);
		String decrypted = enc.decrypt(encrypted);
		System.out.println(plainText);
		System.out.println(encrypted);
		System.out.println(decrypted);
		assertTrue("ATMIDNIGHTATTACK".equals(decrypted) );
	}
	
	@Test
	public void test2() {
		CivilWarCipher enc = new CivilWarCipher("AbeLincoln", 
			Alphabet.NUMBERS
			.plus(Alphabet.UPPERCASE)
			.plus(Alphabet.LOWERCASE)
		);
		String plainText = "Meet 12 soldiers! Outside the depot, at dusk";
		String encrypted = enc.encrypt(plainText);
		String decrypted = enc.decrypt(encrypted);
		//System.out.println(encrypted);
		//System.out.println(decrypted);
		assertTrue(! encrypted.equals(decrypted));
		assertTrue("Meet12soldiersOutsidethedepotatdusk".equals(decrypted));
		//we'll test for the expected length of the string joined together
		//with out the spaces & any characters
		assertEquals( 35,decrypted.length());
		assertNotNull( encrypted );
		assertNotNull( decrypted );
	}        //     Meet12soldiers'z'Outsidethedepot'z'atdusk

	@Test
	public void test3() {

		Alphabet masterAlphabet = Alphabet.NUMBERS
		.plus(Alphabet.UPPERCASE)
		.plus(Alphabet.LOWERCASE);

		
		Alphabet randomAlphabet = Alphabet.NUMBERS
		.plus(Alphabet.UPPERCASE)
		.plus(Alphabet.LOWERCASE);

		char[] validChars = randomAlphabet.validChars;
		Random random = new Random();

		for(int i=0; i<50000; i++) {
			String key = new String(randomChars(random, validChars, 10));
			String message = new String(randomChars(random, validChars, 30));
			
			CivilWarCipher enc = new CivilWarCipher(key, masterAlphabet);
			String encrypted = enc.encrypt(message);
			String decrypted = enc.decrypt(encrypted);
			assertTrue(message.equals(decrypted));
		}
	}	
	
	char[] randomChars(Random random, char[] input, int howMany) {
		howMany = Math.min(howMany, input.length);
		for(int i=0; i < input.length; i++) {
			int ni = input.length - i;
			int ri = random.nextInt(ni);
			swap(input, ni - 1, ri);
		}
		char[] answer = new char[howMany];
		System.arraycopy(input, input.length - howMany - 1, answer, 0, howMany);
		return answer;
	}
	
	void swap(char[] input, int a, int b) {
		char ca = input[a];
		input[a] = input[b];
		input[b] = ca;		
	}
}
