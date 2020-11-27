package org.qasimovey.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RSACipherTest {

    @Test
    public void testRSA() {
        var cipher = new RSACipher();

        String originalMessage = "Your text message";
        var encrypted = cipher.encrypt(originalMessage.getBytes());
        var decrypted = cipher.decrypt(encrypted);

        Assertions.assertArrayEquals(originalMessage.getBytes(),decrypted);
    }



}
