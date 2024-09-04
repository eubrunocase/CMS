import java.util.Scanner;

public class TUI {

    Scanner scanner = new Scanner(System.in);
    Authentication auth = new Authentication();
    ContentService contentService = new ContentService();
    UserService userService = new UserService();


    public User mostrarMenuLogin() {
        while (true) {
            System.out.println("Menu inicial: ");
            System.out.println("1. Login ");
            System.out.println("2. Listar conteúdos ");
            System.out.println("3. Sair ");
            System.out.println("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite seu nome: ");
                    scanner.nextLine();
                    String nome = scanner.nextLine();
                    System.out.println("Digite sua senha: ");
                    String senha = scanner.next();
                    System.out.println("Digite o seu papel: ");
                    String papel = scanner.next();
                    User user = userService.create(nome, senha, papel);
                    if (user != null) {
                        return user;
                    } else {
                        System.out.println("Login inválido! ");
                        return null;
                    }
                case 2:
                    contentService.list();
                    break;
                case 3:
                    System.out.println("Saindo... ");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! ");
            }
        }
    }

           public User mostrarMenuConteudo (User currentUser) {
               System.out.println("\nMenu:");
               System.out.println("1. Criar usuário ");
               System.out.println("2. Criar Conteúdo");
               System.out.println("3. Listar Conteúdos");
               System.out.println("4. Listar usuários");
               System.out.println("5. Alterar usuário");
               System.out.println("6. Remover usuário");
               System.out.println("7. Alterar senha");
               System.out.println("8. Atualizar Conteúdo");
               System.out.println("9. Excluir Conteúdo");
               System.out.println("10. Logout");
               System.out.print("Escolha uma opção: ");
               int userChoice = scanner.nextInt();

               switch (userChoice) {
                   case 1:
                       System.out.print("Username: ");
                       scanner.nextLine();
                       String Username = scanner.nextLine();
                       System.out.print("Password: ");
                       String Password = scanner.nextLine();
                       System.out.println("Role: ");
                       String role = scanner.nextLine();
                       userService.create(Username, Password, role);
                       break;
                   case 2:
                       System.out.print("Título do Conteúdo: ");
                       scanner.nextLine();  // Consumir a nova linha
                       String title = scanner.nextLine();
                       System.out.print("Corpo do Conteúdo: ");
                       String body = scanner.nextLine();
                       contentService.create(title, body);
                       break;
                   case 3:
                       contentService.list();
                       break;
                   case 4:
                       userService.list();
                       break;

                       case 5:
                           System.out.println("ID do usuario: ");
                           int id = scanner.nextInt();
                           scanner.nextLine();
                           System.out.println("Novo nome do usuario: ");
                           String NewUsername = scanner.nextLine();
                           System.out.println("Nova senha: ");
                           String NewPassword = scanner.nextLine();
                           System.out.println("Novo papel: ");
                           String NewPapel = scanner.nextLine();
                           userService.update(id, NewUsername, NewPassword, NewPapel);
                           break;
                   case 6:
                       System.out.println("ID do usuario a ser excluido: ");
                       int DeleteId = scanner.nextInt();
                       userService.delete(DeleteId);
                       break;
                   case 7:
                       System.out.println("ID do usuario: ");
                       scanner.nextLine();
                       int deleteSenha = scanner.nextInt();
                       System.out.println("Nova senha: ");
                       scanner.nextLine();
                       String NewPassword2 = scanner.nextLine();
                       userService.alterarSenha(deleteSenha,NewPassword2);
                       System.out.println("Senha alterada com sucesso! ");
                       break;
                   case 8:
                       System.out.print("ID do Conteúdo a Atualizar: ");
                       int updateId = scanner.nextInt();
                       scanner.nextLine();  // Consumir a nova linha
                       System.out.print("Novo Título: ");
                       String newTitle = scanner.nextLine();
                       System.out.print("Novo Corpo: ");
                       String newBody = scanner.nextLine();
                       contentService.update(updateId, newTitle, newBody);
                       break;
                   case 9:
                       System.out.print("ID do Conteúdo a Excluir: ");
                       int deleteId = scanner.nextInt();
                       contentService.delete(deleteId);
                       break;
                   case 10:
                       auth.logout();
                       System.out.println("Desconectado com sucesso!");
                       break;
                   default:
                       System.out.println("Opção inválida. Tente novamente.");
                       break;
               }
               if (userChoice == 10) {
                   currentUser = null;
           }
               return currentUser;

           }

}
