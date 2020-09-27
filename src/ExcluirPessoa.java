import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o id: ");

        int id = entrada.nextInt();

        Connection conexao = FabricaConexao.getConexao();
        String sql = "delete from users where id = ?";

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id);

        if (stmt.executeUpdate() > 0){
            System.out.println("Pessoa excluida com sucesso!");
        }else{
            System.out.println("Nada feito!");
        }

        conexao.close();
        entrada.close();
    }
}
