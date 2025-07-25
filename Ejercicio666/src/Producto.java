public class Producto {
    private int codigo;
    private String descripcion;
    private float precio;
    private int stock;

    public Producto(int codigo, String descripcion, float precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = 0; // Inicialmente 0
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    public void restarStock(int cantidad) {
        if (cantidad <= stock) {
            this.stock -= cantidad;
        } else {
            System.out.println("No hay suficiente stock para quitar " + cantidad + " unidades.");
        }
    }

    public void actualizarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void actualizarPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Código: " + codigo +
                ", Descripción: " + descripcion +
                ", Precio: $" + precio +
                ", Stock: " + stock;
    }
}

