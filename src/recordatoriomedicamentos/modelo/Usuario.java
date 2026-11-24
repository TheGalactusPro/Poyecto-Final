package recordatoriomedicamentos.modelo;

import recordatoriomedicamentos.negocio.HistorialAdministracion;
import recordatoriomedicamentos.negocio.RecuperacionContrasena;
import recordatoriomedicamentos.negocio.Reporte;
import recordatoriomedicamentos.negocio.Sesion;

import java.util.ArrayList;

public class Usuario {

    private String nombreCompleto;
    private String nombreUsuario;
    private String contrasena;
    private ArrayList<Tratamiento> tratamientos;
    private ArrayList<Sesion> sesiones;
    private ArrayList<RecuperacionContrasena> recuperaciones;
    private ArrayList<Reporte> reportes;
    private HistorialAdministracion historial;

    public Usuario() {
        tratamientos = new ArrayList<>();
        sesiones = new ArrayList<>();
        recuperaciones = new ArrayList<>();
        reportes = new ArrayList<>();
        historial = new HistorialAdministracion();
    }

    public boolean registrarUsuario() {
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()
                && nombreUsuario != null && !nombreUsuario.trim().isEmpty()
                && contrasena != null && !contrasena.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public void modificarDatos(String nombreCompleto, String nombreUsuario) {
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
            this.nombreCompleto = nombreCompleto;
        }

        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            this.nombreUsuario = nombreUsuario;
        }
    }

    public boolean validarCredenciales(String nombreUsuario, String contrasena) {
        return this.nombreUsuario.equals(nombreUsuario)
                && this.contrasena.equals(contrasena);
    }

    public void cambiarContrasena(String nuevaContrasena) {
        if (nuevaContrasena != null && !nuevaContrasena.trim().isEmpty()) {
            this.contrasena = nuevaContrasena;
        }
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

    public Usuario(String nombreCompleto, String nombreUsuario, String contrasena) {
        this.nombreCompleto = nombreCompleto;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;

        this.tratamientos = new ArrayList<>();
        this.sesiones = new ArrayList<>();
        this.recuperaciones = new ArrayList<>();
        this.reportes = new ArrayList<>();
        this.historial = new HistorialAdministracion();
    }
}