public class Administrador extends Usuario {
    public Administrador(String idUsuario, String nombre, String contrasena) {
        super(idUsuario, nombre, contrasena);
    }

    @Override
    public String obtenerRol() {
        return "Administrador";
    }
}
