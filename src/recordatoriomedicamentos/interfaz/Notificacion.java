package recordatoriomedicamentos.interfaz;

import java.time.LocalDateTime;

public class Notificacion {
    private String mensaje;
    private String fechaHora;
    private boolean estado;
    private boolean notificacionesActivas;
    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.fechaHora = LocalDateTime.now().toString();
        this.estado = false;
        this.notificacionesActivas = true;
    }

    public void enviarNotificacion() {
        if (notificacionesActivas) {
            estado = true;
            System.out.println("Notificación enviada: " + mensaje);
        } else {
            System.out.println("Las notificaciones están desactivadas.");
        }
    }

    public void activarNotificaciones() {
        notificacionesActivas = true;
        System.out.println("Notificaciones activadas.");
    }

    public void desactivarNotificaciones() {
        notificacionesActivas = false;
        System.out.println("Notificaciones desactivadas.");
    }

    public void mostrarAlerta() {
        if (estado) {
            System.out.println("¡RECORDATORIO!");
            System.out.println(mensaje);
            System.out.println("Fecha y hora: " + fechaHora);
        }
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
}