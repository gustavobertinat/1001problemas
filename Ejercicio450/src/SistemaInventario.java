import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// SistemaInventario.java
public class SistemaInventario {

    private ArrayList<Pieza> inventario = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // --- Métodos de la lógica del negocio ---

    /**
     * Busca una pieza por su nombre.
     * @param nombre El nombre de la pieza a buscar.
     * @return El objeto Pieza si se encuentra, o null si no existe.
     */
    private Pieza buscarPiezaPorNombre(String nombre) {
        for (Pieza p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombre.trim())) {
                return p;
            }
        }
        return null; // Pieza no encontrada
    }

    // 1. AGREGAR PIEZA
    private void agregarPieza() {
        try {
            System.out.println("\n--- AGREGAR NUEVA PIEZA ---");

            System.out.print("Nombre de la pieza: ");
            String nombre = scanner.nextLine();
            if (buscarPiezaPorNombre(nombre) != null) {
                System.out.println("❌ Error: Ya existe una pieza con ese nombre.");
                return;
            }

            System.out.print("Tipo de pieza (MOTOR, BATERIA, FILTRO, etc.): ");
            TipoPieza tipo = TipoPieza.valueOf(scanner.nextLine().toUpperCase()); // Convierte el String a Enum

            System.out.print("Precio unitario: ");
            double precio = scanner.nextDouble();

            System.out.print("Cantidad disponible: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Ubicación en el almacén: ");
            String ubicacion = scanner.nextLine();

            Pieza nuevaPieza = new Pieza(tipo, nombre, precio, cantidad, ubicacion);
            inventario.add(nuevaPieza);
            System.out.println("✅ Pieza agregada con éxito: " + nombre);

        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error de Tipo: El tipo de pieza ingresado no es válido.");
        } catch (InputMismatchException e) {
            System.out.println("❌ Error de entrada: Asegúrese de ingresar números para precio y cantidad.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    // 2. MODIFICAR PIEZA
    private void modificarPieza() {
        System.out.println("\n--- MODIFICAR PIEZA ---");
        System.out.print("Ingrese el nombre de la pieza a modificar: ");
        String nombreBusqueda = scanner.nextLine();

        Pieza pieza = buscarPiezaPorNombre(nombreBusqueda);

        if (pieza != null) {
            try {
                System.out.println("Pieza actual: " + pieza);
                System.out.print("Nuevo precio unitario (o -1 para no modificar): ");
                double nuevoPrecio = scanner.nextDouble();
                if (nuevoPrecio != -1) {
                    pieza.setPrecioUnitario(nuevoPrecio);
                }

                System.out.print("Nueva cantidad disponible (o -1 para no modificar): ");
                int nuevaCantidad = scanner.nextInt();
                if (nuevaCantidad != -1) {
                    pieza.setCantidadDisponible(nuevaCantidad);
                }
                scanner.nextLine(); // Consumir el salto de línea

                System.out.print("Nueva ubicación (o 'n' para no modificar): ");
                String nuevaUbicacion = scanner.nextLine();
                if (!nuevaUbicacion.equalsIgnoreCase("n")) {
                    pieza.setUbicacionAlmacen(nuevaUbicacion);
                }

                System.out.println("✅ Pieza modificada con éxito.");
            } catch (InputMismatchException e) {
                System.out.println("❌ Error de entrada: Ingrese un número válido para precio o cantidad.");
                scanner.nextLine();
            }
        } else {
            System.out.println("❌ Pieza no encontrada: " + nombreBusqueda);
        }
    }

    // 3. ELIMINAR PIEZA
    private void eliminarPieza() {
        System.out.println("\n--- ELIMINAR PIEZA ---");
        System.out.print("Ingrese el nombre de la pieza a eliminar: ");
        String nombreBusqueda = scanner.nextLine();

        Pieza piezaAEliminar = buscarPiezaPorNombre(nombreBusqueda);

        if (piezaAEliminar != null) {
            inventario.remove(piezaAEliminar);
            System.out.println("✅ Pieza eliminada con éxito: " + nombreBusqueda);
        } else {
            System.out.println("❌ Pieza no encontrada: " + nombreBusqueda);
        }
    }

    // 4. BUSCAR PIEZA POR NOMBRE
    private void buscarPieza() {
        System.out.println("\n--- BUSCAR PIEZA ---");
        System.out.print("Ingrese el nombre de la pieza a buscar: ");
        String nombreBusqueda = scanner.nextLine();

        Pieza pieza = buscarPiezaPorNombre(nombreBusqueda);

        if (pieza != null) {
            System.out.println("🎉 Pieza encontrada:");
            System.out.println(pieza);
        } else {
            System.out.println("❌ Pieza no encontrada: " + nombreBusqueda);
        }
    }

    // 5. LISTAR TODAS LAS PIEZAS
    private void listarTodasLasPiezas() {
        System.out.println("\n--- LISTADO COMPLETO DEL INVENTARIO (" + inventario.size() + " piezas) ---");
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            for (Pieza p : inventario) {
                System.out.println(p);
            }
        }
    }

    // --- Menú y Bucle Principal ---

    public void iniciar() {
        int opcion;
        // Pre-cargar algunos datos para facilitar las pruebas
        inventario.add(new Pieza(TipoPieza.MOTOR, "Motor V8", 5500.0, 3, "A-12"));
        inventario.add(new Pieza(TipoPieza.BATERIA, "Bateria Litio 12V", 85.50, 20, "B-05"));

        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        agregarPieza();
                        break;
                    case 2:
                        modificarPieza();
                        break;
                    case 3:
                        eliminarPieza();
                        break;
                    case 4:
                        buscarPieza();
                        break;
                    case 5:
                        listarTodasLasPiezas();
                        break;
                    case 0:
                        System.out.println("\n👋 Saliendo del sistema de inventario. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Error: Por favor, ingrese un número para la opción.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = -1;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n==================================");
        System.out.println("  SISTEMA DE INVENTARIO DE REPUESTOS");
        System.out.println("==================================");
        System.out.println("1. Agregar una pieza");
        System.out.println("2. Modificar datos de una pieza");
        System.out.println("3. Eliminar una pieza");
        System.out.println("4. Buscar una pieza por nombre");
        System.out.println("5. Listar todas las piezas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        SistemaInventario sistema = new SistemaInventario();
        sistema.iniciar();
    }
}1
