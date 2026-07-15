import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class BaristaForm extends javax.swing.JFrame {
    private final Barista barista;
    private final BaseDatosCafe baseDatos;
    private Pedido pedidoActual;

    public BaristaForm(Barista barista) {
        this.barista = barista;
        this.baseDatos = BaseDatosCafe.getInstancia();
        this.pedidoActual = baseDatos.crearPedido();
        initComponents();
        cargarProductos();
        refrescarPedido();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        pnlCliente = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        lblTipoDocumento = new javax.swing.JLabel();
        cboTipoDocumento = new javax.swing.JComboBox<>();
        txtCedula = new javax.swing.JTextField();
        pnlProductos = new javax.swing.JPanel();
        lblProducto = new javax.swing.JLabel();
        cboProductos = new javax.swing.JComboBox<>();
        lblCantidad = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        lblTamano = new javax.swing.JLabel();
        cboTamano = new javax.swing.JComboBox<>();
        lblLeche = new javax.swing.JLabel();
        cboLeche = new javax.swing.JComboBox<>();
        chkCalentado = new javax.swing.JCheckBox();
        btnAgregar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        pnlPedido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedido = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CafeGest - Barista");
        setResizable(false);

        pnlPrincipal.setBackground(new Color(248, 248, 248));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 14, 14, 14));

        lblTitulo.setFont(new Font("Segoe UI", 1, 24));
        lblTitulo.setText("Panel de Barista");
        lblSesion.setText("Sesion: " + barista.getNombre());
        btnCerrarSesion.setText("Volver al menu");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        pnlCliente.setBackground(Color.WHITE);
        pnlCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del cliente"));
        lblCliente.setText("Cliente:");
        lblTipoDocumento.setText("Documento:");
        cboTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "RUC" }));
        lblCedula.setText("Numero:");

        javax.swing.GroupLayout pnlClienteLayout = new javax.swing.GroupLayout(pnlCliente);
        pnlCliente.setLayout(pnlClienteLayout);
        pnlClienteLayout.setHorizontalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTipoDocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlClienteLayout.setVerticalGroup(
            pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipoDocumento)
                    .addComponent(cboTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlProductos.setBackground(Color.WHITE);
        pnlProductos.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));
        lblProducto.setText("Producto:");
        cboProductos.addActionListener(this::cboProductosActionPerformed);
        lblCantidad.setText("Cantidad:");
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        lblTamano.setText("Tamano:");
        cboTamano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pequeno", "mediano", "grande" }));
        lblLeche.setText("Leche:");
        cboLeche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "entera", "deslactosada", "almendra" }));
        chkCalentado.setText("Calentar alimento");
        btnAgregar.setText("Agregar al pedido");
        btnAgregar.addActionListener(this::btnAgregarActionPerformed);
        btnNuevo.setText("Nuevo pedido");
        btnNuevo.addActionListener(this::btnNuevoActionPerformed);
        btnFactura.setText("Confirmar y facturar");
        btnFactura.addActionListener(this::btnFacturaActionPerformed);
        btnHistorial.setText("Ver historial");
        btnHistorial.addActionListener(this::btnHistorialActionPerformed);

        javax.swing.GroupLayout pnlProductosLayout = new javax.swing.GroupLayout(pnlProductos);
        pnlProductos.setLayout(pnlProductosLayout);
        pnlProductosLayout.setHorizontalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblTamano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLeche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLeche, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCalentado)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistorial)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProductosLayout.setVerticalGroup(
            pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProducto)
                    .addComponent(cboProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad)
                    .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTamano)
                    .addComponent(cboTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLeche)
                    .addComponent(cboLeche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkCalentado)
                    .addComponent(btnAgregar)
                    .addComponent(btnFactura)
                    .addComponent(btnNuevo)
                    .addComponent(btnHistorial))
                .addContainerGap())
        );

        pnlPedido.setBackground(Color.WHITE);
        pnlPedido.setBorder(javax.swing.BorderFactory.createTitledBorder("Pedido actual"));
        tblPedido.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] { "Producto", "Cantidad", "Precio unit.", "Subtotal" }
        ) {
            final boolean[] canEdit = new boolean [] { false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPedido);
        lblEstado.setFont(new Font("Segoe UI", 1, 12));
        lblEstado.setText("Estado: Pendiente");
        lblTotal.setFont(new Font("Segoe UI", 1, 22));
        lblTotal.setText("Total: $0.00");

        javax.swing.GroupLayout pnlPedidoLayout = new javax.swing.GroupLayout(pnlPedido);
        pnlPedido.setLayout(pnlPedidoLayout);
        pnlPedidoLayout.setHorizontalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlPedidoLayout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotal)))
                .addContainerGap())
        );
        pnlPedidoLayout.setVerticalGroup(
            pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(lblTotal))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblSesion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSesion))
                    .addComponent(btnCerrarSesion))
                .addGap(18, 18, 18)
                .addComponent(pnlCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
        actualizarCamposPersonalizacion();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(ActionEvent evt) {
        Producto productoBase = (Producto) cboProductos.getSelectedItem();
        if (productoBase == null) {
            mostrarError("No hay productos disponibles.");
            return;
        }
        Producto productoPersonalizado = crearProductoPersonalizado(productoBase);
        pedidoActual.agregarDetalle(new DetallePedido(productoPersonalizado, (int) spnCantidad.getValue()));
        refrescarPedido();
    }

    private void btnFacturaActionPerformed(ActionEvent evt) {
        if (pedidoActual.getDetalles().isEmpty()) {
            mostrarError("Debe agregar al menos un producto al pedido.");
            return;
        }
        if (txtCliente.getText().trim().isEmpty()) {
            mostrarError("Debe ingresar el nombre del cliente.");
            return;
        }
        if (!validarDocumento()) {
            return;
        }
        pedidoActual.asignarCliente(txtCliente.getText(), txtCedula.getText());
        pedidoActual.confirmar();
        baseDatos.registrarVenta(pedidoActual);
        refrescarPedido();
        mostrarFactura();
        btnFactura.setEnabled(false);
    }

    private void btnNuevoActionPerformed(ActionEvent evt) {
        pedidoActual = baseDatos.crearPedido();
        txtCliente.setText("");
        txtCedula.setText("");
        cboTipoDocumento.setSelectedIndex(0);
        spnCantidad.setValue(1);
        btnFactura.setEnabled(true);
        refrescarPedido();
    }

    private void btnHistorialActionPerformed(ActionEvent evt) {
        new HistorialPedidosForm(baseDatos.getHistorialVentas()).setVisible(true);
    }

    private void btnCerrarSesionActionPerformed(ActionEvent evt) {
        new MenuSesionForm(barista).setVisible(true);
        dispose();
    }

    private void cboProductosActionPerformed(ActionEvent evt) {
        actualizarCamposPersonalizacion();
    }

    private void cargarProductos() {
        cboProductos.removeAllItems();
        for (Producto producto : baseDatos.listarProductos()) {
            cboProductos.addItem(producto);
        }
        actualizarCamposPersonalizacion();
    }

    private Producto crearProductoPersonalizado(Producto productoBase) {
        if (productoBase instanceof Bebida) {
            return new Bebida(productoBase.getId(), productoBase.getNombre(), productoBase.getPrecioBase(),
                    cboTamano.getSelectedItem().toString(), cboLeche.getSelectedItem().toString());
        }
        return new Alimento(productoBase.getId(), productoBase.getNombre(), productoBase.getPrecioBase(),
                chkCalentado.isSelected());
    }

    private void actualizarCamposPersonalizacion() {
        Producto producto = (Producto) cboProductos.getSelectedItem();
        boolean esBebida = producto instanceof Bebida;
        boolean esAlimento = producto instanceof Alimento;

        lblTamano.setVisible(esBebida);
        cboTamano.setVisible(esBebida);
        lblLeche.setVisible(esBebida);
        cboLeche.setVisible(esBebida);
        chkCalentado.setVisible(esAlimento);
    }

    private void refrescarPedido() {
        DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
        modelo.setRowCount(0);
        for (DetallePedido detalle : pedidoActual.getDetalles()) {
            modelo.addRow(new Object[] {
                detalle.getProducto().getNombre(),
                detalle.getCantidad(),
                "$" + String.format("%.2f", detalle.getProducto().calcularPrecioFinal()),
                "$" + String.format("%.2f", detalle.getSubtotal())
            });
        }
        lblEstado.setText("Estado: " + pedidoActual.getEstado());
        lblTotal.setText("Total: $" + String.format("%.2f", pedidoActual.calcularTotal()));
    }

    private void mostrarFactura() {
        JTextArea area = new JTextArea(generarTextoFactura());
        area.setEditable(false);
        area.setFont(new Font("Consolas", Font.PLAIN, 13));
        JOptionPane.showMessageDialog(this, area, "Factura", JOptionPane.INFORMATION_MESSAGE);
    }

    private String generarTextoFactura() {
        double subtotal = pedidoActual.calcularTotal();
        double iva = subtotal * 0.15;
        double total = subtotal + iva;
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        StringBuilder factura = new StringBuilder();
        factura.append("              CAFEGEST\n");
        factura.append("        RUC: 0999999999001\n");
        factura.append("   Sistema de Gestion para Cafeterias\n");
        factura.append("------------------------------------------\n");
        factura.append("Factura: ").append(pedidoActual.getIdPedido()).append("\n");
        factura.append("Fecha:   ").append(fecha).append("\n");
        factura.append("Cliente: ").append(txtCliente.getText().trim()).append("\n");
        factura.append("Ced/RUC: ").append(txtCedula.getText().trim().isEmpty() ? "Consumidor final" : txtCedula.getText().trim()).append("\n");
        factura.append("Barista: ").append(barista.getNombre()).append("\n");
        factura.append("------------------------------------------\n");
        factura.append(String.format("%-18s %4s %8s %8s%n", "Producto", "Cant", "P.Unit", "Subt."));
        for (DetallePedido detalle : pedidoActual.getDetalles()) {
            factura.append(String.format("%-18s %4d %8.2f %8.2f%n",
                    recortar(detalle.getProducto().getNombre(), 18),
                    detalle.getCantidad(),
                    detalle.getProducto().calcularPrecioFinal(),
                    detalle.getSubtotal()));
        }
        factura.append("------------------------------------------\n");
        factura.append(String.format("%32s %8.2f%n", "Subtotal:", subtotal));
        factura.append(String.format("%32s %8.2f%n", "IVA 15%:", iva));
        factura.append(String.format("%32s %8.2f%n", "TOTAL:", total));
        factura.append("------------------------------------------\n");
        factura.append("Gracias por su compra.\n");
        return factura.toString();
    }

    private String recortar(String texto, int maximo) {
        if (texto.length() <= maximo) {
            return texto;
        }
        return texto.substring(0, maximo - 1) + ".";
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validarDocumento() {
        String documento = txtCedula.getText().trim();
        String tipo = cboTipoDocumento.getSelectedItem().toString();
        int digitosEsperados = "Cedula".equals(tipo) ? 10 : 13;
        if (!documento.matches("\\d+")) {
            mostrarError("El numero de " + tipo.toLowerCase() + " solo debe contener digitos.");
            return false;
        }
        if (documento.length() != digitosEsperados) {
            mostrarError("La " + tipo.toLowerCase() + " debe tener exactamente " + digitosEsperados + " digitos.");
            return false;
        }
        return true;
    }

    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboLeche;
    private javax.swing.JComboBox<Producto> cboProductos;
    private javax.swing.JComboBox<String> cboTamano;
    private javax.swing.JComboBox<String> cboTipoDocumento;
    private javax.swing.JCheckBox chkCalentado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLeche;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTamano;
    private javax.swing.JLabel lblTipoDocumento;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlCliente;
    private javax.swing.JPanel pnlPedido;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblPedido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCliente;
}
