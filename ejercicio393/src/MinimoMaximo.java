
import java.util.Scanner;

public class MinimoMaximo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer la cantidad de elementos
        System.out.print("Ingrese la cantidad de elementos del arreglo: ");
        int n = scanner.nextInt();

        // Verificar que la cantidad sea válida
        if (n <= 0) {
            System.out.println("El tamaño del arreglo debe ser mayor que cero.");
            return;
        }

        int[] arreglo = new int[n];

        // Leer los elementos del arreglo
        System.out.println("Ingrese los elementos del arreglo:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        // Inicializar mínimo y máximo con el primer elemento
        int minimo = arreglo[0];
        int maximo = arreglo[0];

        // Recorrer el arreglo para encontrar el mínimo y máximo
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i] < minimo) {
                minimo = arreglo[i];
            }
            if (arreglo[i] > maximo) {
                maximo = arreglo[i];
            }
        }

        // Mostrar resultados
        System.out.println("Valor mínimo: " + minimo);
        System.out.println("Valor máximo: " + maximo);

        scanner.close();
    }
}
