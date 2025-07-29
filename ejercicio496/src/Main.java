public class Main {
    public static void main(String[] args) {
        // Crear un arreglo de productos (tamaño 3 en este ejemplo)
        Producto[] productos = new Producto[3];

        // Crear productos y guardarlos en el arreglo
        productos[0] = new Producto("Camiseta", 500.0, 10);
        productos[1] = new Producto("Zapatos", 1200.0, 5);
        productos[2] = new Producto("Pantalón", 900.0, 7);

        // Mostrar la información de todos los productos
        for (int i = 0; i < productos.length; i++) {
            productos[i].mostrarInfo();
        }
    }
}
