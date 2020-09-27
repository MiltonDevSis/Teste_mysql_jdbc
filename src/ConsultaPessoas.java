import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaPessoas {

    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricaConexao.getConexao();

        Statement stmt = conexao.createStatement();

        String texto;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Oque deseja pesquisar");
        texto = entrada.nextLine();
        String sql = "select * from users where nome like '%"+texto+"%'";

        ResultSet resultado = stmt.executeQuery(sql);

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
