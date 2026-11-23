package recordatoriomedicamentos.modelo;

public class RegistroToma {

    private Inventario inventario;
    private String estadoToma;
    private String fechaHoraReal;
    private int cantidadAdministrada;
    private String observacion;

    public void registrarToma() {
        System.out.println("Registro de toma guardado.");
    }

    public void actualizarEstadoToma(String estadoToma) {
        if (estadoToma != null && !estadoToma.trim().isEmpty()) {
            this.estadoToma = estadoToma;
        }
    }

    public void descontarInventario() {
        if (inventario != null && cantidadAdministrada > 0
                && inventario.verificarDisponibilidad(cantidadAdministrada)) {

            inventario.descontarCantidad(cantidadAdministrada);
            System.out.println("Inventario actualizado.");
        } else {
            System.out.println("No hay suficiente inventario.");
        }
    }

    public void consultarRegistro() {
        System.out.println("Estado: " + estadoToma);
        System.out.println("Fecha y hora: " + fechaHoraReal);
        System.out.println("Cantidad administrada: " + cantidadAdministrada);
        System.out.println("Observación: " + observacion);
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public String getEstadoToma() {
        return estadoToma;
    }

    public String getFechaHoraReal() {
        return fechaHoraReal;
    }

    public void setFechaHoraReal(String fechaHoraReal) {
        this.fechaHoraReal = fechaHoraReal;
    }

    public int getCantidadAdministrada() {
        return cantidadAdministrada;
    }

    public void setCantidadAdministrada(int cantidadAdministrada) {
        this.cantidadAdministrada = cantidadAdministrada;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}