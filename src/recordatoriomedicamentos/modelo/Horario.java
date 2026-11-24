package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Horario {
    private String horaAdministracion;
    private String frecuencia;
    private String dias;
    private boolean estado;
    private String inicio;
    private String fin;
    private ArrayList<HoraProgramacion> programaciones;

    public Horario(String horaAdministracion, String frecuencia, String dias) {
        this.horaAdministracion = horaAdministracion;
        this.frecuencia = frecuencia;
        this.dias = dias;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = true;
        this.programaciones = new ArrayList<>();
    }

    public void configurarHorario() {
        if (horaAdministracion != null && !horaAdministracion.trim().isEmpty() && frecuencia != null && !frecuencia.trim().isEmpty()) {
            estado = true;
            System.out.println("Horario configurado correctamente.");
        }
    }

    public void modificarHorario(String horaAdministracion, String frecuencia, String dias) {
        if (horaAdministracion != null && !horaAdministracion.trim().isEmpty()) {
            this.horaAdministracion = horaAdministracion;
        }
        if (frecuencia != null && !frecuencia.trim().isEmpty()) {
            this.frecuencia = frecuencia;
        }
        if (dias != null && !dias.trim().isEmpty()) {
            this.dias = dias;
        }
        System.out.println("Horario modificado correctamente.");
    }

    public void consultarHorario() {
        System.out.println("Hora: " + horaAdministracion);
        System.out.println("Frecuencia: " + frecuencia);
        System.out.println("Días: " + dias);
        System.out.println("Inicio: " + inicio);
        System.out.println("Fin: " + fin);
        System.out.println("Estado: " + (estado ? "Activo" : "Inactivo"));
    }

    public void consultarProximaToma() {
        if (!programaciones.isEmpty()) {
            HoraProgramacion proxima = programaciones.get(0);
            System.out.println("Próxima toma:");
            System.out.println("Fecha: " + proxima.getFechaProgramada());
            System.out.println("Hora: " + proxima.getHoraProgramada());
        } else {
            System.out.println("No hay tomas programadas.");
        }
    }

    public void consultarProgramaciones() {
        for (HoraProgramacion programacion : programaciones) {
            System.out.println("Fecha: " + programacion.getFechaProgramada());
            System.out.println("Hora: " + programacion.getHoraProgramada());
            System.out.println("Estado: " + programacion.getEstadoToma());
        }
    }

    public void eliminarHorario() {
        estado = false;
        System.out.println("Horario eliminado.");
    }

    public void agregarProgramacion(HoraProgramacion programacion) {
        if (programacion != null) {
            programaciones.add(programacion);
        }
    }

    public String getHoraAdministracion() {
        return horaAdministracion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getDiasSemana() {
        return dias;
    }

    public boolean isEstado() {
        return estado;
    }

    public ArrayList<HoraProgramacion> getProgramaciones() {
        return programaciones;
    }
}