import java.util.Scanner;

public class NumeroPrimo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer número del usuario
        System.out.print("Ingrese un número entero: ");
        int numero = scanner.nextInt();

        // Verificar si el número es primo
        if (esPrimo(numero)) {
            System.out.println(numero + " es un número primo.");
        } else {
            System.out.println(numero + " no es un número primo.");
        }

        scanner.close();
    }

    // Función que determina si un número es primo
    public static boolean esPrimo(int n) {
        if (n <= 1) {
            return false; // Los números menores o iguales a 1 no son primos
        }
        for (int i = 2; i <= Math.sqrt(n); i++) { // Solo hasta la raíz cuadrada
            if (n % i == 0) {
                return false; // Si es divisible, no es primo
            }
        }
        return true;
    }
}
