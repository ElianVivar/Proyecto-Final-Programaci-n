import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {
    private final BaseDatosCafe baseDatos;

    public LoginForm() {
        baseDatos = BaseDatosCafe.getInstancia();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        pnlPrincipal = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        lblCredenciales = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CafeGest - Inicio de sesion");
        setResizable(false);

        pnlPrincipal.setBackground(new Color(245, 245, 245));
        pnlPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(18, 18, 18, 18));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 28));
        lblTitulo.setText("CafeGest");

        lblSubtitulo.setText("Sistema integral de gestion y pedidos para cafeterias");

        pnlLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio de sesion"));
        pnlLogin.setBackground(Color.WHITE);

        lblUsuario.setText("Usuario:");
        lblContrasena.setText("Contrasena:");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(this::btnIngresarActionPerformed);

        lblCredenciales.setText("Admin: admin / admin123    Barista: barista / barista123");

        javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
        pnlLogin.setLayout(pnlLoginLayout);
        pnlLoginLayout.setHorizontalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCredenciales)
                    .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnIngresar)
                        .addGroup(pnlLoginLayout.createSequentialGroup()
                            .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblUsuario)
                                .addComponent(lblContrasena))
                            .addGap(22, 22, 22)
                            .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsuario)
                                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlLoginLayout.setVerticalGroup(
            pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIngresar)
                .addGap(18, 18, 18)
                .addComponent(lblCredenciales)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(lblSubtitulo))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitulo)
                .addGap(18, 18, 18)
                .addComponent(pnlLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlPrincipal);
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(ActionEvent evt) {
        Usuario usuario = baseDatos.autenticar(txtUsuario.getText(), new String(txtContrasena.getPassword()));
        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Usuario o contrasena incorrectos.", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        new MenuSesionForm(usuario).setVisible(true);
        dispose();
    }

    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblCredenciales;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
}
