package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Tratamiento {

    private String nombreTratamiento;
    private String fechaInicio;
    private ArrayList<Medicamento> medicamentos;

    public Tratamiento(String nombreTratamiento, String fechaInicio, String fechaFin) {
        this.medicamentos = new ArrayList<>();

        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()) {
            this.nombreTratamiento = nombreTratamiento;
        }

        if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            this.fechaInicio = fechaInicio;
        }
    }

    public boolean registrarTratamiento() {
        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()
                && fechaInicio != null && !fechaInicio.trim().isEmpty()
                && !medicamentos.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean modificarTratamiento(String nombreTratamiento, String fechaInicio, String fechaFin) {
        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()
                && fechaInicio != null && !fechaInicio.trim().isEmpty()
                && fechaFin != null && !fechaFin.trim().isEmpty()) {
            this.nombreTratamiento = nombreTratamiento;
            this.fechaInicio = fechaInicio;
            return true;
        }
        return false;
    }

    public void finalizarTratamiento() {
        medicamentos.clear();
    }

    public String consultarTratamiento() {
        return "Tratamiento: " +nombreTratamiento+ "\nFecha de inicio: " +fechaInicio+
                "\nMedicamentos asociados: " + medicamentos.size();
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()) {
            this.nombreTratamiento = nombreTratamiento;
        }
    }

    public void setFechaInicio(String fechaInicio) {
        if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            this.fechaInicio = fechaInicio;
        }
    }
}