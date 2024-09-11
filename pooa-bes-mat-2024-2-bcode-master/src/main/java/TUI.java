import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TUI {

    Scanner scanner = new Scanner(System.in);
    ContentService contentService = new ContentService();
    UserService userService = new UserService();


     public void primeiroCadastro() {
         System.out.println("BEM VINDO AO ");
         System.out.println(" SSSSS   M     M     AAAAA   RRRRR   TTTTTT     CCCCC   M     M   SSSSS\n" +
                 "S        MM   MM    A     A  R    R     T     C       MM   MM  S\n" +
                 " SSS     M M M M    AAAAAAA  RRRRR      T    C        M M M M   SSS\n" +
                 "     S   M  M  M    A     A  R   R      T     C       M  M  M       S\n" +
                 "SSSSS    M     M    A     A  R    R     T      CCCCC  M     M  SSSSS\n");
         System.out.println("Vamos cadastrar o seu usuário! ");
         System.out.println("Digite seu nome: ");
         String Nome = scanner.nextLine();
         System.out.println("Digite sua senha: ");
         String Senha = scanner.nextLine();
         System.out.println("User/ADM: ");
         String role = scanner.nextLine();
         User user = userService.create(Nome, Senha, role);
     }

    public User mostrarMenuLogin() {
        try {
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
                        String nome = scanner.next();
                        System.out.println("Digite sua senha: ");
                        String senha = scanner.next();
                        System.out.println("User/ADM: ");
                        String papel = scanner.next();
                        Boolean login = userService.validarLogin(nome, senha, papel);
                        if (login.equals(true) && papel.equalsIgnoreCase("adm")) {
                            System.out.println(" Login ADM efetuado com sucesso! ");
                            mostrarMenuADM();
                        } else if (login.equals(true) && papel.equalsIgnoreCase("user")) {
                            System.out.println(" Login USER efetuado com sucesso! ");
                            mostrarMenuUSER();
                        } else {
                            System.out.println("Usuário e/ou senha inválidos! ");
                            mostrarMenuLogin();
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
        } catch (InputMismatchException e) {
            System.out.println("Digite uma entrada válida! ");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro! ");
        }
    return mostrarMenuLogin();
    }

           public User mostrarMenuADM() {
        try {
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
                       mostrarMenuADM();
                   case 2:
                       System.out.print("Título do Conteúdo: ");
                       scanner.nextLine();  // Consumir a nova linha
                       String title = scanner.nextLine();
                       System.out.print("Corpo do Conteúdo: ");
                       String body = scanner.nextLine();
                       contentService.create(title, body);
                       mostrarMenuADM();
                   case 3:
                       contentService.list();
                       mostrarMenuADM();
                   case 4:
                       userService.list();
                       mostrarMenuADM();

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
                           mostrarMenuADM();
                   case 6:
                       System.out.println("ID do usuario a ser excluido: ");
                       int DeleteId = scanner.nextInt();
                       userService.delete(DeleteId);
                       mostrarMenuADM();
                   case 7:
                       System.out.println("ID do usuario: ");
                       scanner.nextLine();
                       int deleteSenha = scanner.nextInt();
                       System.out.println("Nova senha: ");
                       scanner.nextLine();
                       String NewPassword2 = scanner.nextLine();
                       userService.alterarSenha(deleteSenha,NewPassword2);
                       System.out.println("Senha alterada com sucesso! ");
                       mostrarMenuADM();
                   case 8:
                       System.out.print("ID do Conteúdo a Atualizar: ");
                       int updateId = scanner.nextInt();
                       scanner.nextLine();  // Consumir a nova linha
                       System.out.print("Novo Título: ");
                       String newTitle = scanner.nextLine();
                       System.out.print("Novo Corpo: ");
                       String newBody = scanner.nextLine();
                       contentService.update(updateId, newTitle, newBody);
                       mostrarMenuADM();
                   case 9:
                       System.out.print("ID do Conteúdo a Excluir: ");
                       int deleteId = scanner.nextInt();
                       contentService.delete(deleteId);
                       mostrarMenuADM();
                   case 10:
                       System.out.println("Desconectado com sucesso!");
                       break;
                   default:
                       System.out.println("Opção inválida. Tente novamente.");
                       mostrarMenuADM();
               }
               if (userChoice == 10) {
                   mostrarMenuLogin();
           }
               return null;

           } catch (InputMismatchException e) {
            System.out.println("Digite uma entrada válida! ");
            scanner.nextLine();
              } catch (Exception e) {
            System.out.println("Erro! ");

        } return mostrarMenuADM();
           }

        public void mostrarMenuUSER() {
         try {
             System.out.println("\nMenu:");
             System.out.println("1. Criar Conteúdo");
             System.out.println("2. Listar Conteúdos");
             System.out.println("3. Alterar senha");
             System.out.println("4. Alterar conteudo");
             System.out.println("5. Excluir Conteúdo");
             System.out.println("6. Logout");
             System.out.print("Escolha uma opção: ");
             int opcao = scanner.nextInt();

             switch (opcao) {
                 case 1:
                     System.out.print("Título do Conteúdo: ");
                     scanner.next();
                     String title = scanner.nextLine();
                     System.out.print("Corpo do Conteúdo: ");
                     String body = scanner.nextLine();
                     contentService.create(title, body);
                     mostrarMenuUSER();
                 case 2:
                     contentService.list();
                     mostrarMenuUSER();
                 case 3:
                     System.out.println("ID do usuario: ");
                     int id = scanner.nextInt();
                     scanner.next();
                     System.out.println("Nova senha: ");
                     String NewPassword = scanner.nextLine();
                     userService.alterarSenha(id, NewPassword);
                     System.out.println("Senha alterada com sucesso! ");
                     mostrarMenuUSER();
                 case 4:
                     System.out.println("Id do conteúdo: ");
                     int updateId = scanner.nextInt();
                     System.out.println("Novo título: ");
                     String newTitle = scanner.nextLine();
                     scanner.nextLine();
                     System.out.print("Novo Corpo: ");
                     String newBody = scanner.nextLine();
                     contentService.update(updateId, newTitle, newBody);
                     mostrarMenuUSER();
                 case 5:
                     System.out.println("Id do conteúdo: ");
                     int deleteId = scanner.nextInt();
                     contentService.delete(deleteId);
                     mostrarMenuUSER();
                 case 6:
                     System.out.println("Desconectado com sucesso! ");
                     mostrarMenuLogin();
             }
         } catch (InputMismatchException e) {
             System.out.println("Digite uma entrada válida! ");
             scanner.nextLine();
         } catch (Exception e) {
             System.out.println("Erro! ");
         }
        }



}
