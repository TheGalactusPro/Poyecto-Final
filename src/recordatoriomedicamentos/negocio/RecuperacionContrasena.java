package recordatoriomedicamentos.negocio;

import recordatoriomedicamentos.modelo.Usuario;

public class RecuperacionContrasena {
    private String idRecuperacion;
    private String nombreUsuario;
    private String nuevaContrasena;
    private boolean solicitud;

    public RecuperacionContrasena(String idRecuperacion, String fechaSolicitud) {
        this.idRecuperacion = idRecuperacion;
        this.solicitud = false;
    }

    public void solicitarRecuperacion() {
        solicitud = true;
    }

    public boolean verificarSolicitud() {
        return solicitud;
    }

    public void actualizarContrasena(Usuario usuario) {
        if (usuario != null
                && nombreUsuario != null
                && !nombreUsuario.trim().isEmpty()
                && nuevaContrasena != null
                && !nuevaContrasena.trim().isEmpty()
                && solicitud) {
            usuario.setNombreUsuario(nombreUsuario);
            usuario.cambiarContrasena(nuevaContrasena);
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
        this.nombreUsuario = nombreUsuario;
    }

    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    public void setNuevaContrasena(String nuevaContrasena) {
        this.nuevaContrasena = nuevaContrasena;
    }
}