package recordatoriomedicamentos.modelo;

public class RegistroToma {

    private Medicamento medicamento;
    private String estadoToma;
    private String fechaHoraReal;
    private int cantidadAdministrada;
    private String observacion;

    public void registrarToma() {
        System.out.println("Registro de toma guardado correctamente.");
    }

    public void actualizarEstadoToma(String estadoToma) {
        this.estadoToma = estadoToma;
    }

    public void descontarInventario() {
        if (medicamento != null && cantidadAdministrada > 0) {
            medicamento.descontarCantidad(cantidadAdministrada);
        }
    }

    public void consultarRegistro() {
        System.out.println("Medicamento: " + medicamento.getNombreMedicamento());
        System.out.println("Estado de la toma: " + estadoToma);
        System.out.println("Fecha y hora: " + fechaHoraReal);
        System.out.println("Cantidad administrada: " + cantidadAdministrada);
        System.out.println("Observación: " + observacion);
    }

    // Getters y setters

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getEstadoToma() {
        return estadoToma;
    }

    public void setEstadoToma(String estadoToma) {
        this.estadoToma = estadoToma;
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