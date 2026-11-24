package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Tratamiento {

    private String nombreTratamiento;
    private ArrayList<Medicamento> medicamentos;

    public Tratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
        this.medicamentos = new ArrayList<>();
    }

    public void registrarTratamiento() {
        System.out.println("Tratamiento registrado correctamente.");
    }

    public void modificarTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public void finalizarTratamiento() {
        System.out.println("Tratamiento finalizado correctamente.");
    }

    public void consultarTratamiento() {
        System.out.println("Nombre del tratamiento: " + nombreTratamiento);
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }
}