
public class Authentication {
    /*
    *  author: @Bruno Cazé
    *
    * Classe responsável por realizar a autenticação do login
    * Obs: Houveram problemas na hora de implementar os recursos de autenticação na classe main
    *  então essa classe ainda não está sendo utilizada dentro do fluxo do algoritmo
     */


    private boolean loggedIn = false;

    public boolean login(String username, String password) {
        if (username.equals("admin") && password.equals("admin")) {
            loggedIn = true;
            System.out.println("Login bem-sucedido!");
            return true;
        } else {
            return false;
        }
    }

    public void logout() {
        loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
