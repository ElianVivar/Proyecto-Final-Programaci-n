import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDateTime;

public class Pedido {
    private final String idPedido;
    private String estado;
    private double total;
    private final List<DetallePedido> detalles;
    private String cliente = "Consumidor final";
    private String cedulaRuc = "";
    private LocalDateTime fechaConfirmacion;

    public Pedido(String idPedido) {
        this.idPedido = idPedido;
        this.estado = "Pendiente";
        this.detalles = new ArrayList<>();
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public List<DetallePedido> getDetalles() {
        return Collections.unmodifiableList(detalles);
    }

    public String getCliente() { return cliente; }

    public String getCedulaRuc() { return cedulaRuc; }

    public LocalDateTime getFechaConfirmacion() { return fechaConfirmacion; }

    public void asignarCliente(String cliente, String cedulaRuc) {
        this.cliente = cliente == null || cliente.trim().isEmpty() ? "Consumidor final" : cliente.trim();
        this.cedulaRuc = cedulaRuc == null ? "" : cedulaRuc.trim();
    }

    public void agregarDetalle(DetallePedido detalle) {
        detalles.add(detalle);
        total = calcularTotal();
    }

    public double calcularTotal() {
        double suma = 0;
        for (DetallePedido detalle : detalles) {
            suma += detalle.calcularSubtotal();
        }
        return suma;
    }

    public void confirmar() {
        total = calcularTotal();
        estado = "Confirmado";
        fechaConfirmacion = LocalDateTime.now();
    }
}
