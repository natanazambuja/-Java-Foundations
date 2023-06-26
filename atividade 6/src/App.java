import java.util.Scanner;





public class App {
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            // Problema 1: Validando um PIN Bancário
            int pin = 5890;
            int inputPin;
    
            do {
                System.out.print("Digite o PIN: ");
                inputPin = scanner.nextInt();
            } while (inputPin != pin);
    
            System.out.println("PIN correto inserido. Acesso concedido à conta.");
    


            // Problema 2: Exibindo Múltiplos de um Número
            System.out.print("Digite um número: ");
            int number = scanner.nextInt();
    
            for (int i = 1; i <= 12; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
    
           
           
            // Problema 3: Arte ASCII Programática
            System.out.print("Digite a largura do retângulo: ");
            int width = scanner.nextInt();
    
            System.out.print("Digite a altura do retângulo: ");
            int height = scanner.nextInt();
    
            createRectangle(width, height);
    
            System.out.print("Digite o tamanho da perna do triângulo: ");
            int legSize = scanner.nextInt();
    
            createTriangle(legSize);
        }
    
        public static void createRectangle(int width, int height) {
            if (width < 1 || height < 1) {
                System.out.println("As dimensões devem ser maiores ou iguais a 1.");
                return;
            }
    
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        }
    
        public static void createTriangle(int legSize) {
            if (legSize < 1) {
                System.out.println("O tamanho da perna deve ser maior ou igual a 1.");
                return;
            }
    
            for (int i = 0; i < legSize; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("#");
                }
                System.out.println();
            }
        }
    }