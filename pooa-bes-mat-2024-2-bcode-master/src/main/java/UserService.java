import java.util.ArrayList;
import java.util.List;

public class UserService implements PersistenciaUsuario{

    private List<User> users;

    public UserService() {
        users = new ArrayList<User>();
    }

    @Override
    public void create(String username, String password, String role) {
        User user = new User(username, password, role);
        users.add(user);
        System.out.println("User " + username + " criado com sucesso! ");
    }

    @Override
    public void list() {
     if (users.isEmpty()) {
         System.out.println("Não existem usuarios cadastrados!");
     } else {
         for (User user : users )
             System.out.println(user);
     }
    }

    @Override
    public void update(String username,String newUsername, String newPassword, String newRole) {
       User user = findUser(username);
       if (user != null) {
           user.setUsername(newUsername);
           user.setPassword(newPassword);
           user.setRole(newRole);
           System.out.println("User " + username + " atualizado com sucesso!");
       }
        System.out.println("Usuário não encontrado");
    }

    @Override
    public void delete(String username) {
      User user = findUser(username);
      if (user != null) {
          users.remove(user);
          System.out.println("User " + username + " removido com sucesso!");
      }
        System.out.println("Usuário encontrado");
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


}
