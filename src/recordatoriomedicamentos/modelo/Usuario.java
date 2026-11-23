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
        historial = null;
    }

    public boolean registrarUsuario() {
        return nombreCompleto != null && !nombreCompleto.trim().isEmpty()
                && nombreUsuario != null && !nombreUsuario.trim().isEmpty()
                && contrasena != null && !contrasena.trim().isEmpty();
    }

    public boolean modificarDatos() {
        return nombreCompleto != null && !nombreCompleto.trim().isEmpty()
                && nombreUsuario != null && !nombreUsuario.trim().isEmpty();
    }

    public boolean validarCredenciales() {
        return nombreUsuario != null && !nombreUsuario.trim().isEmpty()
                && contrasena != null && !contrasena.trim().isEmpty();
    }

    public boolean cambiarContrasena() {
        return contrasena != null && !contrasena.trim().isEmpty();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
            this.nombreCompleto = nombreCompleto;
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            this.nombreUsuario = nombreUsuario;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena != null && !contrasena.trim().isEmpty()) {
            this.contrasena = contrasena;
        }
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

    public void setHistorial(HistorialAdministracion historial) {
        this.historial = historial;
    }
}