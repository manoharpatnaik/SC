import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {

    private BigInteger modulus;
    private BigInteger publicKey;
    private BigInteger privateKey;

    // Constructor to generate RSA key pair with specified bit length
    public RSA(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bitLength / 2, random);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, random);
        modulus = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        publicKey = new BigInteger("65537"); // Common value in practice (2^16 + 1)
        privateKey = publicKey.modInverse(phi);
    }

    // Encrypt plaintext using RSA public key
    public BigInteger encrypt(BigInteger plaintext) {
        return plaintext.modPow(publicKey, modulus);
    }

    // Decrypt ciphertext using RSA private key
    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(privateKey, modulus);
    }

    public static void main(String[] args) {
        int bitLength = 1024; // Specify desired bit length for RSA key
        RSA rsa = new RSA(bitLength);

        BigInteger plaintext = new BigInteger("1234567890");
        System.out.println("Plaintext: " + plaintext);

        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);

        BigInteger decryptedText = rsa.decrypt(ciphertext);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
