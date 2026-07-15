import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminForm extends javax.swing.JFrame {
    private final Administrador administrador;
    private final BaseDatosCafe baseDatos;

    public AdminForm(Administrador administrador) {
        this.administrador = administrador;
        this.baseDatos = BaseDatosCafe.getInstancia();
        initComponents();
        refrescarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSesion = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        pnlFormulario = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblTipo = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        lblTamano = new javax.swing.JLabel();
        cboTamano = new javax.swing.JComboBox<>();
        lblLeche = new javax.swing.JLabel();
        cboLeche = new javax.swing.JComboBox<>();
        chkCalentado = new javax.swing.JCheckBox();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pnlTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CafeGest - Administrador");
        setResizable(false);

        pnlPrincipal.setBackground(new Color(248, 248, 248));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 14, 14, 14));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitulo.setText("Panel de Administrador");
        lblSesion.setText("Sesion: " + administrador.getNombre());

        btnCerrarSesion.setText("Volver al menu");
        btnCerrarSesion.addActionListener(this::btnCerrarSesionActionPerformed);

        pnlFormulario.setBackground(Color.WHITE);
        pnlFormulario.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        lblId.setText("ID:");
        lblNombre.setText("Nombre:");
        lblPrecio.setText("Precio base:");
        lblTipo.setText("Tipo:");
        cboTipo.setModel(new DefaultComboBoxModel<>(new String[] { "Bebida", "Alimento" }));
        cboTipo.addActionListener(this::cboTipoActionPerformed);
        lblTamano.setText("Tamano:");
        cboTamano.setModel(new DefaultComboBoxModel<>(new String[] { "pequeno", "mediano", "grande" }));
        lblLeche.setText("Leche:");
        cboLeche.setModel(new DefaultComboBoxModel<>(new String[] { "entera", "deslactosada", "almendra" }));
        chkCalentado.setText("Requiere calentado");
        ocultarCamposPersonalizacion();

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this::btnRegistrarActionPerformed);
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(this::btnModificarActionPerformed);
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);

        javax.swing.GroupLayout pnlFormularioLayout = new javax.swing.GroupLayout(pnlFormulario);
        pnlFormulario.setLayout(pnlFormularioLayout);
        pnlFormularioLayout.setHorizontalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addComponent(lblNombre)
                    .addComponent(lblPrecio)
                    .addComponent(lblTipo)
                    .addComponent(lblTamano)
                    .addComponent(lblLeche))
                .addGap(20, 20, 20)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId)
                    .addComponent(txtNombre)
                    .addComponent(txtPrecio)
                    .addComponent(cboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboTamano, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboLeche, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkCalentado)
                    .addGroup(pnlFormularioLayout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlFormularioLayout.setVerticalGroup(
            pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTamano)
                    .addComponent(cboTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLeche)
                    .addComponent(cboLeche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkCalentado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTabla.setBackground(Color.WHITE);
        pnlTabla.setBorder(javax.swing.BorderFactory.createTitledBorder("Base de datos de productos"));

        tblProductos.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] { "ID", "Nombre", "Tipo", "Precio base", "Precio final" }
        ) {
            final boolean[] canEdit = new boolean [] { false, false, false, false, false };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        javax.swing.GroupLayout pnlTablaLayout = new javax.swing.GroupLayout(pnlTabla);
        pnlTabla.setLayout(pnlTablaLayout);
        pnlTablaLayout.setHorizontalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnlTablaLayout.setVerticalGroup(
            pnlTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(lblSesion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                        .addComponent(btnCerrarSesion))
                    .addGroup(pnlPrincipalLayout.createSequentialGroup()
                        .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(ActionEvent evt) {
        try {
            baseDatos.registrarProducto(crearProductoDesdeFormulario());
            limpiarFormulario();
            refrescarTabla();
        } catch (RuntimeException error) {
            mostrarError(error.getMessage());
        }
    }

    private void btnModificarActionPerformed(ActionEvent evt) {
        try {
            baseDatos.modificarProducto(txtId.getText().trim(), txtNombre.getText().trim(),
                    Double.parseDouble(txtPrecio.getText().trim()));
            limpiarFormulario();
            refrescarTabla();
        } catch (RuntimeException error) {
            mostrarError(error.getMessage());
        }
    }

    private void btnEliminarActionPerformed(ActionEvent evt) {
        try {
            if (baseDatos.eliminarProducto(txtId.getText().trim())) {
                limpiarFormulario();
                refrescarTabla();
            }
        } catch (RuntimeException error) {
            mostrarError(error.getMessage());
        }
    }

    private void btnLimpiarActionPerformed(ActionEvent evt) {
        limpiarFormulario();
    }

    private void btnCerrarSesionActionPerformed(ActionEvent evt) {
        new MenuSesionForm(administrador).setVisible(true);
        dispose();
    }

    private void cboTipoActionPerformed(ActionEvent evt) {
        ocultarCamposPersonalizacion();
    }

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tblProductos.getSelectedRow();
        if (fila < 0) {
            return;
        }
        Producto producto = baseDatos.buscarProducto(tblProductos.getValueAt(fila, 0).toString());
        txtId.setText(producto.getId());
        txtNombre.setText(producto.getNombre());
        txtPrecio.setText(String.format("%.2f", producto.getPrecioBase()).replace(",", "."));
        if (producto instanceof Bebida) {
            cboTipo.setSelectedItem("Bebida");
        } else {
            cboTipo.setSelectedItem("Alimento");
        }
    }

    private Producto crearProductoDesdeFormulario() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        double precio = Double.parseDouble(txtPrecio.getText().trim());
        if (id.isEmpty() || nombre.isEmpty()) {
            throw new IllegalArgumentException("Debe completar ID y nombre.");
        }
        if ("Bebida".equals(cboTipo.getSelectedItem())) {
            return new Bebida(id, nombre, precio, "pequeno", "entera");
        }
        return new Alimento(id, nombre, precio, false);
    }

    private void refrescarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
        modelo.setRowCount(0);
        for (Producto producto : baseDatos.listarProductos()) {
            modelo.addRow(new Object[] {
                producto.getId(),
                producto.getNombre(),
                producto instanceof Bebida ? "Bebida" : "Alimento",
                "$" + String.format("%.2f", producto.getPrecioBase()),
                "$" + String.format("%.2f", producto.calcularPrecioFinal())
            });
        }
    }

    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        cboTipo.setSelectedIndex(0);
        cboTamano.setSelectedIndex(0);
        cboLeche.setSelectedIndex(0);
        chkCalentado.setSelected(false);
        ocultarCamposPersonalizacion();
    }

    private void ocultarCamposPersonalizacion() {
        lblTamano.setVisible(false);
        cboTamano.setVisible(false);
        lblLeche.setVisible(false);
        cboLeche.setVisible(false);
        chkCalentado.setVisible(false);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cboLeche;
    private javax.swing.JComboBox<String> cboTamano;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JCheckBox chkCalentado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblLeche;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSesion;
    private javax.swing.JLabel lblTamano;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlFormulario;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlTabla;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
}
