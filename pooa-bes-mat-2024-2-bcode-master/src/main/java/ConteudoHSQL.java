import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConteudoHSQL implements PersistenciaDB<Content>{


    private static final String DB_URL = "jdbc:hsqldb:file:database/conteudoDB";

    private static final String TITLE = "sa";
    private static final String BODY = "";
    private Connection connection = null;


    public ConteudoHSQL() {
        criarTabela();
    }

    public Connection getConnection() throws SQLException {
          if(connection == null) {
              connection = DriverManager.getConnection(DB_URL, TITLE, BODY);
          }
          return connection;
    }

     public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Content (" +
                "id INTEGER IDENTITY PRIMARY KEY, " +
                "titulo VARCHAR(255), " +
                "tipo VARCHAR(255))";
         System.out.println("TABELA " + sql + " CRIADA COM SUCESSO!");
        try {
            Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();

        }  catch (SQLException e) {
            e.printStackTrace();
        }

     }

     @Override
      public void save (Content content) {
         String sql = "INSERT INTO Content (id, titulo, tipo) VALUES (?, ?, ?)";

         try {
             Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, content.getTitle());
             stmt.setString(2, content.getBody());
             stmt.executeUpdate();
         }  catch (SQLException e) {
             e.printStackTrace();
         }
      }

      @Override
    public void list () {
         List<Content> contents = new ArrayList<Content>();
         String sql = "SELECT * FROM Content";

         try {
             Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery();
             while (rs.next()) {
                 Content content = new Content(1, rs.getString("titulo"), rs.getString("tipo"));
                 content.setId(rs.getInt("id"));
                 content.setTitle(rs.getString("Titulo"));
                 content.setBody(rs.getString("Tipo"));
                 contents.add(content);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }

     }

    @Override
    public void update(Content conteudo) {
        String sql = "UPDATE Content SET titulo = ?, texto = ?, autor = ? WHERE id = ?";

        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, conteudo.getTitle());
            stmt.setString(2, conteudo.getBody());
            stmt.setInt(3, conteudo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   @Override
    public void delete(int id) {
        String sql = "DELETE FROM Content WHERE id = ?";
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






