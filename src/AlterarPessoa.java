import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Informe o cod. da pessoa: ");

        int id = entrada.nextInt();


        String selectSQL = "select * from users where id = ?";
        String updateSQL = "update users set nome = ? where id = ?";

        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(selectSQL);
        stmt.setInt(1, id);

        ResultSet r = stmt.executeQuery();

        if (r.next()){
            Pessoa pessoa = new Pessoa(r.getInt(1),  r.getString(2),
                    r.getString(3),r.getString(4));

            System.out.println("O nome atual é: " + pessoa.getNome());
            entrada.nextLine();
            System.out.println("Informe o novo nome!");
            String novoNome = entrada.nextLine();
            stmt.close();

            stmt = conexao.prepareStatement(updateSQL);
            stmt.setString(1, novoNome);
            stmt.setInt(2, id);
            stmt.execute();
            System.out.println("Pessoa alterada com sucesso!");

        }else{
            System.out.println("Pessoa não encontrada!");
        }
        entrada.close();
        conexao.close();
    }
}
