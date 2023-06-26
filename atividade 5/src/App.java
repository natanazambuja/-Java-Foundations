import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Problema 5-1: Determinando a cor no espectro visível
        System.out.print("Digite o comprimento de onda (nm): ");
        double comprimentoOnda = teclado.nextDouble();
        determinarCorNoEspectro(comprimentoOnda);

        // Problema 5-2: Determinando a próxima cor de um sinal de trânsito
        System.out.print("Digite o código da cor atual do semáforo: ");
        int codigoCorAtual = teclado.nextInt();
        determinarProximaCorIf(codigoCorAtual);

        // Problema 5-3: Determinando a próxima cor de um sinal de trânsito usando switch
        System.out.print("Digite o código da cor atual do semáforo: ");
        codigoCorAtual = teclado.nextInt();
        determinarProximaCorSwitch(codigoCorAtual);

        teclado.close();
    }

    public static void determinarCorNoEspectro(double comprimentoOnda) {
        if (comprimentoOnda >= 380 && comprimentoOnda < 450)
            System.out.println("A cor correspondente é Violeta");
        else if (comprimentoOnda >= 450 && comprimentoOnda < 495)
            System.out.println("A cor correspondente é Azul");
        else if (comprimentoOnda >= 495 && comprimentoOnda < 570)
            System.out.println("A cor correspondente é Verde");
        else if (comprimentoOnda >= 570 && comprimentoOnda < 590)
            System.out.println("A cor correspondente é Amarelo");
        else if (comprimentoOnda >= 590 && comprimentoOnda < 620)
            System.out.println("A cor correspondente é Laranja");
        else if (comprimentoOnda >= 620 && comprimentoOnda <= 750)
            System.out.println("A cor correspondente é Vermelho");
        else
            System.out.println("O comprimento de onda não está dentro do espectro visível");
    }

    public static void determinarProximaCorIf(int codigoCorAtual) {
        if (codigoCorAtual == 1)
            System.out.println("Próximo sinal de trânsito é verde");
        else if (codigoCorAtual == 2)
            System.out.println("Próximo sinal de trânsito é amarelo");
        else if (codigoCorAtual == 3)
            System.out.println("Próximo sinal de trânsito é vermelho");
        else
            System.out.println("Cor inválida");
    }

    public static void determinarProximaCorSwitch(int codigoCorAtual) {
        switch (codigoCorAtual) {
            case 1:
                System.out.println("Próximo sinal de trânsito é verde");
                break;
            case 2:
                System.out.println("Próximo sinal de trânsito é amarelo");
                break;
            case 3:
                System.out.println("Próximo sinal de trânsito é vermelho");
                break;
            default:
                System.out.println("Cor inválida");
        }
    }
}