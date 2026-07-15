import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Menu principal mostrado despues de autenticar al usuario. */
public class MenuSesionForm extends JFrame {
    private final Usuario usuario;

    public MenuSesionForm(Usuario usuario) {
        this.usuario = usuario;
        setTitle("CafeGest - Menu principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 310);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel principal = new JPanel(new BorderLayout(12, 12));
        principal.setBackground(new Color(248, 248, 248));
        principal.setBorder(BorderFactory.createEmptyBorder(22, 22, 22, 22));
        JLabel bienvenida = new JLabel("Bienvenido, " + usuario.getNombre());
        bienvenida.setFont(new Font("Segoe UI", Font.BOLD, 25));
        JLabel rol = new JLabel("Sesion: " + usuario.obtenerRol());
        JPanel encabezado = new JPanel(new GridLayout(2, 1));
        encabezado.setOpaque(false); encabezado.add(bienvenida); encabezado.add(rol);
        principal.add(encabezado, BorderLayout.NORTH);

        JPanel opciones = new JPanel(new GridLayout(0, 1, 0, 10));
        opciones.setOpaque(false);
        if (usuario instanceof Administrador) {
            JButton productos = new JButton("Administrar productos");
            productos.addActionListener(e -> abrirAdministrador());
            opciones.add(productos);
        } else if (usuario instanceof Barista) {
            JButton pedidos = new JButton("Crear pedido / Facturar");
            pedidos.addActionListener(e -> abrirBarista());
            opciones.add(pedidos);
        }
        JButton historial = new JButton("Consultar historial de pedidos");
        historial.addActionListener(e -> new HistorialPedidosForm(BaseDatosCafe.getInstancia().getHistorialVentas()).setVisible(true));
        JButton cerrar = new JButton("Cerrar sesion");
        cerrar.addActionListener(e -> { new LoginForm().setVisible(true); dispose(); });
        opciones.add(historial); opciones.add(cerrar);
        principal.add(opciones, BorderLayout.CENTER);
        setContentPane(principal);
    }

    private void abrirAdministrador() {
        new AdminForm((Administrador) usuario).setVisible(true);
        dispose();
    }
    private void abrirBarista() {
        new BaristaForm((Barista) usuario).setVisible(true);
        dispose();
    }
}
