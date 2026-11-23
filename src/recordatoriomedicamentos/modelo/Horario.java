package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Horario {

    private String horaAdministracion;
    private String frecuencia;
    private String diasSemana;
    private boolean estado;
    private String inicio;
    private String fin;
    private ArrayList<HoraProgramacion> programaciones;

    public Horario(String horaAdministracion, String frecuencia, String diasSemana, String inicio, String fin) {

        this.programaciones = new ArrayList<>();
        this.estado = false;

        if (horaAdministracion != null && !horaAdministracion.trim().isEmpty()) {
            this.horaAdministracion = horaAdministracion;
        }

        if (frecuencia != null && !frecuencia.trim().isEmpty()) {
            this.frecuencia = frecuencia;
        }

        if (diasSemana != null && !diasSemana.trim().isEmpty()) {
            this.diasSemana = diasSemana;
        }

        if (inicio != null && !inicio.trim().isEmpty()) {
            this.inicio = inicio;
        }

        if (fin != null && !fin.trim().isEmpty()) {
            this.fin = fin;
        }
    }

    public boolean configurarHorario() {
        if (horaAdministracion != null && !horaAdministracion.trim().isEmpty()
                && frecuencia != null && !frecuencia.trim().isEmpty()
                && diasSemana != null && !diasSemana.trim().isEmpty()
                && inicio != null && !inicio.trim().isEmpty()
                && fin != null && !fin.trim().isEmpty()) {

            estado = true;
            return true;
        }
        return false;
    }

    public boolean modificarHorario(String horaAdministracion, String frecuencia, String diasSemana) {
        if (horaAdministracion != null && !horaAdministracion.trim().isEmpty()
                && frecuencia != null && !frecuencia.trim().isEmpty()
                && diasSemana != null && !diasSemana.trim().isEmpty()) {

            this.horaAdministracion = horaAdministracion;
            this.frecuencia = frecuencia;
            this.diasSemana = diasSemana;
            return true;
        }
        return false;
    }

    public String consultarHorario() {
        return "Hora de administración: " + horaAdministracion
                + "\nFrecuencia: " + frecuencia
                + "\nDías: " + diasSemana
                + "\nInicio: " + inicio
                + "\nFin: " + fin
                + "\nEstado: " + (estado ? "Activo" : "Inactivo");
    }

    public String consultarProximaToma() {
        if (estado && !programaciones.isEmpty()) {
            return programaciones.get(0).consultarProximasTomas();
        }
        return "No hay próximas tomas programadas.";
    }

    public ArrayList<HoraProgramacion> consultarProgramaciones() {
        return programaciones;
    }

    public void eliminarHorario() {
        estado = false;
    }

    public String getHoraAdministracion() {
        return horaAdministracion;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getDiasSemana() {
        return diasSemana;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getInicio() {
        return inicio;
    }

    public String getFin() {
        return fin;
    }

    public ArrayList<HoraProgramacion> getProgramaciones() {
        return programaciones;
    }

    public void setHoraAdministracion(String horaAdministracion) {
        if (horaAdministracion != null && !horaAdministracion.trim().isEmpty()) {
            this.horaAdministracion = horaAdministracion;
        }
    }

    public void setFrecuencia(String frecuencia) {
        if (frecuencia != null && !frecuencia.trim().isEmpty()) {
            this.frecuencia = frecuencia;
        }
    }

    public void setDiasSemana(String diasSemana) {
        if (diasSemana != null && !diasSemana.trim().isEmpty()) {
            this.diasSemana = diasSemana;
        }
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setInicio(String inicio) {
        if (inicio != null && !inicio.trim().isEmpty()) {
            this.inicio = inicio;
        }
    }

    public void setFin(String fin) {
        if (fin != null && !fin.trim().isEmpty()) {
            this.fin = fin;
        }
    }
}