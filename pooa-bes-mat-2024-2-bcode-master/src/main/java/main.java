import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Fluxo do algoritmo ainda não está finalizado,
* pendências: Autenticação e criação de novos usuários
*
 */

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Authentication auth = new Authentication();
        ContentService contentService = new ContentService();
        UserService userService = new UserService();


//        try {
//        while (true) {
//            System.out.println("Menu Inicial:");
//            System.out.println("1. Login");
//            System.out.println("2. Listar Conteúdos");
//            System.out.println("3. Sair");
//            System.out.print("Escolha uma opção: ");
//            int escolha = scanner.nextInt();
//
//                int opcao = escolha;
//                    switch (escolha) {
//                        case 1:
//                            System.out.print("Usuário: ");
//                            String username = scanner.next();
//                            System.out.print("Senha: ");
//                            String password = scanner.next();
//                            if (username.equalsIgnoreCase("bruno") && password.equalsIgnoreCase("0810")) {
//                                System.out.println("Login efetuado com sucesso!");
//                                if (true) {
//                                    while (true) {
//                                        System.out.println("\nMenu:");
//                                        System.out.println("1. Criar Conteúdo");
//                                        System.out.println("2. Listar Conteúdos");
//                                        System.out.println("3. Atualizar Conteúdo");
//                                        System.out.println("4. Excluir Conteúdo");
//                                        System.out.println("5. Logout");
//                                        System.out.print("Escolha uma opção: ");
//                                        int userChoice = scanner.nextInt();
//
//                                        switch (userChoice) {
//                                            case 1:
//                                                System.out.print("Título do Conteúdo: ");
//                                                scanner.nextLine();  // Consumir a nova linha
//                                                String title = scanner.nextLine();
//                                                System.out.print("Corpo do Conteúdo: ");
//                                                String body = scanner.nextLine();
//                                                contentService.create(title, body);
//                                                break;
//                                            case 2:
//                                                contentService.list();
//                                                break;
//                                            case 3:
//                                                System.out.print("ID do Conteúdo a Atualizar: ");
//                                                int updateId = scanner.nextInt();
//                                                scanner.nextLine();  // Consumir a nova linha
//                                                System.out.print("Novo Título: ");
//                                                String newTitle = scanner.nextLine();
//                                                System.out.print("Novo Corpo: ");
//                                                String newBody = scanner.nextLine();
//                                                contentService.update(updateId, newTitle, newBody);
//                                                break;
//                                            case 4:
//                                                System.out.print("ID do Conteúdo a Excluir: ");
//                                                int deleteId = scanner.nextInt();
//                                                contentService.delete(deleteId);
//                                                break;
//                                            case 5:
//                                                auth.logout();
//                                                System.out.println("Desconectado com sucesso!");
//                                                break;
//                                            default:
//                                                System.out.println("Opção inválida. Tente novamente.");
//                                                break;
//                                        }
//
//                                        if (userChoice == 5) break;
//                                    }
//                                } else {
//                                    System.out.println("Login falhou. Usuário ou senha inválidos.");
//                                }
//                                break;
//                            } else {
//                                System.out.println("Não foi possível realizar o login!");
//                                break;
//                            }
//                        case 2:
//                            contentService.list();
//                            break;
//
//                        case 3:
//                            System.out.println("Saindo do sistema...");
//                            scanner.close();
//                            System.exit(0);
//
//                        default:
//                            System.out.println("Opção inválida. Tente novamente.");
//                    }
//                }
//            } catch (Exception e) {
//            System.out.println("Digite um input válido!");
//        }
//
//
//        }
try {
        while (true) {

            System.out.println("Menu inicial: ");
            System.out.println("1. Login ");
            System.out.println("2. Listar conteúdos ");
            System.out.println("3. Sair ");
            System.out.println("Escolha uma opção: ");
            int choice = scanner.nextInt();

            int escolha = choice;
            switch (escolha) {
                        case 1:
                            System.out.print("Usuário: ");
                            String username = scanner.next();
                            System.out.print("Senha: ");
                            String password = scanner.next();
                            if (username.equalsIgnoreCase("bruno") && password.equalsIgnoreCase("0810")) {
                                System.out.println("Login efetuado com sucesso!");
                                if (true) {
                                    while (true) {
                                        System.out.println("\nMenu:");
                                        System.out.println("1. Criar usuário ");
                                        System.out.println("2. Criar Conteúdo");
                                        System.out.println("3. Listar Conteúdos");
                                        System.out.println("4. Listar usuários");
                                        System.out.println("5. Atualizar Conteúdo");
                                        System.out.println("6. Excluir Conteúdo");
                                        System.out.println("7. Logout");
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
                                                System.out.print("ID do Conteúdo a Atualizar: ");
                                                int updateId = scanner.nextInt();
                                                scanner.nextLine();  // Consumir a nova linha
                                                System.out.print("Novo Título: ");
                                                String newTitle = scanner.nextLine();
                                                System.out.print("Novo Corpo: ");
                                                String newBody = scanner.nextLine();
                                                contentService.update(updateId, newTitle, newBody);
                                                break;
                                            case 6:
                                                System.out.print("ID do Conteúdo a Excluir: ");
                                                int deleteId = scanner.nextInt();
                                                contentService.delete(deleteId);
                                                break;
                                            case 7:
                                                auth.logout();
                                                System.out.println("Desconectado com sucesso!");
                                                break;
                                            default:
                                                System.out.println("Opção inválida. Tente novamente.");
                                                break;
                                        }
                                        if (userChoice == 7) break;

                                    }
                                } else {
                                    System.out.println("Login falhou. Usuário ou senha inválidos.");
                                }
                                break;
                            } else {
                                System.out.println("Não foi possível realizar o login!");
                                break;
                            }

                        case 2:
                            contentService.list();
                            break;

                        case 3:
                            System.out.println("Saindo do sistema...");
                            scanner.close();
                            System.exit(0);

                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            } catch (Exception e) {
            System.out.println("Digite um input válido!");
        }



        }


    }



