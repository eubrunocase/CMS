import java.util.Scanner;
public class mainTeste {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TuiTESTE ui = new TuiTESTE();
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