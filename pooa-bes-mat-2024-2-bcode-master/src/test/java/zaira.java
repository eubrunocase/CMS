import java.util.Scanner;

public class zaira {
    public static void main(String[] args) {

     Scanner input = new Scanner(System.in);

        System.out.println("digite sua idade");
        int idade = input.nextInt();

        if (idade < 18) {
            System.out.println("voce e menor de idade");
        } else {
            System.out.println("VOCE E MAIOR DE IDADE");
        }

    }
}
