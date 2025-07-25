import java.util.ArrayList;
import java.util.Scanner;

public class InventarioApp {
    private static final int MAX_PRODUCTOS = 1000;
    private static ArrayList<Producto> inventario = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Agregar stock a producto");
            System.out.println("3. Restar stock a producto");
            System.out.println("4. Actualizar datos del producto");
            System.out.println("5. Mostrar inventario completo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    agregarProducto(sc);
                    break;
                case 2:
                    modificarStock(sc, true);
                    break;
                case 3:
                    modificarStock(sc, false);
                    break;
                case 4:
                    actualizarProducto(sc);
                    break;
                case 5:
                    mostrarInventario();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);

        sc.close();
    }

    private static void agregarProducto(Scanner sc) {
        if (inventario.size() >= MAX_PRODUCTOS) {
            System.out.println("Inventario lleno. No se pueden agregar más productos.");
            return;
        }

        System.out.print("Ingrese código del producto: ");
        int codigo = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (buscarProducto(codigo) != null) {
            System.out.println("Ya existe un producto con ese código.");
            return;
        }

        System.out.print("Ingrese descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Ingrese precio: ");
        float precio = sc.nextFloat();

        Producto nuevo = new Producto(codigo, descripcion, precio);
        inventario.add(nuevo);
        System.out.println("Producto agregado con éxito.");
    }

    private static void modificarStock(Scanner sc, boolean agregar) {
        System.out.print("Ingrese código del producto: ");
        int codigo = sc.nextInt();
        Producto prod = buscarProducto(codigo);

        if (prod == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese cantidad: ");
        int cantidad = sc.nextInt();

        if (agregar) {
            prod.agregarStock(cantidad);
            System.out.println("Stock agregado.");
        } else {
            prod.restarStock(cantidad);
            System.out.println("Stock reducido.");
        }
    }

    private static void actualizarProducto(Scanner sc) {
        System.out.print("Ingrese código del producto: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        Producto prod = buscarProducto(codigo);

        if (prod == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Nueva descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Nuevo precio: ");
        float precio = sc.nextFloat();

        prod.actualizarDescripcion(descripcion);
        prod.actualizarPrecio(precio);

        System.out.println("Datos actualizados.");
    }

    private static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            System.out.println("\n--- Inventario ---");
            for (Producto p : inventario) {
                System.out.println(p);
            }
        }
    }

    private static Producto buscarProducto(int codigo) {
        for (Producto p : inventario) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }
}

