import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

    public static Connection getConexao() {

        try {
            final String url = "jdbc:mysql://localhost/teste01";
            final String user = "root";
            final String senha = "";

            return DriverManager.getConnection(url, user, senha);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
