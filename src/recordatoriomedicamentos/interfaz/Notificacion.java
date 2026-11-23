package recordatoriomedicamentos.interfaz;

public class Notificacion {

    private String mensaje;
    private String fechaHora;
    private boolean estado;
    private boolean notificacionesActivas;

    public Notificacion(String mensaje) {
        this.estado = false;
        this.notificacionesActivas = false;

        if (mensaje != null && !mensaje.trim().isEmpty()) {
            this.mensaje = mensaje;
        }
    }

    public boolean enviarNotificacion() {
        if (mensaje != null && !mensaje.trim().isEmpty()
                && notificacionesActivas) {
            estado = true;
            return true;
        }
        return false;
    }

    public void activarNotificaciones() {
        notificacionesActivas = true;
    }

    public void desactivarNotificaciones() {
        notificacionesActivas = false;
        estado = false;
    }

    public String mostrarAlerta() {
        if (estado) {
            return mensaje;
        }
        return "No hay una notificación activa.";
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public boolean isEstado() {
        return estado;
    }

    public boolean isNotificacionesActivas() {
        return notificacionesActivas;
    }

    public void setMensaje(String mensaje) {
        if (mensaje != null && !mensaje.trim().isEmpty()) {
            this.mensaje = mensaje;
        }
    }

    public void setFechaHora(String fechaHora) {
        if (fechaHora != null && !fechaHora.trim().isEmpty()) {
            this.fechaHora = fechaHora;
        }
    }
}