public class DetallePedido {
    private final Producto producto;
    private int cantidad;
    private double subtotal;

    public DetallePedido(Producto producto, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double calcularSubtotal() {
        return producto.calcularPrecioFinal() * cantidad;
    }

    @Override
    public String toString() {
        return cantidad + " x " + producto.getNombre() + " = $" + String.format("%.2f", subtotal);
    }
}
