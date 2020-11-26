package org.qasimovey;

import org.qasimovey.cipher.CeaserCipher;

public class MainApplication {
    public static void main(String[] args) {

        var message = "Your message here";
        int key = 10 ; //non-negative key

        var cipher = CeaserCipher.encrypt(message,key);
        var result = CeaserCipher.decrypt(cipher,key);

        System.out.println(String.format("Encrypted message is : %s",cipher));
        System.out.println(String.format("After decryption, origal message was: %s",result));
    }
}
