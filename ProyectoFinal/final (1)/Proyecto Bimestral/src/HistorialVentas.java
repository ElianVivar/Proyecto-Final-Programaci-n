import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistorialVentas {

    private final List<Pedido> historial;

    public HistorialVentas() {
        historial = new ArrayList<>();
    }



    public void registrarVenta(Pedido pedido) {
        if (pedido != null) {
            historial.add(pedido);
        }
    }

    public List<Pedido> obtenerHistorial() {
        return Collections.unmodifiableList(historial);
    }


    public Pedido buscarPedido(String idPedido) {

        for (Pedido pedido : historial) {
            if (pedido.getIdPedido().equals(idPedido)) {
                return pedido;
            }
        }

        return null;
    }


    public int cantidadVentas() {
        return historial.size();
    }

    public double calcularIngresos() {

        double total = 0;

        for (Pedido pedido : historial) {
            total += pedido.getTotal();
        }

        return total;
    }

    public void mostrarHistorial() {

        if (historial.isEmpty()) {
            System.out.println("\nNo existen ventas registradas.");
            return;
        }

        System.out.println("\n--Historial de ventas--");

        for (Pedido pedido : historial) {

            System.out.println("----------------------------------------");
            System.out.println("Pedido: " + pedido.getIdPedido());
            System.out.println("Estado: " + pedido.getEstado());

            for (DetallePedido detalle : pedido.getDetalles()) {
                System.out.println(detalle);
            }

            System.out.printf("TOTAL: $%.2f%n", pedido.getTotal());
        }

        System.out.println("----------------------------------------");
        System.out.println("Cantidad de ventas: " + cantidadVentas());
        System.out.printf("Ingresos Totales: $%.2f%n", calcularIngresos());
    }

    public void limpiarHistorial() {
        historial.clear();
    }
}