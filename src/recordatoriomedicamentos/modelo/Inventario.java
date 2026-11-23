package recordatoriomedicamentos.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Inventario {

    private String lote;
    private int cantidadDisponible;
    private String fechaElaboracion;
    private String fechaVencimiento;
    private String fechaActualizacion;

    public Inventario(String lote, int cantidadDisponible, String fechaElaboracion, String fechaVencimiento) {
        if (lote != null && !lote.trim().isEmpty()) {
            this.lote = lote;
        }

        if (cantidadDisponible >= 0) {
            this.cantidadDisponible = cantidadDisponible;
        }

        if (validarFecha(fechaElaboracion) && validarFecha(fechaVencimiento)
                && !LocalDate.parse(fechaVencimiento).isBefore(LocalDate.parse(fechaElaboracion))) {
            this.fechaElaboracion = fechaElaboracion;
            this.fechaVencimiento = fechaVencimiento;
        }

        this.fechaActualizacion = LocalDate.now().toString();
    }

    public boolean agregarCantidad(int cantidad) {
        if (cantidad > 0) {
            cantidadDisponible += cantidad;
            actualizarFecha();
            return true;
        }
        return false;
    }

    public boolean descontarCantidad(int cantidad) {
        if (cantidad > 0 && verificarDisponibilidad(cantidad)) {
            cantidadDisponible -= cantidad;
            actualizarFecha();
            return true;
        }
        return false;
    }

    public int consultarStock() {
        return cantidadDisponible;
    }

    public boolean verificarDisponibilidad(int cantidad) {
        return cantidad > 0 && cantidadDisponible >= cantidad;
    }

    public boolean verificarVencimiento() {
        if (validarFecha(fechaVencimiento)) {
            return !LocalDate.parse(fechaVencimiento)
                    .isBefore(LocalDate.now());
        }
        return false;
    }

    private void actualizarFecha() {
        fechaActualizacion = LocalDate.now().toString();
    }

    private boolean validarFecha(String fecha) {
        if (fecha != null && !fecha.trim().isEmpty()) {
            try {
                LocalDate.parse(fecha);
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }
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

    public void setLote(String lote) {
        if (lote != null && !lote.trim().isEmpty()) {
            this.lote = lote;
        }
    }

    public void setFechaElaboracion(String fechaElaboracion) {
        if (validarFecha(fechaElaboracion) && validarFecha(fechaVencimiento)
                && !LocalDate.parse(fechaVencimiento).isBefore(LocalDate.parse(fechaElaboracion))) {
            this.fechaElaboracion = fechaElaboracion;
        }
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        if (validarFecha(fechaVencimiento) && validarFecha(fechaElaboracion)
                && !LocalDate.parse(fechaVencimiento).isBefore(LocalDate.parse(fechaElaboracion))) {
            this.fechaVencimiento = fechaVencimiento;
        }
    }
}