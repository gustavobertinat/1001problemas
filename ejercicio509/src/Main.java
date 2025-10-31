import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Crear una lista (ArrayList) para almacenar objetos Estudiante
        List<Estudiante> listaEstudiantes = new ArrayList<>();

        // 2. Ingresar estudiantes a la lista
        System.out.println("📝 Ingresando estudiantes...");
        listaEstudiantes.add(new Estudiante("Ana García", 20, 9.5));
        listaEstudiantes.add(new Estudiante("Luis Pérez", 22, 8.0));
        listaEstudiantes.add(new Estudiante("Marta Díaz", 19, 7.8));
        listaEstudiantes.add(new Estudiante("Carlos Ruiz", 21, 9.5)); // Mismo promedio

        System.out.println("\n➡️ Estudiantes antes de ordenar:");
        for (Estudiante e : listaEstudiantes) {
            System.out.println(e);
        }

        // 3. Ordenar la lista por nota (promedio)
        // Collections.sort() utiliza el método compareTo implementado en la clase Estudiante.
        System.out.println("\n⏳ Ordenando estudiantes por promedio (de MAYOR a MENOR)...");
        Collections.sort(listaEstudiantes);

        // 4. Mostrar la lista ordenada
        System.out.println("\n✅ Estudiantes ordenados por promedio:");
        for (Estudiante e : listaEstudiantes) {
            System.out.println(e);
        }
    }
}
