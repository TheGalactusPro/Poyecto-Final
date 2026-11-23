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
        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()
                && fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            System.out.println("Tratamiento registrado correctamente.");
        }
    }

    public void modificarTratamiento(String nombreTratamiento, String fechaInicio, String fechaFin) {
        if (nombreTratamiento != null && !nombreTratamiento.trim().isEmpty()) {
            this.nombreTratamiento = nombreTratamiento;
        }

        if (fechaInicio != null && !fechaInicio.trim().isEmpty()) {
            this.fechaInicio = fechaInicio;
        }

        System.out.println("Tratamiento modificado correctamente.");
    }

    public void finalizarTratamiento() {
        System.out.println("Tratamiento finalizado: " + nombreTratamiento);
    }

    public void consultarTratamiento() {
        System.out.println("Nombre: " + nombreTratamiento);
        System.out.println("Fecha de inicio: " + fechaInicio);

        System.out.println("Medicamentos:");

        for (Medicamento medicamento : medicamentos) {
            System.out.println("- " + medicamento.getNombreMedicamento());
        }
    }

    public void agregarMedicamento(Medicamento medicamento) {
        if (medicamento != null) {
            medicamentos.add(medicamento);
        }
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
}