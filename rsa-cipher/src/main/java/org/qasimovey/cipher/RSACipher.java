package org.qasimovey.cipher;

import java.math.BigInteger;
import java.util.Random;

public class RSACipher {

    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger publicKey;
    private BigInteger privateKey;
    private int bitlength = 512;//1024;
    private Random random;

    public RSACipher() {

        random = new Random();

        //choose the two enough large prime numbers
        //it uses Fermat Theorem to find largest prime using probability
        p = BigInteger.probablePrime(bitlength, random);
        q = BigInteger.probablePrime(bitlength, random);

        //product of two prime numbers which are stored in p and q
        N = p.multiply(q);

        //Toitent Function phi(N) = (p-1) * (q-1)
        phi = p.subtract(BigInteger.ONE)
                .multiply(q.subtract(BigInteger.ONE));

        //pick up any prime number that lies on interval 1 and f(n), as public key (E)
        publicKey = BigInteger.probablePrime(bitlength / 2, random);

        //finding inverse of number based on given  modulus
        // 1/d = public(key) mod p
        while (phi.gcd(publicKey).compareTo(BigInteger.ONE) > 0 && publicKey.compareTo(phi) < 0)
        {
            publicKey.add(BigInteger.ONE);
        }

        //finding D key which plays role of private key
        privateKey = publicKey.modInverse(phi);
    }

    public RSACipher(BigInteger publicKey, BigInteger privateKey, BigInteger N) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.N = N;
    }

    // Encrypt message
    public byte[] encrypt(byte[] message) {
        //c = m^e mod n
        return (new BigInteger(message)).modPow(publicKey, N).toByteArray();
    }

    // Decrypt message
    public byte[] decrypt(byte[] message) {
        //m = c^d mod n
        return (new BigInteger(message)).modPow(privateKey, N).toByteArray();
    }

    public BigInteger getPublicKey() {
        return this.publicKey;
    }

    public BigInteger getPrivateKey() {
        return this.privateKey;
    }

    public BigInteger getN(){
        return this.N;
    }
}
