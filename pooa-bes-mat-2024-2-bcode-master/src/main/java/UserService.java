import java.util.ArrayList;
import java.util.List;

public class UserService implements PersistenciaUsuario{

    private List<User> users;
    private int NextId;

    public UserService() {
        users = new ArrayList<User>();
    }

    @Override
    public User create(String username, String password, String role) {
        User user = new User(NextId++, username, password, role);
        users.add(user);
        System.out.println("Usuário " + username + " criado com sucesso! ");
        return user;
    }

    @Override
    public void list() {
     if (users.isEmpty()) {
         System.out.println("Não existem usuarios cadastrados!");
     } else {
         for (User user : users )
             System.out.println(user.toString());
     }
    }

    @Override
    public void update(int id, String newUsername, String newPassword, String newRole) {
       User user = findUser(id);
       if (user != null) {
           user.setUsername(newUsername);
           user.setPassword(newPassword);
           user.setRole(newRole);
           System.out.println("User " + id + " atualizado com sucesso!");
       } else
        System.out.println("Usuário não encontrado");
    }

    @Override
    public void delete(int id) {
      User user = findUser(id);
      if (user != null) {
          users.remove(user);
          System.out.println("User " + id + " removido com sucesso!");
      } else
        System.out.println("Usuário não encontrado");
    }

    private User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Boolean validarLogin(String username, String password, String role) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }

    public void alterarSenha (int id, String novaSenha) {
        User user = findUser(id);
        if (user != null) {
            user.setPassword(novaSenha);
        } else {
            System.out.println("Usuário não encontrado! ");
        }
    }

}




