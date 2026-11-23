package recordatoriomedicamentos.negocio;

public class Sesion {

    private String nombreUsuario;
    private String fechaInicio;
    private boolean estado;

    public Sesion(String fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.estado = false;
    }

    public void iniciarSesion() {
        estado = true;
    }

    public void cerrarSesion() {
        estado = false;
    }

    public boolean verificarSesion() {
        return estado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public boolean isEstado() {
        return estado;
    }
}