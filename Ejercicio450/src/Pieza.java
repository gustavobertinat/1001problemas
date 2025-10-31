// Pieza.java
public class Pieza {
    private TipoPieza tipo;
    private String nombre;
    private double precioUnitario;
    private int cantidadDisponible;
    private String ubicacionAlmacen;

    // Constructor
    public Pieza(TipoPieza tipo, String nombre, double precioUnitario, int cantidadDisponible, String ubicacionAlmacen) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidadDisponible = cantidadDisponible;
        this.ubicacionAlmacen = ubicacionAlmacen;
    }

    // --- Getters y Setters ---

    public TipoPieza getTipo() { return tipo; }
    public void setTipo(TipoPieza tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }
    // Nota: Generalmente no se permite modificar el nombre (clave única), pero se incluye el setter por completitud.
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public String getUbicacionAlmacen() { return ubicacionAlmacen; }
    public void setUbicacionAlmacen(String ubicacionAlmacen) { this.ubicacionAlmacen = ubicacionAlmacen; }

    // Método toString para mostrar la información de la pieza
    @Override
    public String toString() {
        return String.format("Pieza [Nombre: %s, Tipo: %s, Precio: %.2f, Cantidad: %d, Ubicación: %s]",
                nombre, tipo, precioUnitario, cantidadDisponible, ubicacionAlmacen);
    }
}