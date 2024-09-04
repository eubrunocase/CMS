
public class main {
    public static void main(String[] args) {

        TUI ui = new TUI();
        User currentUser = null;

        while (true) {
            if (currentUser == null) {
                currentUser = ui.mostrarMenuLogin();
            } else {
                currentUser = ui.mostrarMenuConteudo(currentUser);
            }
        }
    }

}

