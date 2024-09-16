import java.sql.SQLException;

public class teste {
    public static void main(String[] args) throws SQLException {
    UsuarioHSQL u1 = new UsuarioHSQL();
    ConteudoHSQL c1 = new ConteudoHSQL();


    u1.criarTabela();
    c1.criarTabela();
    }
}
