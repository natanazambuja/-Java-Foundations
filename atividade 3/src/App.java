import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = teclado.nextLine();

        System.out.print("Digite a sua idade: ");
        int idade = teclado.nextInt();

        System.out.print("Digite a sua altura: ");
        double altura = teclado.nextDouble();

        System.out.print("Digite o nome da sua cidade: ");
        String cidade = teclado.next();

        int anoNascimento = 2023 - idade;

        System.out.println("\nHistoria Personalizada:");
        System.out.println("Ola, " + nome + "!");
        System.out.println("Voce tem " + idade + " anos e nasceu no ano de " + anoNascimento + ".");
        System.out.println("Voce mora em " + cidade + " e possui uma altura de " + altura + " metros.");
        System.out.println("Espero que e goste da sua historia!");

        teclado.close();
    }
}