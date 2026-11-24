package recordatoriomedicamentos.modelo;

import java.util.ArrayList;

public class Medicamento {

    private String nombreMedicamento;
    private String unidadMedida;
    private int cantidad;
    private String fechaCaducidad;
    private boolean estado;
    private ArrayList<Horario> horarios;

    public Medicamento(String nombreMedicamento, String unidadMedida, int cantidad, String fechaCaducidad) {
        this.nombreMedicamento = nombreMedicamento;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.fechaCaducidad = fechaCaducidad;
        this.estado = true;
        this.horarios = new ArrayList<>();
    }

    public void registrarMedicamento() {
        System.out.println("Medicamento registrado correctamente.");
    }

    public void modificarMedicamento(String nombreMedicamento, String unidadMedida) {
        this.nombreMedicamento = nombreMedicamento;
        this.unidadMedida = unidadMedida;
    }

    public void consultarMedicamento() {
        System.out.println("Nombre: " + nombreMedicamento);
        System.out.println("Unidad de medida: " + unidadMedida);
        System.out.println("Cantidad disponible: " + cantidad);
        System.out.println("Fecha de caducidad: " + fechaCaducidad);
    }

    public void agregarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }

    public void descontarCantidad(int cantidad) {
        if (cantidad > 0 && cantidad <= this.cantidad) {
            this.cantidad -= cantidad;
        } else {
            System.out.println("Cantidad no disponible.");
        }
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

    public int getCantidad() {
        return cantidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
}