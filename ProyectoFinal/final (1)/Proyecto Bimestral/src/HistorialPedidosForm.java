import java.awt.Color;
import java.awt.event.ActionEvent;
import java.time.format.DateTimeFormatter;
import javax.swing.table.DefaultTableModel;

/** Ventana de consulta de los pedidos confirmados durante la sesion. */
public class HistorialPedidosForm extends javax.swing.JFrame {
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final HistorialVentas historial;

    public HistorialPedidosForm(HistorialVentas historial) {
        this.historial = historial;
        initComponents();
        cargarHistorial();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlPedidos = new javax.swing.JPanel();
        spPedidos = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        pnlDetalle = new javax.swing.JPanel();
        spDetalle = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        lblResumen = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CafeGest - Historial de pedidos");
        setResizable(false);

        pnlPrincipal.setBackground(new Color(248, 248, 248));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 14, 14, 14));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitulo.setText("Historial de pedidos");

        pnlPedidos.setBackground(Color.WHITE);
        pnlPedidos.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedidos confirmados"));

        tblPedidos.setModel(crearModelo(new String[] { "N. pedido", "Fecha", "Cliente", "Cedula/RUC", "Estado", "Total" }));
        tblPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPedidos.getSelectionModel().addListSelectionListener(evt -> {
            if (!evt.getValueIsAdjusting()) {
                mostrarDetalle(tblPedidos.getSelectedRow());
            }
        });
        spPedidos.setViewportView(tblPedidos);

        javax.swing.GroupLayout pnlPedidosLayout = new javax.swing.GroupLayout(pnlPedidos);
        pnlPedidos.setLayout(pnlPedidosLayout);
        pnlPedidosLayout.setHorizontalGroup(
            pnlPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spPedidos)
                .addContainerGap())
        );
        pnlPedidosLayout.setVerticalGroup(
            pnlPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlDetalle.setBackground(Color.WHITE);
        pnlDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del pedido seleccionado"));

        tblDetalle.setModel(crearModelo(new String[] { "Producto", "Cantidad", "Precio unit.", "Subtotal" }));
        spDetalle.setViewportView(tblDetalle);

        javax.swing.GroupLayout pnlDetalleLayout = new javax.swing.GroupLayout(pnlDetalle);
        pnlDetalle.setLayout(pnlDetalleLayout);
        pnlDetalleLayout.setHorizontalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spDetalle)
                .addContainerGap())
        );
        pnlDetalleLayout.setVerticalGroup(
            pnlDetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblResumen.setFont(new java.awt.Font("Segoe UI", 1, 13));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(this::btnCerrarActionPerformed);

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo)
            .addComponent(pnlPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(lblResumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResumen)
                    .addComponent(btnActualizar)
                    .addComponent(btnCerrar))
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(ActionEvent evt) {
        cargarHistorial();
    }

    private void btnCerrarActionPerformed(ActionEvent evt) {
        dispose();
    }

    private DefaultTableModel crearModelo(String[] columnas) {
        return new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
    }

    private void cargarHistorial() {
        DefaultTableModel modeloPedidos = (DefaultTableModel) tblPedidos.getModel();
        DefaultTableModel modeloDetalle = (DefaultTableModel) tblDetalle.getModel();
        modeloPedidos.setRowCount(0);
        modeloDetalle.setRowCount(0);
        for (Pedido pedido : historial.obtenerHistorial()) {
            String fecha = pedido.getFechaConfirmacion() == null ? "-" : FORMATO_FECHA.format(pedido.getFechaConfirmacion());
            modeloPedidos.addRow(new Object[] { pedido.getIdPedido(), fecha, pedido.getCliente(), pedido.getCedulaRuc(), pedido.getEstado(), String.format("$%.2f", pedido.getTotal()) });
        }
        lblResumen.setText("Pedidos: " + historial.cantidadVentas() + "    Ingresos: $" + String.format("%.2f", historial.calcularIngresos()));
    }

    private void mostrarDetalle(int fila) {
        DefaultTableModel modeloDetalle = (DefaultTableModel) tblDetalle.getModel();
        modeloDetalle.setRowCount(0);
        if (fila < 0 || fila >= historial.obtenerHistorial().size()) {
            return;
        }
        Pedido pedido = historial.obtenerHistorial().get(fila);
        for (DetallePedido detalle : pedido.getDetalles()) {
            modeloDetalle.addRow(new Object[] { detalle.getProducto().getNombre(), detalle.getCantidad(), String.format("$%.2f", detalle.getProducto().calcularPrecioFinal()), String.format("$%.2f", detalle.getSubtotal()) });
        }
    }

    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel lblResumen;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDetalle;
    private javax.swing.JPanel pnlPedidos;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JScrollPane spDetalle;
    private javax.swing.JScrollPane spPedidos;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblPedidos;
}
