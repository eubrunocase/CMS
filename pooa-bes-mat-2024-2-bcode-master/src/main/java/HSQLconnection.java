import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HSQLconnection {
    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Caminho do banco de dados
            String dbPath = "file:./data/database.db";
            String url = "jdbc:hsqldb:" + dbPath;

            // Conectando ao banco de dados HSQLDB
            connection = DriverManager.getConnection(url, "SA", "");

            System.out.println("Conectado! ");

            // Executar operações no banco de dados...

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fechar a conexão
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }






    }
}
