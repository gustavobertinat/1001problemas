import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un número N: ");
        int N = scanner.nextInt();

        int suma = 0;
        int numeroImpar = 1;

        System.out.print("Números impares sumados: ");
        for (int i = 0; i < N; i++) {
            System.out.print(numeroImpar);
            if (i < N - 1) {
                System.out.print(" + ");
            }
            suma += numeroImpar;
            numeroImpar += 2;
        }

        System.out.println("\nLa suma de los primeros " + N + " números impares es: " + suma);
    }
}
