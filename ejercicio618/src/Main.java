public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Laura", 35000, 25);
        Empleado e2 = new Empleado("Juan", 25000, 30);
        Empleado e3 = new Empleado("Ana", 40000, 17);

        e1.mostrarDatos();
        System.out.println("¿Es elegible? " + e1.esElegible());

        e2.mostrarDatos();
        System.out.println("¿Es elegible? " + e2.esElegible());

        e3.mostrarDatos();
        System.out.println("¿Es elegible? " + e3.esElegible());
    }
}

