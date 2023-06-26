import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // Problema 1: Conversão de temperatura
        System.out.print("Digite uma temperatura em Fahrenheit: ");
        double temperatureF = teclado.nextDouble();
        double temperatureC = fToC(temperatureF);
        System.out.println("Temp em Celsius: " + temperatureC);
        
        // Problema 2: Cálculo da hipotenusa
        System.out.print("Digite o valor do lado A: ");
        int sideA = teclado.nextInt();
        System.out.print("Digite o valor do lado B: ");
        int sideB = teclado.nextInt();
        double hypotenuse = calculateHypotenuse(sideA, sideB);
        System.out.println("Hipotenusa: " + hypotenuse);
        
        // Problema 3: Simulação de giro de dados
        int diceSum = rollDice();
        System.out.println("Soma dos valores dos dados: " + diceSum);
        
        teclado.close();
    }
    
    public static double fToC(double degreesF) {
        double degreesC = 5.0 / 9.0 * (degreesF - 32);
        return degreesC;
    }
    
    public static double calculateHypotenuse(int a, int b) {
        double c = Math.sqrt(a*a + b*b);
        return c;
    }
    
    public static int rollDice() {
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        int sum = dice1 + dice2;
        return sum;
    }
}
