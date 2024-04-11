import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {
    private static final BigInteger P = new BigInteger("6277101735386680763835789423207666416083908700390324961279");
    private static final BigInteger G = new BigInteger("2");
    private static final int BIT_LENGTH = 1024;
    public static void main(String[] args) {
        BigInteger aPrivate = generatePrivateKey();
        BigInteger bPrivate = generatePrivateKey();
        BigInteger aPublic = calculatePublicKey(aPrivate);
        BigInteger bPublic = calculatePublicKey(bPrivate);
        BigInteger sharedKeyA = calculateSharedKey(aPrivate, bPublic);
        BigInteger sharedKeyB = calculateSharedKey(bPrivate, aPublic);
        if (sharedKeyA.equals(sharedKeyB)) {
            System.out.println("Shared secret key: " + sharedKeyA);
        } else {
            System.out.println("Key exchange failed.");
        }
    }
    private static BigInteger generatePrivateKey() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(BIT_LENGTH, random);
    }
    private static BigInteger calculatePublicKey(BigInteger privateKey) {
        return G.modPow(privateKey,P);
    }
    private static BigInteger calculateSharedKey(BigInteger privateKey, BigInteger publicKey) {
        return publicKey.modPow(privateKey,P);
    }
}

