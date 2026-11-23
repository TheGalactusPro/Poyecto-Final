package recordatoriomedicamentos.modelo;

public class Inventario {

    private String lote;
    private int cantidadDisponible;
    private String fechaElaboracion;
    private String fechaVencimiento;
    private String fechaActualizacion;

    public Inventario(String lote, int cantidadDisponible,
                      String fechaElaboracion, String fechaVencimiento) {

        this.lote = lote;
        this.cantidadDisponible = cantidadDisponible;
        this.fechaElaboracion = fechaElaboracion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public void agregarCantidad(int cantidad) {
        if (cantidad > 0) {
            cantidadDisponible += cantidad;
        }
    }

    public void descontarCantidad(int cantidad) {
        if (cantidad > 0 && cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
        }
    }

    public int consultarStock() {
        return cantidadDisponible;
    }

    public boolean verificarDisponibilidad(int cantidad) {
        return cantidad > 0 && cantidadDisponible >= cantidad;
    }

    public boolean verificarVencimiento() {
        if (fechaVencimiento != null && !fechaVencimiento.trim().isEmpty()) {
            return fechaVencimiento.compareTo("2026-11-23") < 0;
        }
        return false;
    }

    public String getLote() {
        return lote;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public String getFechaElaboracion() {
        return fechaElaboracion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}