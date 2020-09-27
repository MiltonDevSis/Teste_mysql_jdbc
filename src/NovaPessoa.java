import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {

    public static void main(String[] args) throws SQLException {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = entrada.nextLine();
        System.out.println("Informe o telefone: ");
        String telefone = entrada.nextLine();
        System.out.println("Informe a senha: ");
        String senha = entrada.nextLine();

        Connection conexao = FabricaConexao.getConexao();
        String sql = "insert into masters (nome, telefone, senha) values (?, ?, ?)";

        PreparedStatement prepare = conexao.prepareStatement(sql);
        prepare.setString(1, nome);
        prepare.setString(2, telefone);
        prepare.setString(3, senha);
        prepare.execute();

        System.out.println("Pessoa incluida com sucesso!");

        entrada.close();
    }
}
