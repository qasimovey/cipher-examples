package org.qasimovey.cipher;

public class CeaserCipher {

    public static final int letterCount = 26;

    public static String encrypt(String message, int offset){
        if(offset < 0){
            throw new IllegalArgumentException("offset can`t be negative!");
        }

        return message.codePoints()
                       .mapToObj(letterCode->(char)CeaserCipher.applyRule(letterCode,
                                                                          offset))
                       .collect(StringBuffer::new,
                                StringBuffer::append,
                                StringBuffer::append)
                       .toString();
    }

    private static int applyRule(int letterCode,int offset){
        if(Character.isLowerCase(letterCode)){
            int letterOriginalPosition = letterCode - 'a';
            int letterNewPosition = (letterOriginalPosition + offset) % letterCount;
            int newCharacter = 'a' + letterNewPosition;
            return newCharacter;
        }
        else if (Character.isUpperCase(letterCode)){
            int originalAlphabetPosition = letterCode - 'A';
            int newAlphabetPosition = (originalAlphabetPosition + offset) % letterCount;
            int newCharacter = 'A' + newAlphabetPosition;
            return newCharacter;
        }
        else {
            return letterCode;
        }
    }

    public static String decrypt(String cipher, int offset){
        if(offset < 0){
            throw new IllegalArgumentException("offset can`t be negative!");
        }

        return encrypt(cipher,letterCount-(offset%letterCount));
    }
}
