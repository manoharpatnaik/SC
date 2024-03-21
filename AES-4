import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.util.Scanner;
import java.util.Base64;

public class AesExample {
    public static void main(String[] argv) {
        try {
            KeyGenerator keygenerator = KeyGenerator.getInstance("AES");
            SecretKey myAesKey = keygenerator.generateKey();
            Cipher aesCipher;
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter data:");
            String data = sc.nextLine();
            
            aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            aesCipher.init(Cipher.ENCRYPT_MODE, myAesKey);
            
            byte[] text = data.getBytes();
            System.out.println("Message: " + new String(text));
            System.out.println("Message [Byte Format]: " + text);
            
            byte[] textEncrypted = aesCipher.doFinal(text);
            String encryptedBase64 = Base64.getEncoder().encodeToString(textEncrypted);
            System.out.println("Encrypted Message: " + encryptedBase64);
            
            aesCipher.init(Cipher.DECRYPT_MODE, myAesKey);
            
            byte[] decryptedText = aesCipher.doFinal(Base64.getDecoder().decode(encryptedBase64));
            System.out.println("Decrypted Message: " + new String(decryptedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
