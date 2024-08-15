import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContentManager contentManager = new ContentManager();
        Authentication auth = new  Authentication();

        while (true) {
            System.out.println("Menu Inicial:");
            System.out.println("1. Login");
            System.out.println("2. Listar Conteúdos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Usuário: ");
                    String username = scanner.next();
                    System.out.print("Senha: ");
                    String password = scanner.next();

                    if (true) {
                        while (true) {
                            System.out.println("\nMenu:");
                            System.out.println("1. Criar Conteúdo");
                            System.out.println("2. Listar Conteúdos");
                            System.out.println("3. Atualizar Conteúdo");
                            System.out.println("4. Excluir Conteúdo");
                            System.out.println("5. Logout");
                            System.out.print("Escolha uma opção: ");
                            int userChoice = scanner.nextInt();

                            switch (userChoice) {
                                case 1:
                                    System.out.print("Título do Conteúdo: ");
                                    scanner.nextLine();  // Consumir a nova linha
                                    String title = scanner.nextLine();
                                    System.out.print("Corpo do Conteúdo: ");
                                    String body = scanner.nextLine();
                                    contentManager.createContent(title, body);
                                    break;
                                case 2:
                                    contentManager.listContents();
                                    break;
                                case 3:
                                    System.out.print("ID do Conteúdo a Atualizar: ");
                                    int updateId = scanner.nextInt();
                                    scanner.nextLine();  // Consumir a nova linha
                                    System.out.print("Novo Título: ");
                                    String newTitle = scanner.nextLine();
                                    System.out.print("Novo Corpo: ");
                                    String newBody = scanner.nextLine();
                                    contentManager.updateContent(updateId, newTitle, newBody);
                                    break;
                                case 4:
                                    System.out.print("ID do Conteúdo a Excluir: ");
                                    int deleteId = scanner.nextInt();
                                    contentManager.deleteContent(deleteId);
                                    break;
                                case 5:
                                    auth.logout();
                                    System.out.println("Desconectado com sucesso!");
                                    break;
                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                                    break;
                            }

                            if (userChoice == 5) break;
                        }
                    } else {
                        System.out.println("Login falhou. Usuário ou senha inválidos.");
                    }
                    break;

                case 2:
                    contentManager.listContents();
                    break;

                case 3:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}


