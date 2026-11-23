package recordatoriomedicamentos.modelo;

public class RegistroToma {

    private Inventario inventario;
    private String estadoToma;
    private String fechaHoraReal;
    private int cantidadAdministrada;
    private String observacion;

    public boolean registrarToma() {
        if (inventario != null
                && estadoToma != null && !estadoToma.trim().isEmpty()
                && fechaHoraReal != null && !fechaHoraReal.trim().isEmpty()
                && cantidadAdministrada > 0) {
            return true;
        }
        return false;
    }

    public boolean actualizarEstadoToma(String estadoToma) {
        if (estadoToma != null && !estadoToma.trim().isEmpty()) {
            this.estadoToma = estadoToma;
            return true;
        }
        return false;
    }

    public boolean descontarInventario() {
        if (inventario != null && cantidadAdministrada > 0) {
            return inventario.descontarCantidad(cantidadAdministrada);
        }
        return false;
    }

    public String consultarRegistro() {
        if (inventario != null) {
            return "Estado de la toma: " + estadoToma
                    + "\nFecha y hora real: " + fechaHoraReal
                    + "\nCantidad administrada: " + cantidadAdministrada
                    + "\nObservación: " + observacion
                    + "\nLote: " + inventario.getLote();
        }

        return "No hay un inventario asociado al registro.";
    }

    public Inventario getInventario() {
        return inventario;
    }

    public String getEstadoToma() {
        return estadoToma;
    }

    public String getFechaHoraReal() {
        return fechaHoraReal;
    }

    public int getCantidadAdministrada() {
        return cantidadAdministrada;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void setFechaHoraReal(String fechaHoraReal) {
        if (fechaHoraReal != null && !fechaHoraReal.trim().isEmpty()) {
            this.fechaHoraReal = fechaHoraReal;
        }
    }

    public void setCantidadAdministrada(int cantidadAdministrada) {
        if (cantidadAdministrada > 0) {
            this.cantidadAdministrada = cantidadAdministrada;
        }
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}