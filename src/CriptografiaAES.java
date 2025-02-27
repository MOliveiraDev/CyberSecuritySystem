import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class CriptografiaAES {
    private static final String ALGORITMO = "AES";

    // Gera uma chave AES válida
    public static SecretKey gerarChave() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITMO);
        keyGen.init(128); // Tamanho da chave: 128 bits
        return keyGen.generateKey();
    }

    // Criptografa uma mensagem
    public static String criptografar(String mensagem, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] mensagemCriptografada = cipher.doFinal(mensagem.getBytes());
        return Base64.getEncoder().encodeToString(mensagemCriptografada);
    }

    // Descriptografa uma mensagem
    public static String descriptografar(String mensagemCriptografada, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] mensagemDecriptografada = cipher.doFinal(Base64.getDecoder().decode(mensagemCriptografada));
        return new String(mensagemDecriptografada);
    }
}