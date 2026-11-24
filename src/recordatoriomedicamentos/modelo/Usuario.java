package recordatoriomedicamentos.modelo;

import recordatoriomedicamentos.negocio.HistorialAdministracion;
import recordatoriomedicamentos.negocio.RecuperacionContrasena;
import recordatoriomedicamentos.negocio.Reporte;

import java.util.ArrayList;

public class Usuario {
    private String nombreCompleto;
    private String nombreUsuario;
    private String contrasena;

    private ArrayList<Medicamento> medicamentos;
    private ArrayList<Tratamiento> tratamientos;
    private ArrayList<Sesion> sesiones;
    private ArrayList<RecuperacionContrasena> recuperaciones;
    private ArrayList<Reporte> reportes;

    private HistorialAdministracion historial;

    public Usuario(String nombreCompleto, String nombreUsuario, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        medicamentos = new ArrayList<>();
        tratamientos = new ArrayList<>();
        sesiones = new ArrayList<>();
        recuperaciones = new ArrayList<>();
        reportes = new ArrayList<>();
        historial = new HistorialAdministracion();
    }

    public void registrarUsuario() {
        System.out.println("Usuario registrado correctamente.");
    }

    public void modificarDatos(String nombreCompleto, String nombreUsuario) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
    }

    public boolean validarCredenciales(String nombreUsuario, String contrasena) {
        return this.nombreUsuario.equals(nombreUsuario)
                && this.contrasena.equals(contrasena);
    }

    public void cambiarContrasena(String nuevaContrasena) {
        this.contrasena = nuevaContrasena;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public ArrayList<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public ArrayList<RecuperacionContrasena> getRecuperaciones() {
        return recuperaciones;
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public HistorialAdministracion getHistorial() {
        return historial;
    }
}