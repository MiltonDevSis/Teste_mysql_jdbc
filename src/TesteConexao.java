import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost";
        final String user = "root";
        final String senha = "";

        Connection conexao = DriverManager.getConnection(url, user, senha);

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS teste01");

        System.out.println("Banco de dados criado com sucesso");

        conexao.close();
    }
}
