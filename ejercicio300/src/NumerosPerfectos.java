import java.util.Scanner;

public class NumerosPerfectos {

    // Función que verifica si un número es perfecto
    public static boolean esPerfecto(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma == numero;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Pedir los límites del rango
        System.out.print("Ingrese el límite de búsqueda más bajo de números perfectos: ");
        int limiteInferior = input.nextInt();

        System.out.print("Ingrese el límite de búsqueda más alto de números perfectos: ");
        int limiteSuperior = input.nextInt();

        System.out.print("Los números perfectos del " + limiteInferior + " al " + limiteSuperior + " son: ");

        int cantidad = 0;
        boolean primero = true;

        // Buscar e imprimir los números perfectos
        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            if (esPerfecto(i)) {
                if (!primero) {
                    System.out.print(" ");
                }
                System.out.print(i);
                primero = false;
                cantidad++;
            }
        }

        if (cantidad == 0) {
            System.out.print("Ninguno encontrado.");
        }

        // Mostrar la cantidad total al final
        System.out.println("\nCantidad total de números perfectos encontrados: " + cantidad);
    }
}
