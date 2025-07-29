public class Empleado {
    private String nombre;
    private double salario;
    private int edad;

    // Constructor
    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    // Método que devuelve true si el empleado cumple ambas condiciones
    public boolean esElegible() {
        return salario > 30000 && edad >= 18;
    }

    // Método para mostrar los datos (opcional)
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + ", Salario: " + salario + ", Edad: " + edad);
    }
}



