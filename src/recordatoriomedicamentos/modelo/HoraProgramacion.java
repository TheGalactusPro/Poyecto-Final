package recordatoriomedicamentos.modelo;

import recordatoriomedicamentos.interfaz.Recordatorio;
import java.util.ArrayList;

public class HoraProgramacion {

    private String fechaProgramada;
    private String horaProgramada;
    private String estadoToma;
    private ArrayList<Recordatorio> recordatorios;

    public HoraProgramacion(String fechaProgramada, String horaProgramada) {
        this.recordatorios = new ArrayList<>();
        this.estadoToma = "Pendiente";

        if (fechaProgramada != null && !fechaProgramada.trim().isEmpty()) {
            this.fechaProgramada = fechaProgramada;
        }

        if (horaProgramada != null && !horaProgramada.trim().isEmpty()) {
            this.horaProgramada = horaProgramada;
        }
    }

    public boolean programarToma() {
        if (fechaProgramada != null && !fechaProgramada.trim().isEmpty()
                && horaProgramada != null && !horaProgramada.trim().isEmpty()) {
            estadoToma = "Pendiente";
            return true;
        }
        return false;
    }

    public boolean actualizarProgramacion(String fechaProgramada, String horaProgramada) {
        if (fechaProgramada != null && !fechaProgramada.trim().isEmpty()
                && horaProgramada != null && !horaProgramada.trim().isEmpty()) {

            this.fechaProgramada = fechaProgramada;
            this.horaProgramada = horaProgramada;
            return true;
        }
        return false;
    }

    public String consultarProximasTomas() {
        return "Fecha programada: " + fechaProgramada
                + "\nHora programada: " + horaProgramada
                + "\nEstado de la toma: " + estadoToma;
    }

    public String generarCalendario() {
        return "Calendario de toma\n"
                + "Fecha: " + fechaProgramada
                + "\nHora: " + horaProgramada
                + "\nEstado: " + estadoToma;
    }

    public String getFechaProgramada() {
        return fechaProgramada;
    }

    public String getHoraProgramada() {
        return horaProgramada;
    }

    public String getEstadoToma() {
        return estadoToma;
    }

    public ArrayList<Recordatorio> getRecordatorios() {
        return recordatorios;
    }

    public void setFechaProgramada(String fechaProgramada) {
        if (fechaProgramada != null && !fechaProgramada.trim().isEmpty()) {
            this.fechaProgramada = fechaProgramada;
        }
    }

    public void setHoraProgramada(String horaProgramada) {
        if (horaProgramada != null && !horaProgramada.trim().isEmpty()) {
            this.horaProgramada = horaProgramada;
        }
    }

    public void setEstadoToma(String estadoToma) {
        if (estadoToma != null && !estadoToma.trim().isEmpty()) {
            this.estadoToma = estadoToma;
        }
    }
}