package recordatoriomedicamentos.negocio;

import recordatoriomedicamentos.modelo.RegistroToma;
import java.util.ArrayList;

public class HistorialAdministracion {

    private ArrayList<RegistroToma> registrosTomas;
    private String fechaDesde;
    private String fechaHasta;

    public HistorialAdministracion() {
        registrosTomas = new ArrayList<>();
    }

    public boolean registrarRegistro(RegistroToma registro) {
        if (registro != null
                && registro.getInventario() != null
                && registro.getEstadoToma() != null
                && !registro.getEstadoToma().trim().isEmpty()
                && registro.getFechaHoraReal() != null
                && !registro.getFechaHoraReal().trim().isEmpty()
                && registro.getCantidadAdministrada() > 0) {

            registrosTomas.add(registro);
            return true;
        }
        return false;
    }

    public ArrayList<RegistroToma> consultarHistorial() {
        return registrosTomas;
    }

    public ArrayList<RegistroToma> filtrarPorMedicamento(String nombreMedicamento) {
        ArrayList<RegistroToma> resultados = new ArrayList<>();
        return resultados;
    }

    public ArrayList<RegistroToma> filtrarPorEstado(String estado) {
        ArrayList<RegistroToma> resultados = new ArrayList<>();

        if (estado != null && !estado.trim().isEmpty()) {
            for (RegistroToma registro : registrosTomas) {
                if (registro.getEstadoToma() != null
                        && registro.getEstadoToma().equalsIgnoreCase(estado)) {
                    resultados.add(registro);
                }
            }
        }

        return resultados;
    }

    public ArrayList<RegistroToma> filtrarPorFecha(String fechaDesde, String fechaHasta) {
        ArrayList<RegistroToma> resultados = new ArrayList<>();

        if (fechaDesde != null && !fechaDesde.trim().isEmpty()
                && fechaHasta != null && !fechaHasta.trim().isEmpty()) {

            this.fechaDesde = fechaDesde;
            this.fechaHasta = fechaHasta;

            for (RegistroToma registro : registrosTomas) {
                String fechaRegistro = registro.getFechaHoraReal();

                if (fechaRegistro != null && !fechaRegistro.trim().isEmpty()) {
                    if (fechaRegistro.compareTo(fechaDesde) >= 0
                            && fechaRegistro.compareTo(fechaHasta) <= 0) {
                        resultados.add(registro);
                    }
                }
            }
        }

        return resultados;
    }

    public ArrayList<RegistroToma> getRegistrosTomas() {
        return registrosTomas;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaDesde(String fechaDesde) {
        if (fechaDesde != null && !fechaDesde.trim().isEmpty()) {
            this.fechaDesde = fechaDesde;
        }
    }

    public void setFechaHasta(String fechaHasta) {
        if (fechaHasta != null && !fechaHasta.trim().isEmpty()) {
            this.fechaHasta = fechaHasta;
        }
    }
}