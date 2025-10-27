import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa a un alumno con su nombre y un registro de materias y notas.
 */
public class Alumno {
    private String nombre;
    // El mapa guarda la materia (clave: String) y una lista de notas (valor: List<Double>)
    private Map<String, List<Double>> materias;

    /**
     * Constructor para inicializar un nuevo alumno.
     * * @param nombre El nombre completo del alumno.
     */
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.materias = new HashMap<>();
    }

    /**
     * Agrega una nota para una materia específica.
     * * @param materia El nombre de la materia.
     * @param nota La nota a agregar (debe estar en el rango [0.0, 10.0]).
     * @throws IllegalArgumentException Si la nota no está en el rango [0.0, 10.0].
     */
    public void agregarNota(String materia, double nota) {
        if (nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException("La nota debe estar en el rango de 0.0 a 10.0.");
        }

        // Obtiene la lista de notas para esa materia o crea una nueva si no existe (Java 8+)
        // `computeIfAbsent` es una forma eficiente de asegurar que la lista exista.
        List<Double> notas = materias.computeIfAbsent(materia, k -> new ArrayList<>());
        notas.add(nota);
        System.out.println("Nota " + nota + " agregada a " + materia + " para " + this.nombre + ".");
    }

    /**
     * Calcula el promedio general de todas las notas en todas las materias.
     * * @return El promedio general (double) o 0.0 si no hay notas.
     */
    public double calcularPromedioGeneral() {
        double totalNotas = 0.0;
        int conteoNotas = 0;

        // Itera sobre todas las listas de notas en el mapa de materias
        for (List<Double> notas : materias.values()) {
            for (double nota : notas) {
                totalNotas += nota;
                conteoNotas++;
            }
        }

        if (conteoNotas == 0) {
            return 0.0;
        }

        return totalNotas / conteoNotas;
    }

    /**
     * Método principal para demostrar el uso de la clase Alumno.
     */
    public static void main(String[] args) {
        // 1. Crear una instancia de la clase Alumno
        Alumno alumnoEjemplo = new Alumno("Juan Pérez");
        System.out.println("Alumno: " + alumnoEjemplo.nombre);
        System.out.println("------------------------------");

        // 2. Agregar notas
        alumnoEjemplo.agregarNota("Matemáticas", 7.5);
        alumnoEjemplo.agregarNota("Matemáticas", 8.0);
        alumnoEjemplo.agregarNota("Literatura", 9.0);
        alumnoEjemplo.agregarNota("Historia", 6.5);
        alumnoEjemplo.agregarNota("Historia", 7.0);
        System.out.println("------------------------------");

        // 3. Mostrar las materias y notas almacenadas
        System.out.println("Registro de notas:");
        for (Map.Entry<String, List<Double>> entry : alumnoEjemplo.materias.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("------------------------------");

        // 4. Calcular el promedio general
        double promedioGeneral = alumnoEjemplo.calcularPromedioGeneral();

        // 5. Imprimir el resultado
        System.out.printf("El promedio general de %s es: **%.2f**%n", alumnoEjemplo.nombre, promedioGeneral);
    }
}