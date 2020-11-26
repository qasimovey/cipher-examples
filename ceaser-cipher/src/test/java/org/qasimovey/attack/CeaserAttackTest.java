package org.qasimovey.attack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.qasimovey.cipher.CeaserCipher;

public class CeaserAttackTest {

    @Test
    public void testAttackMethod1(){
        //given
        String plainText="Hello Children";
        String cipheredText= CeaserCipher.encrypt(plainText,1);

        //when
        String result = CeaserAttack.breakCipher(cipheredText);

        //when
        Assertions.assertEquals(result,plainText);
    }

    @Test
    public void testAttackMethod2(){
        //given
        String plainText="Hi guys, This is so secret message";
        String cipheredText= CeaserCipher.encrypt(plainText,1);

        //when
        String result = CeaserAttack.breakCipher(cipheredText);

        //when
        Assertions.assertEquals(result,plainText);
    }

    @Test
    public void testAttackMethod3(){
        //given
        String plainText="Modern problems require modern solutions";
        String cipheredText= CeaserCipher.encrypt(plainText,1);

        //when
        String result = CeaserAttack.breakCipher(cipheredText);

        //when
        Assertions.assertEquals(result,plainText);
    }
}
