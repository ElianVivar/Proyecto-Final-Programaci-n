public abstract class Producto {
    private final String id;
    private String nombre;
    private double precioBase;

    public Producto(String id, String nombre, double precioBase) {
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        return id + " - " + nombre + " ($" + String.format("%.2f", calcularPrecioFinal()) + ")";
    }
}
