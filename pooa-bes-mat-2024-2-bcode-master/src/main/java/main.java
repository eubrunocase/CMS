import java.util.Scanner;
public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TUI ui = new TUI();
        User currentUser = null;


        while (true) {
         ui.primeiroCadastro();
            if (currentUser == null) {
                currentUser = ui.mostrarMenuLogin();
            } else {
                currentUser = ui.mostrarMenuADM();
            }
        }
    }

}

