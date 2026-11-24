package recordatoriomedicamentos.modelo;

public class Sesion {

    // Atributos
    private String nombreUsuario;
    private String fechaInicio;
    private boolean estado;

    // Constructor
    public Sesion(String fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.estado = false;
    }

    // Métodos
    public void iniciarSesion() {
        estado = true;
        System.out.println("Sesión iniciada correctamente.");
    }

    public void cerrarSesion() {
        estado = false;
        System.out.println("Sesión cerrada correctamente.");
    }

    public boolean verificarSesion() {
        return estado;
    }

    // Getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}