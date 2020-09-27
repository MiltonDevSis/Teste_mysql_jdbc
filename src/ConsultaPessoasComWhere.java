import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaPessoasComWhere {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);

        Connection conexao = FabricaConexao.getConexao();
        String sql = "select * from users where nome like ?";

        System.out.println("Oque deseja pesquisar");
        String texto = entrada.nextLine();

        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, "%" + texto + "%");
        ResultSet resultado = stmt.executeQuery();

        List<Pessoa> pessoas = new ArrayList<>();

        while (resultado.next()){
            int id = resultado.getInt("id");
            String nome = resultado.getString("nome");
            String telefone = resultado.getString("telefone");
            String senha = resultado.getString("senha");
            pessoas.add(new Pessoa(id, nome, telefone, senha));
        }
        for(Pessoa p: pessoas){
            System.out.println(p.getId()+" "+p.getNome()+" "+p.getTelefone()+" "+p.getSenha());
        }

        stmt.close();
        conexao.close();
    }
}
