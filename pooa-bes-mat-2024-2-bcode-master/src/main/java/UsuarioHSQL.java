import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class UsuarioHSQL implements PersistenciaDB<User>{

    private static final String DB_URL = "jdbc:hsqldb:file:;ifexists=true";

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";
    private static final String ROLE = "";
    private Connection connection = null;


    public UsuarioHSQL() {
        criarTabela();
    }

    public Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        }
        return connection;
    }

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS USUARIO (" +
                "id INTEGER IDENTITY PRIMARY KEY, " +
                "username VARCHAR(255), " +
                "body VARCHAR(255))";
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();

        }  catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(User entidade) {
      String sql = "INSERT INTO USUARIO (username, body) VALUES (?, ?)";
     try {
         Connection con = getConnection();
         PreparedStatement stmt = con.prepareStatement(sql);
         stmt.setString(1, entidade.getUsername());
         stmt.setString(2, entidade.getPassword());
         stmt.executeUpdate();
     }
     catch (SQLException e) {
         e.printStackTrace();
     }
    }

    @Override
    public void update(User entidade) {
        String sql = "UPDATE USUARIO SET username = ?, body = ? WHERE id = ?";

        try {
           Connection con = getConnection();
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setString(1, entidade.getUsername());
           stmt.setString(1, entidade.getPassword());
           stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void list() {
      List<User> lista = new ArrayList<User>();
      String sql = "SELECT * FROM USUARIO";

      try {
          Connection con = getConnection();
          PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery();
         while (rs.next()) {
             User user = new User(1, rs.getString("Username"), rs.getString("Password"), rs.getString("Role"));
             user.setId(rs.getInt("id"));
             user.setUsername(rs.getString("Username"));
             user.setPassword(rs.getString("Password"));
             user.setRole(rs.getString("Role"));
             lista.add(user);
         }
          } catch (SQLException e) {
          e.printStackTrace();
      }


    }

    @Override
    public void delete(int id) {
      String sql = "DELETE FROM USUARIO WHERE id = ?";
      boolean delete = false;

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            delete = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
