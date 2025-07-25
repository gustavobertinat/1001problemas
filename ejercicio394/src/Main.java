public class Main {

    // Función que recibe un arreglo y suma los múltiplos de 3
    public static int sumarMultiplosDeTres(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] % 3 == 0) {
                suma += arreglo[i];
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] numeros = {4, 3, 6, 7, 9, 11, 12};
        int resultado = sumarMultiplosDeTres(numeros);
        System.out.println("La suma de los múltiplos de 3 es: " + resultado);
    }
}
