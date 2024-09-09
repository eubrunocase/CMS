import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HSQLconnection {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Carregar o driver JDBC
            Class.forName("org.hsqldb.jdbc.JDBCDriver");

            // Conectar ao banco de dados HSQLDB em memória
            String url = "jdbc:hsqldb:mem:testdb"; // banco em memória
            String user = "SA"; // Usuário padrão
            String password = ""; // Senha padrão (vazia)
            connection = DriverManager.getConnection(url, user, password);

            // Criar uma tabela
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS users (id INTEGER IDENTITY, name VARCHAR(50))";
            statement.execute(createTableSQL);

            System.out.println("Conectado ao HSQLDB e tabela criada.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
