package recordatoriomedicamentos.negocio;

public class RecuperacionContrasena {

    private String idRecuperacion;
    private String nombreUsuario;
    private String nuevaContrasena;
    private boolean solicitud;

    public RecuperacionContrasena(String idRecuperacion, String fechaSolicitud) {
        if (idRecuperacion != null && !idRecuperacion.trim().isEmpty()) {
            this.idRecuperacion = idRecuperacion;
        }
        this.solicitud = false;
    }

    public void solicitarRecuperacion() {
        solicitud = true;
    }

    public boolean verificarSolicitud() {
        return solicitud;
    }

    public void actualizarContrasena() {

        if (nuevaContrasena != null && !nuevaContrasena.trim().isEmpty()) {
            solicitud = false;
        }
    }

    public String getIdRecuperacion() {
        return idRecuperacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            this.nombreUsuario = nombreUsuario;
        }
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        if (nuevaContrasena != null && !nuevaContrasena.trim().isEmpty()) {
            this.nuevaContrasena = nuevaContrasena;
        }
    }

    public boolean isSolicitud() {
        return solicitud;
    }
}