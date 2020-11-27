package org.qasimovey;

import org.qasimovey.cipher.RSACipher;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {
        var cipher = new RSACipher();
//        var cipher = new RSACipher(BigInteger.valueOf(251L),
//                                   BigInteger.valueOf(393959411L),
//                                   BigInteger.valueOf(2472195851L));

        System.out.println("Public key(E) IS: " + cipher.getPublicKey());
        System.out.println("Private key(D) IS: " + cipher.getPrivateKey());
        System.out.println("(N) IS: " + cipher.getN());

        String originalMessage = "SECRET MESSAGE";
        byte[] encrypted = cipher.encrypt(originalMessage.getBytes());
        byte[] decrypted = cipher.decrypt(encrypted);

        System.out.println(String.format("Original Message is: %s", originalMessage));
        System.out.println("Original Message is: " + Arrays.toString(originalMessage.getBytes()));

        System.out.println("Encrypted Message is: " + Arrays.toString(encrypted));

        System.out.println("Decrypted Message is: " + Arrays.toString(decrypted));
        System.out.println("After decryption: " + new String(decrypted, Charset.defaultCharset()));
    }


    static String buildString(byte[] arr) {
        char[] chars = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {
            chars[i] = (char)arr[i];
        }
        return String.valueOf(chars);
    }

    private static String bytesToString(byte[] encrypted){
        StringBuilder str = new StringBuilder();

        for (byte b : encrypted){
            str.append(Byte.toString(b));
        }

        return str.toString();
    }

}
