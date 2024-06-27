import java.util.InputMismatchException;
import java.util.Scanner;

public class Excepcione extends Exception {
    public Excepcione(String message) {
        super(message);
    }
    public static int leerEntero(Scanner scanner) {
        while (true) {
            try {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.nextLine();
            }
        }
    }
}