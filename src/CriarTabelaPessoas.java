import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas{

    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricaConexao.getConexao();

        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id int auto_increment primary key," +
                "nome varchar (50), " +
                "telefone varchar (20), " +
                "senha varchar (32)" +
                ")";

        Statement stmt = conexao.createStatement();

        stmt.execute(sql);

        System.out.println("Tabela criada com sucesso!");
        conexao.close();
    }
}
