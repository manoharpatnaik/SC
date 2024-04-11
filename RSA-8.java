import java.math.BigInteger;

public class RSA {

    public static void main(String args[]) {

        int p = 17; // Prime p
        int q = 19; // Prime q

        // The number to be encrypted and decrypted
        int msg = 8;

        int n = p * q;
        int z = (p - 1) * (q - 1);
        System.out.println("Prime p = " + p);
        System.out.println("Prime q = " + q);
        System.out.println("Phi = " + z);

        int e = 65537; // Public key exponent
        int d = 161;    // Private key exponent

        System.out.println("Public = " + e);
        System.out.println("Private = " + d);
        System.out.println("Modulus = " + n);

        // Encrypting the message
        BigInteger encrypted = BigInteger.valueOf(msg).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
        System.out.println("Encrypted message is : " + encrypted);

        // Decrypting the message
        BigInteger decrypted = encrypted.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
        System.out.println("Decrypted message is : " + decrypted);

    }

}
