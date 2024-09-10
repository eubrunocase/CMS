import java.util.ArrayList;
import java.util.List;

/*
*  Author: @Bruno Cazé and @Zaira Dutra
*
*  Classe responsável por possuir as propriedades do CRUD da entidade Usuário;
*
 */
public class UserService implements PersistenciaUsuario{

  /*
  * A classe atual implementa a interface "PersistenciaUsuario", assinando todos os seus metodos.
  *
  * Colletion "users" para armazenar usuários.
  *
  * Atributo NextId para iteração e identificação de cada usuário individualmente
   */
    private List<User> users;
    private int NextId = 1;

    /*
    * Construtor da classe que incializa a collection como um ArrayList do tipo "User".
    * Inicializa o NextId
     */
    public UserService() {
        users = new ArrayList<User>();
    }
    /*
    * Metodo "create" responsável por criar novos usuários.
    *
    * Quando chamado, o metodo cria um novo objeto "user" passando as entradas recebidas
    * no momento da chamada, em seguida o adiciona no Array de "users" e retorna o user adicionado
     */
    @Override
    public User create(String username, String password, String role) {
        User user = new User(NextId++, username, password, role);
        users.add(user);
        System.out.println("Usuário " + username + " criado com sucesso! ");
        return user;
    }
    /*
    * Metodo responsável pela listagem dos usuários.
    *
    * Quando chamado, verifica se o Array de users está vazio e caso sim, exibe a mensagem de aviso.
    *
    * Caso tenho usuários cadastrados, utiliza um loop For-Each para percorrer o array e exibir os usuários
    * com o chamado do toString presente na classe User.
    *
     */
    @Override
    public void list() {
     if (users.isEmpty()) {
         System.out.println("Não existem usuarios cadastrados!");
     } else {
         for (User user : users )
             System.out.println(user.toString());
     }
    }
    /*
    * Metodo responsável por atualizar as informações de usuários cadastrados.
    *
    * Assinado com parâmetro de id para identificação do usuário, e parâmetros "new" para as novas informações.
    * Inicia com uma variável do tipo User, chamando o metodo findUser() e passando id como argumento.
    *
    * Utiliza um IF para caso existam usuários(user != null) setar as novas informações utilizando os metodos Set da classe User.
    * Caso não existam usuários, retorna uma mensagem de aviso.
     */
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
  /*
  * Metodo responsável por remover usuários.
  *
  * Inicia uma variável do tipo User, chamando o metodo findUser() para buscar o usuário pelo id.
  *
  * Utiliza um IF para caso exista o usuário cadastrado com id passado na entrada(scanner), removê-lo
  * utilizando o ".remove()" do arrayList.
  *
  */
    @Override
    public void delete(int id) {
      User user = findUser(id);
      if (user != null) {
          users.remove(user);
          System.out.println("User " + id + " removido com sucesso!");
      } else
        System.out.println("Usuário não encontrado");
    }
    /*
     * Metodo responsável por pegar os usuários pelo Id.
     *
     * Utiliza um laço For-Each para percorrer o arrays de users, e usa o getId presente na classe User
     * para capturar e comparar o id do usuário com o parâmetro.
     *
     */
    private User findUser(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
   /*
   * Metodo responsável pela validação do login do usuário.
   *
   * Utiliza um laço For-Each para percorrer o arrays de users,
   * e um IF utilizando os Getters para os atributos da classe User e os comparando com os parâmetros.
   *
   * Caso sejam iguais, retorna true.
   *
    */
    public Boolean validarLogin(String username, String password, String role) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password) && user.getRole().equalsIgnoreCase(role)) {
                return true;
            }
        }
        return false;
    }
  /*
  * Metodo responsável por alterar a senha do usuário cadastrado.
  *
  * Inicia uma variável do tipo User, chamado o metodo findUser().
  *
  * Utiliza um IF para caso exista o usuário cadastrado com id fornecido pela entrada(user != null),
  * chama o metodo "set" do atributo password presente na classe User.
  *
   */
    public void alterarSenha (int id, String novaSenha) {
        User user = findUser(id);
        if (user != null) {
            user.setPassword(novaSenha);
        } else {
            System.out.println("Usuário não encontrado! ");
        }
    }

}




