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

    public void registrarRegistro(RegistroToma registro) {
        if (registro != null) {
            registrosTomas.add(registro);
        }
    }

    public void consultarHistorial() {
        if (registrosTomas.isEmpty()) {
            System.out.println("No hay registros de administración.");
            return;
        }

        for (RegistroToma registro : registrosTomas) {
            registro.consultarRegistro();
            System.out.println("----------------------");
        }
    }

    public void filtrarPorMedicamento(String nombreMedicamento) {
        System.out.println("Para filtrar por medicamento se necesita "
                + "conocer el medicamento asociado a cada registro.");
    }

    public void filtrarPorEstado(String estado) {
        for (RegistroToma registro : registrosTomas) {
            if (registro.getEstadoToma() != null
                    && registro.getEstadoToma().equalsIgnoreCase(estado)) {

                registro.consultarRegistro();
            }
        }
    }

    public void filtrarPorFecha(String fechaDesde, String fechaHasta) {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;

        for (RegistroToma registro : registrosTomas) {
            if (registro.getFechaHoraReal() != null) {
                String fecha = registro.getFechaHoraReal().substring(0, 10);

                if (fecha.compareTo(fechaDesde) >= 0
                        && fecha.compareTo(fechaHasta) <= 0) {

                    registro.consultarRegistro();
                }
            }
        }
    }

    public ArrayList<RegistroToma> getRegistrosTomas() {
        return registrosTomas;
    }
}