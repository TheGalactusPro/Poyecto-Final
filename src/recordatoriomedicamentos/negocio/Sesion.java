package recordatoriomedicamentos.negocio;

public class Sesion {

    private String nombreUsuario;
    private String fechaInicio;
    private boolean estado;

    public Sesion(String fechaInicio) {
        if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            this.fechaInicio = fechaInicio;
        }
        estado = false;
    }

    public boolean iniciarSesion() {
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()
                && fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            estado = true;
            return true;
        }
        return false;
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
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            this.nombreUsuario = nombreUsuario;
        }
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            this.fechaInicio = fechaInicio;
        }
    }

    public boolean isEstado() {
        return estado;
    }
}