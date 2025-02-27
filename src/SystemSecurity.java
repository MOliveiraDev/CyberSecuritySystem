import javax.crypto.SecretKey;
import java.util.Scanner;

public class SystemSecurity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Simulando um banco de dados
            String user = "admin";
            String HASHpassword = SenhasHASH.gerarHash("Senha123");

            // Autenticação do usuário
            System.out.println("Digite o nome do usuário: ");
            String username = sc.nextLine();
            System.out.println("Digite a sua senha: ");
            String password = sc.nextLine();

            // Verifica se o usuário e a senha estão corretos
            if (username.equals(user) && SenhasHASH.verificarSenha(password, HASHpassword)) {
                System.out.println("Autenticação feita com sucesso!");

                // Como gerar uma Chave AES válida ???
                SecretKey chave = CriptografiaAES.gerarChave();

                // Criptografa uma mensagem ????
                System.out.println("Digite uma mensagem para criptografar: ");
                String mensagem = sc.nextLine();

                String mensagemCriptografada = CriptografiaAES.criptografar(mensagem, chave);
                System.out.println("Mensagem criptografada: " + mensagemCriptografada);

                // Descriptografa a mensagem
                String mensagemDescriptografada = CriptografiaAES.descriptografar(mensagemCriptografada, chave);
                System.out.println("Mensagem descriptografada: " + mensagemDescriptografada);
            } else {
                System.out.println("Autenticação falhou. Usuário ou senha incorretos.");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}