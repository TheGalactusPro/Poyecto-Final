package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Medicamento {

    private String nombreMedicamento;
    private String unidadMedida;
    private boolean estado;
    private ArrayList<Inventario> inventarios;
    private ArrayList<Horario> horarios;

    public Medicamento(String nombreMedicamento, String unidadMedida) {
        this.inventarios = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.estado = false;

        if (nombreMedicamento != null && !nombreMedicamento.trim().isEmpty()) {
            this.nombreMedicamento = nombreMedicamento;
        }

        if (unidadMedida != null && !unidadMedida.trim().isEmpty()) {
            this.unidadMedida = unidadMedida;
        }

        if (this.nombreMedicamento != null && this.unidadMedida != null) {
            this.estado = true;
        }
    }

    public boolean registrarMedicamento() {
        if (nombreMedicamento != null && !nombreMedicamento.trim().isEmpty()
                && unidadMedida != null && !unidadMedida.trim().isEmpty()) {
            estado = true;
            return true;
        }
        return false;
    }

    public boolean modificarMedicamento(String nombreMedicamento, String unidadMedida) {

        if (nombreMedicamento != null && !nombreMedicamento.trim().isEmpty()
                && unidadMedida != null && !unidadMedida.trim().isEmpty()) {

            this.nombreMedicamento = nombreMedicamento;
            this.unidadMedida = unidadMedida;
            return true;
        }
        return false;
    }

    public String consultarMedicamento() {
        if (estado) {
            return "Medicamento: " +nombreMedicamento+ "\nUnidad de medida: " +unidadMedida+ "\nEstado: Activo";
        }
        return "El medicamento se encuentra inactivo.";
    }

    public Inventario buscarInventario(String lote) {

        if (lote != null && !lote.trim().isEmpty()) {
            for (Inventario inventario : inventarios) {
                if (inventario.getLote().equalsIgnoreCase(lote)) {
                    return inventario;
                }
            }
        }

        return null;
    }

    public ArrayList<Inventario> consultarInventarios() {
        return inventarios;
    }

    public ArrayList<Horario> consultarHorarios() {
        return horarios;
    }

    public void eliminarMedicamento() {
        estado = false;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public boolean isEstado() {
        return estado;
    }

    public ArrayList<Inventario> getInventarios() {
        return inventarios;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        if (nombreMedicamento != null && !nombreMedicamento.trim().isEmpty()) {
            this.nombreMedicamento = nombreMedicamento;
        }
    }

    public void setUnidadMedida(String unidadMedida) {
        if (unidadMedida != null && !unidadMedida.trim().isEmpty()) {
            this.unidadMedida = unidadMedida;
        }
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}