public class Producto {
    private String nombre;
    private double precio;
    private int stock;

    // Constructor
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters (opcional: también podrías agregar setters si necesitas modificar los valores)
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Método para mostrar información del producto
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + stock);
    }
}
