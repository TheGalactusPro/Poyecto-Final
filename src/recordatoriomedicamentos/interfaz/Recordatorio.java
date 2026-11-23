package recordatoriomedicamentos.interfaz;

import java.util.ArrayList;

public class Recordatorio {

    private String nombreTratamiento;
    private String horaProgramada;
    private String frecuencia;
    private boolean estado;
    private ArrayList<Notificacion> notificaciones;

    public Recordatorio(String nombreTratamiento, String horaProgramada, String frecuencia) {
        this.nombreTratamiento = nombreTratamiento;
        this.horaProgramada = horaProgramada;
        this.frecuencia = frecuencia;
        this.estado = true;
        this.notificaciones = new ArrayList<>();
    }

    public void generarRecordatorio() {
        if (estado) {
            System.out.println("Recordatorio generado para "
                    + nombreTratamiento + " a las " + horaProgramada);
        }
    }

    public void programarRecordatorio() {
        estado = true;
        System.out.println("Recordatorio programado correctamente.");
    }

    public void cancelarRecordatorio() {
        estado = false;
        System.out.println("Recordatorio cancelado.");
    }

    public void verificarEstado() {
        System.out.println("Estado: " + (estado ? "Activo" : "Inactivo"));
    }

    public void consultarNotificaciones() {
        for (Notificacion notificacion : notificaciones) {
            System.out.println(notificacion.getMensaje());
            System.out.println(notificacion.getFechaHora());
        }
    }

    public void agregarNotificacion(Notificacion notificacion) {
        if (notificacion != null) {
            notificaciones.add(notificacion);
        }
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public String getHoraProgramada() {
        return horaProgramada;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }
}