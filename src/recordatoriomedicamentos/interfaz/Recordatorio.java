package recordatoriomedicamentos.interfaz;

import java.util.ArrayList;

public class Recordatorio {

    private String nombreTratamiento;
    private String horaProgramada;
    private String frecuencia;
    private boolean estado;
    private ArrayList<Notificacion> notificaciones;

    public Recordatorio(String nombreTratamiento, String horaProgramada, String frecuencia) {
        this.notificaciones = new ArrayList<>();
        this.estado = false;

        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()) {
            this.nombreTratamiento = nombreTratamiento;
        }

        if (horaProgramada != null && !horaProgramada.trim().isEmpty()) {
            this.horaProgramada = horaProgramada;
        }

        if (frecuencia != null && !frecuencia.trim().isEmpty()) {
            this.frecuencia = frecuencia;
        }
    }

    public String generarRecordatorio() {
        if (estado) {
            return "Recordatorio de tratamiento: " + nombreTratamiento
                    + "\nHora programada: " + horaProgramada
                    + "\nFrecuencia: " + frecuencia;
        }
        return "El recordatorio se encuentra inactivo.";
    }

    public boolean programarRecordatorio() {
        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()
                && horaProgramada != null && !horaProgramada.trim().isEmpty()
                && frecuencia != null && !frecuencia.trim().isEmpty()) {

            estado = true;
            return true;
        }
        return false;
    }

    public void cancelarRecordatorio() {
        estado = false;
    }

    public boolean verificarEstado() {
        return estado;
    }

    public ArrayList<Notificacion> consultarNotificaciones() {
        return notificaciones;
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

    public void setNombreTratamiento(String nombreTratamiento) {
        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()) {
            this.nombreTratamiento = nombreTratamiento;
        }
    }

    public void setHoraProgramada(String horaProgramada) {
        if (horaProgramada != null && !horaProgramada.trim().isEmpty()) {
            this.horaProgramada = horaProgramada;
        }
    }

    public void setFrecuencia(String frecuencia) {
        if (frecuencia != null && !frecuencia.trim().isEmpty()) {
            this.frecuencia = frecuencia;
        }
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}