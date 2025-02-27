import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SenhasHASH {
    // Gera um hash SHA-256 de uma senha
    public static String gerarHash(String senha) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(senha.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }

    // Verifica se uma senha corresponde a um hash
    public static boolean verificarSenha(String senha, String hashArmazenado) throws NoSuchAlgorithmException {
        String hashSenha = gerarHash(senha);
        return hashSenha.equals(hashArmazenado);
    }
}