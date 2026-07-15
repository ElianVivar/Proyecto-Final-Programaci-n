public abstract class Usuario {
    private final String idUsuario;
    private String nombre;
    private String contrasena;

    public Usuario(String idUsuario, String nombre, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean iniciarSesion(String input) {
        return contrasena.equals(input);
    }

    public void cambiarContrasena(String contrasenaActual, String nuevaContrasena) {
        if (!iniciarSesion(contrasenaActual)) {
            throw new SecurityException("La contrasena actual es incorrecta.");
        }
        this.contrasena = nuevaContrasena;
    }

    public abstract String obtenerRol();
}
