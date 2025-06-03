import java.util.Scanner;

public class SumaParesImpares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario el rango
        System.out.print("Ingrese el número inicial del rango: ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el número final del rango: ");
        int fin = scanner.nextInt();

        int sumaPares = 0;
        int sumaImpares = 0;

        // Sumar pares e impares
        for (int i = inicio; i <= fin; i++) {
            if (i % 2 == 0) {
                sumaPares += i;
            } else {
                sumaImpares += i;
            }
        }

        // Mostrar resultados
        System.out.println("Suma de números pares: " + sumaPares);
        System.out.println("Suma de números impares: " + sumaImpares);

        scanner.close();
    }
}
