public class Barista extends Usuario {
    public Barista(String idUsuario, String nombre, String contrasena) {
        super(idUsuario, nombre, contrasena);
    }

    @Override
    public String obtenerRol() {
        return "Barista";
    }
}
