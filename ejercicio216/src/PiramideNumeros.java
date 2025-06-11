import java.util.Scanner;

public class PiramideNumeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario la cantidad de filas
        System.out.print("Ingrese el número de filas de la pirámide: ");
        int filas = scanner.nextInt();

        int numero = 1; // Número inicial

        // Generar la pirámide
        for (int i = 1; i <= filas; i++) { // Cada fila
            for (int j = 1; j <= i; j++) { // Elementos por fila
                System.out.print(numero + " ");
                numero++;
            }
            System.out.println(); // Salto de línea después de cada fila
        }

        scanner.close();
    }
}
