import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseDatosCafe {
    private static final Path RUTA_USUARIOS = Paths.get("database", "usuarios.csv");
    private static final Path RUTA_PRODUCTOS = Paths.get("database", "productos.csv");
    private static final BaseDatosCafe INSTANCIA = new BaseDatosCafe();

    private final List<Usuario> usuarios;
    private final List<Producto> productos;
    private int contadorPedidos;

    private final HistorialVentas historialVentas = new HistorialVentas();

    private BaseDatosCafe() {
        usuarios = new ArrayList<>();
        productos = new ArrayList<>();
        contadorPedidos = 1;
        prepararArchivosBaseDatos();
        cargarUsuariosDesdeArchivo();
        cargarProductosDesdeArchivo();
    }



    public static BaseDatosCafe getInstancia() {
        return INSTANCIA;
    }

    private void prepararArchivosBaseDatos() {
        try {
            Files.createDirectories(RUTA_PRODUCTOS.getParent());
            if (!Files.exists(RUTA_USUARIOS)) {
                Files.write(RUTA_USUARIOS, Arrays.asList(
                        "rol,id,nombre,contrasena",
                        "ADMIN,admin,David Paredes,admin123",
                        "BARISTA,barista,Elián Vivar,barista123"));
            }
            if (!Files.exists(RUTA_PRODUCTOS)) {
                Files.write(RUTA_PRODUCTOS, Arrays.asList(
                        "tipo,id,nombre,precioBase,tamano,tipoLeche,requiereCalentado",
                        "BEBIDA,B001,Capuccino,2.50,grande,almendra,false",
                        "BEBIDA,B002,Latte,2.25,mediano,entera,false",
                        "BEBIDA,B003,Cafe Americano,1.50,pequeno,entera,false",
                        "BEBIDA,B004,Mocaccino,2.80,grande,deslactosada,false",
                        "ALIMENTO,A001,Croissant,1.75,,,true",
                        "ALIMENTO,A002,Sanduche de jamon,2.50,,,true",
                        "ALIMENTO,A003,Cheesecake,2.20,,,false"));
            }
        } catch (IOException error) {
            throw new IllegalStateException("No se pudo preparar la base de datos local.", error);
        }
    }

    private void cargarUsuariosDesdeArchivo() {
        try {
            List<String> lineas = Files.readAllLines(RUTA_USUARIOS);
            for (int i = 1; i < lineas.size(); i++) {
                String[] datos = lineas.get(i).split(",", -1);
                if (datos.length < 4) {
                    continue;
                }
                if ("ADMIN".equalsIgnoreCase(datos[0])) {
                    usuarios.add(new Administrador(datos[1], datos[2], datos[3]));
                } else if ("BARISTA".equalsIgnoreCase(datos[0])) {
                    usuarios.add(new Barista(datos[1], datos[2], datos[3]));
                }
            }
        } catch (IOException error) {
            throw new IllegalStateException("No se pudo leer usuarios.csv.", error);
        }
    }

    private void cargarProductosDesdeArchivo() {
        try {
            List<String> lineas = Files.readAllLines(RUTA_PRODUCTOS);
            for (int i = 1; i < lineas.size(); i++) {
                String[] datos = lineas.get(i).split(",", -1);
                if (datos.length < 7) {
                    continue;
                }
                String tipo = datos[0];
                String id = datos[1];
                String nombre = datos[2];
                double precio = Double.parseDouble(datos[3]);
                if ("BEBIDA".equalsIgnoreCase(tipo)) {
                    productos.add(new Bebida(id, nombre, precio, datos[4], datos[5]));
                } else if ("ALIMENTO".equalsIgnoreCase(tipo)) {
                    productos.add(new Alimento(id, nombre, precio, Boolean.parseBoolean(datos[6])));
                }
            }
        } catch (IOException error) {
            throw new IllegalStateException("No se pudo leer productos.csv.", error);
        }
    }

    public Usuario autenticar(String idUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equalsIgnoreCase(idUsuario.trim()) && usuario.iniciarSesion(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Producto> listarProductos() {
        return Collections.unmodifiableList(productos);
    }

    public void registrarProducto(Producto producto) {
        if (buscarProductoONull(producto.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un producto con ese ID.");
        }
        productos.add(producto);
        guardarProductos();
    }

    public void modificarProducto(String id, String nombre, double precioBase) {
        Producto producto = buscarProducto(id);
        producto.setNombre(nombre);
        producto.setPrecioBase(precioBase);
        guardarProductos();
    }

    public boolean eliminarProducto(String id) {
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId().equalsIgnoreCase(id)) {
                iterator.remove();
                guardarProductos();
                return true;
            }
        }
        return false;
    }

    public Producto buscarProducto(String id) {
        Producto producto = buscarProductoONull(id);
        if (producto == null) {
            throw new IllegalArgumentException("No existe un producto con id: " + id);
        }
        return producto;
    }

    private Producto buscarProductoONull(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equalsIgnoreCase(id.trim())) {
                return producto;
            }
        }
        return null;
    }

    public Pedido crearPedido() {
        String id = String.format("P%04d", contadorPedidos++);
        return new Pedido(id);
    }

    public void registrarVenta(Pedido pedido) {
        historialVentas.registrarVenta(pedido);
    }

    public HistorialVentas getHistorialVentas() {
        return historialVentas;
    }

    private void guardarProductos() {
        List<String> lineas = new ArrayList<>();
        lineas.add("tipo,id,nombre,precioBase,tamano,tipoLeche,requiereCalentado");
        for (Producto producto : productos) {
            if (producto instanceof Bebida) {
                Bebida bebida = (Bebida) producto;
                lineas.add(String.join(",",
                        "BEBIDA",
                        bebida.getId(),
                        bebida.getNombre(),
                        String.format(java.util.Locale.US, "%.2f", bebida.getPrecioBase()),
                        bebida.getTamano(),
                        bebida.getTipoLeche(),
                        "false"));
            } else if (producto instanceof Alimento) {
                Alimento alimento = (Alimento) producto;
                lineas.add(String.join(",",
                        "ALIMENTO",
                        alimento.getId(),
                        alimento.getNombre(),
                        String.format(java.util.Locale.US, "%.2f", alimento.getPrecioBase()),
                        "",
                        "",
                        Boolean.toString(alimento.isRequiereCalentado())));
            }
        }

        try {
            Files.write(RUTA_PRODUCTOS, lineas);
        } catch (IOException error) {
            throw new IllegalStateException("No se pudo guardar productos.csv.", error);
        }
    }
}
