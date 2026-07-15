public class Alimento extends Producto {
    private boolean requiereCalentado;

    public Alimento(String id, String nombre, double precioBase, boolean requiereCalentado) {
        super(id, nombre, precioBase);
        this.requiereCalentado = requiereCalentado;
    }

    public boolean isRequiereCalentado() {
        return requiereCalentado;
    }

    public void setRequiereCalentado(boolean requiereCalentado) {
        this.requiereCalentado = requiereCalentado;
    }

    @Override
    public double calcularPrecioFinal() {
        if (requiereCalentado) {
            return getPrecioBase() + 0.30;
        }
        return getPrecioBase();
    }
}
