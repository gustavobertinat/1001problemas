class Estudiante implements Comparable<Estudiante> {
    // Atributos
    private String nombre;
    private int edad;
    private double promedio;

    // Constructor
    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getPromedio() {
        return promedio;
    }

    // Método toString para una impresión fácil
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad + ", Promedio: " + String.format("%.2f", promedio);
    }

    /**
     * Implementación del método compareTo para ordenar.
     * Se ordena de MAYOR a MENOR promedio.
     * Para ordenar de MENOR a MAYOR, intercambia (o.promedio - this.promedio).
     */
    @Override
    public int compareTo(Estudiante otroEstudiante) {
        // La resta devuelve:
        // - un valor negativo si 'this' es menor que 'otroEstudiante'.
        // - cero si son iguales.
        // - un valor positivo si 'this' es mayor que 'otroEstudiante'.

        // Para ordenar por nota de MAYOR a MENOR:
        // Si this.promedio (e.g., 9.5) > otroEstudiante.promedio (e.g., 8.0)
        // La resta (8.0 - 9.5) es negativa. Esto indica que 'this' viene *antes* de 'otroEstudiante' en el orden.
        // El resultado se multiplica por -1 para invertir el comportamiento natural de Double.compare,
        // lo que nos da un orden descendente (mayor promedio primero).
        // *Alternativamente, usamos Double.compare(o2, o1) para orden descendente.*

        // Orden descendente (MAYOR promedio primero)
        return Double.compare(otroEstudiante.promedio, this.promedio);
    }
}