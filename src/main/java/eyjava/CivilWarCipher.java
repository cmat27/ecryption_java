package eyjavaexam;

/**
 * This test is the sole property of EY and may not be shared without EY's express consent.  All rights reserved.
 */
public class CivilWarCipher {

    private String key;

   private  Alphabet alphabet = null;

    private char[] originalMessage;
    private char[] validAlpha;
    private char[] enCryptedMsg;
    private char[] validChars;
    private char[] keyPass;
    private int encryptIndex = 0;
    private int k = 0;
    private boolean invalidChar = false;
    //---

    StringBuilder encryptedMsg = new StringBuilder();
    StringBuilder decryptedMsg = new StringBuilder();


    public CivilWarCipher(String key, Alphabet alphabet) {
        this.key = key;
        this.alphabet = alphabet;
    }

    public String encrypt(String text) {
        originalMessage = text.toCharArray();
        keyPass = key.toCharArray();
        validAlpha = alphabet.validChars;
        boolean newCharToEncryp = true;

        for (char ogMsgChar : originalMessage) {
            newCharToEncryp = true;// we'll be reset at the beginning of every iteration

            int validMsgMatchVal = -1;
            int validKeyMatchVal = -1;

             //invalid char will be used to exclude character or spaces from encrypting
            // this can be tweeked to other characters as needed bases
            invalidChar = (ogMsgChar>31 && ogMsgChar < 48) ? true : false;

            for (int i = 0; i < validAlpha.length; i++) {
             //we'll use  a reg for loop to get the index and minimize chances of error
                boolean validMsgMatch = (ogMsgChar == validAlpha[i]) ? true : false;


                if (validMsgMatch) {
                    validMsgMatchVal = i;

                } else if (invalidChar) {
                    validMsgMatchVal = -1;
                    break;
                }

                boolean validKeyMatch = (keyPass[k] == validAlpha[i]) ? true : false;
                if (validKeyMatch && newCharToEncryp) {
                    validKeyMatchVal = i;
                    k++;
                    //if the character has been checked and confirmed
                    // it will set it to false to avoid re verification
                    newCharToEncryp = false;
                    if (k == keyPass.length) {
                        k = 0;
                    }

                }

            }


            int tmpIndex = validMsgMatchVal + validKeyMatchVal;
             // if the index is larger than the lentgh of the valid characters we'll
            // loop back into the array
            encryptIndex = (tmpIndex > (validAlpha.length - 1)) ? (tmpIndex - validAlpha.length) : tmpIndex;

            if (encryptIndex > -1 && encryptIndex < validAlpha.length) {

                encryptedMsg.append( validAlpha[encryptIndex] );
            }

        }
        //System.out.println(encryptedMsg);

        return encryptedMsg.toString();
    }

    public String decrypt(String text) {
// decripting same process as encrypting
        enCryptedMsg = text.toCharArray();
        validChars = alphabet.validChars;
        keyPass = key.toCharArray();
        k = 0;

         decryptedMsg = new StringBuilder();


         for(char encryptedMsg : enCryptedMsg ){
            int decryptValue = -1;
            int keyValue = -1;
            boolean newCharToDecryp = true;

            for (int j = 0; j < validChars.length; j++) {

                if (encryptedMsg == validChars[j]) {
                    decryptValue = j;
                }
                if (keyPass[k] == validChars[j] && newCharToDecryp) {
                    keyValue = j;
                    newCharToDecryp = false;
                    k++;

                    if (key.length() == k) {
                        k = 0;
                    }
                }
            }
           //
            encryptIndex= decryptValue - keyValue;

            if (encryptIndex >= 0) {
                decryptedMsg.append( validChars[encryptIndex] );
            } else {
                int tmpIndex = encryptIndex + validChars.length;
                decryptedMsg.append( validChars[tmpIndex] );
            }
        }

        return decryptedMsg.toString();
    }

}
