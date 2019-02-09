########### This test is the sole property of EY and may not be shared without EY's express consent.  All rights reserved.

############ the challenge
During the American Civil War, an encryption scheme was widely used to communicate within the military.

It relied on a password (or pass phrase) that was agreed upon ahead of time.  
This password (or pass phrase) was then used both by the sender to encrypt the message as well as by the receiver to decrypt it.

------------ To encrypt a message:

Suppose the message is "AT MIDNIGHT ATTACK", and the password is "YES"

1. write the password repeatedly under the message, lining up the letters:

	AT MIDNIGHT ATTACK   <--- the message
	YE SYESYESY ESYESY   <--- the password, repeated as necessary to match message length

2. now "add" each pair of vertical letters to produce the corresponding encrypted letter.  
To add a pair of letters, look up each letter's index position in a table, then add the two index values together and find the letter which corresponds to that new combined index. 
If the combined index is larger than the table, then simply wrap around to the beginning of the table (in other words there's no such thing as an IndexOutOfBoundsException here!).

For example if our table of letters is "QWERTYUIOPASDFGHJKLZXCVBNM", then writing the index values below each letter for illustration purposes we have a lookup table like this:

Q W E R T Y U I O P A  S  D  F  G  H  J  K  L  Z  X  C  V  B  N  M 
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25

In this particular example our lookup table (or "alphabet") only supports upper case letters, but in some of our test cases we must also support mixed case as well as numbers.
Our code should be flexible enough to support any arbitrary subset of (ASCII) characters.  We call this character set an "alphabet".

We now use these index values from our "alphabet" to add the letter pairs, and then convert the sums back into letters:

	AT MIDNIGHT ATTACK   <--- the message
	YE SYESYESY ESYESY   <--- the password, repeated as necessary to match message length
	-------------------
	HU ADGPDJQP DHPDUV   <--- the sum of each vertical pair of letters
    HU ADGPDJQP DHPDUV
The first letter was calculated like this:
A + Y is really 10 + 5.  The sum is 15, which = H

The second letter was calculated like this:
T + E is really 4 + 2.  The sum is 6, which = U

The third letter was calculated like this:
M + S is really 25 + 11.  This exceeds the table size so we wrap around and continue counting from the beginning to reach 10, which = A

And so on.  Notice that spaces and any other characters not contained in the lookup table are ignored.
Therefore if your alphabet does not contain spaces, as in this case, then spacing is lost during encryption/decryption.

At this point we have our encrypted message, which is HUADGPDJQPDHPDUV


################## how to build and run
This code uses Maven (version 3+) to build and run at the command line.  (Or you could use an IDE like Eclipse if you prefer)

to build:
	mvn clean package

to test:
	mvn test


################## your tasks to complete this test

1. Implement the CivilWarCipher's encrypt(String text) and decrypt(String text) methods so that all tests inside CivilWarCipherTest pass.  
You may freely modify any code except for the tests themselves -- do whatever you need to the source code to produce a clean solution, but leave all tests inside CivilWarCipherTest unchanged.

2. Email a zip of your complete finished source code back to the person who sent you this test

