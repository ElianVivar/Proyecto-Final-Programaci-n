import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MenuCafe {
    private final List<Producto> productos;

    public MenuCafe() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> listarProductos() {
        return Collections.unmodifiableList(productos);
    }

    public void registrarProducto(Usuario usuario, Producto producto) {
        validarAdministrador(usuario);
        productos.add(producto);
    }

    public void modificarProducto(Usuario usuario, String id, String nuevoNombre, double nuevoPrecioBase) {
        validarAdministrador(usuario);
        Producto producto = buscarProducto(id);
        producto.setNombre(nuevoNombre);
        producto.setPrecioBase(nuevoPrecioBase);
    }

    public boolean eliminarProducto(Usuario usuario, String id) {
        validarAdministrador(usuario);
        Iterator<Producto> iterator = productos.iterator();
        while (iterator.hasNext()) {
            Producto producto = iterator.next();
            if (producto.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Producto buscarProducto(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        throw new IllegalArgumentException("No existe un producto con id: " + id);
    }

    private void validarAdministrador(Usuario usuario) {
        if (!(usuario instanceof Administrador)) {
            throw new SecurityException("Solo un administrador puede configurar el menu.");
        }
    }
}
