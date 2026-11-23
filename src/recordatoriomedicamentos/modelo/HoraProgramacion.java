package recordatoriomedicamentos.modelo;

import recordatoriomedicamentos.interfaz.Recordatorio;

import java.util.ArrayList;

public class HoraProgramacion {

    private String fechaProgramada;
    private String horaProgramada;
    private String estadoToma;
    private ArrayList<Recordatorio> recordatorios;

    public HoraProgramacion(String fechaProgramada, String horaProgramada) {
        this.fechaProgramada = fechaProgramada;
        this.horaProgramada = horaProgramada;
        this.estadoToma = "Pendiente";
        this.recordatorios = new ArrayList<>();
    }

    public void programarToma() {
        System.out.println("Toma programada para el "
                + fechaProgramada + " a las " + horaProgramada);
    }

    public void actualizarProgramacion(String fechaProgramada, String horaProgramada) {
        if (fechaProgramada != null && !fechaProgramada.trim().isEmpty()) {
            this.fechaProgramada = fechaProgramada;
        }

        if (horaProgramada != null && !horaProgramada.trim().isEmpty()) {
            this.horaProgramada = horaProgramada;
        }

        System.out.println("Programación actualizada.");
    }

    public void consultarProximasTomas() {
        System.out.println("Fecha: " + fechaProgramada);
        System.out.println("Hora: " + horaProgramada);
        System.out.println("Estado: " + estadoToma);
    }

    public void generarCalendario() {
        System.out.println("Calendario de toma:");
        System.out.println(fechaProgramada + " - " + horaProgramada);
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        if (recordatorio != null) {
            recordatorios.add(recordatorio);
        }
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

    public void setEstadoToma(String estadoToma) {
        this.estadoToma = estadoToma;
    }

    public ArrayList<Recordatorio> getRecordatorios() {
        return recordatorios;
    }
}