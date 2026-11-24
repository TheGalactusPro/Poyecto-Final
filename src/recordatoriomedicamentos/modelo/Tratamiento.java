package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Tratamiento {

    private String nombreTratamiento;
    private String fechaInicio;
    private ArrayList<Medicamento> medicamentos;

    public Tratamiento(String nombreTratamiento, String fechaInicio, String fechaFin) {
        this.nombreTratamiento = nombreTratamiento;
        this.fechaInicio = fechaInicio;
        this.medicamentos = new ArrayList<>();
    }

    public void registrarTratamiento() {
        System.out.println("Tratamiento registrado.");
    }

    public void modificarTratamiento(String nombreTratamiento, String fechaInicio, String fechaFin) {
        this.nombreTratamiento = nombreTratamiento;
        this.fechaInicio = fechaInicio;
    }

    public void finalizarTratamiento() {
        System.out.println("Tratamiento finalizado.");
    }

    public void consultarTratamiento() {
        System.out.println("Nombre: " + nombreTratamiento);
        System.out.println("Fecha de inicio: " + fechaInicio);
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }
}