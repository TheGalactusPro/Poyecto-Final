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
        solicitud = false;
    }

    public boolean solicitarRecuperacion() {
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            solicitud = true;
            return true;
        }
        return false;
    }

    public boolean verificarSolicitud() {
        return solicitud;
    }

    public boolean actualizarContrasena() {
        if (solicitud && nuevaContrasena != null
                && !nuevaContrasena.trim().isEmpty()) {
            solicitud = false;
            return true;
        }

        return false;
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