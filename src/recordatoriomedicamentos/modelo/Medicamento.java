package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Medicamento {

    private String nombreMedicamento;
    private String unidadMedida;
    private boolean estado;
    private ArrayList<Inventario> inventarios;
    private ArrayList<Horario> horarios;

    public Medicamento(String nombreMedicamento, String unidadMedida) {
        this.nombreMedicamento = nombreMedicamento;
        this.unidadMedida = unidadMedida;
        this.estado = true;
        inventarios = new ArrayList<>();
        horarios = new ArrayList<>();
    }

    public boolean registrarMedicamento() {
        if (nombreMedicamento != null && !nombreMedicamento.trim().isEmpty()
                && unidadMedida != null && !unidadMedida.trim().isEmpty()) {
            estado = true;
            return true;
        }
        return false;
    }

    public void modificarMedicamento(String nombreMedicamento, String unidadMedida) {
        if (nombreMedicamento != null && !nombreMedicamento.trim().isEmpty()) {
            this.nombreMedicamento = nombreMedicamento;
        }

        if (unidadMedida != null && !unidadMedida.trim().isEmpty()) {
            this.unidadMedida = unidadMedida;
        }
    }

    public boolean consultarMedicamento() {
        return estado;
    }

    public Inventario buscarInventario(String lote) {
        for (Inventario inventario : inventarios) {
            if (inventario.getLote().equalsIgnoreCase(lote)) {
                return inventario;
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
}