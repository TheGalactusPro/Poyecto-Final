package recordatoriomedicamentos.interfaz;

import recordatoriomedicamentos.modelo.*;
import recordatoriomedicamentos.modelo.Sesion;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuario;
    static ArrayList<Medicamento> medicamentos = new ArrayList<>();
    public static void main() {
        cargarDatosPredeterminados();
        int opcion;
        do {
            System.out.println("\nSISTEMA DE GESTIÓN DE MEDICAMENTOS");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Recuperar contraseña");
            System.out.println("4. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 3:
                    recuperarUsuario();
                    break;
                case 4:
                    System.out.println("Gracias por utilizar el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    // DATOS PREDETERMINADOS

    public static void cargarDatosPredeterminados() {
        Usuario juan = new Usuario("Juan Pérez", "juan", "1234");
        usuarios.add(juan);
        juan.getMedicamentos().add(new Medicamento("Paracetamol", "Tabletas", 30, "10-01-2027"));
        juan.getMedicamentos().add(new Medicamento("Loratadina", "Tabletas", 20, "15-02-2027"));
        juan.getMedicamentos().add(new Medicamento("Ibuprofeno", "Tabletas", 25, "20-03-2027"));
    }

    // MÓDULO 1: INICIO DE SESIÓN Y USUARIOS

    public static void registrarUsuario() {
        System.out.println("\nREGISTRAR USUARIO");
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = entrada.nextLine();
        System.out.print("Ingrese un nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();
        if (existeUsuario(nombreUsuario)) {
            System.out.println("Este nombre de usuario ya está registrado.");
            return;
        }
        System.out.print("Ingrese una contraseña: ");
        String contrasena = entrada.nextLine();
        Usuario nuevoUsuario = new Usuario(
                nombreCompleto, nombreUsuario, contrasena);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado correctamente.");
    }

    public static boolean existeUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario() != null && u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
        }
        return false;
    }

    public static void iniciarSesion() {
        System.out.println("\nINICIAR SESIÓN");
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = entrada.nextLine();
        for (Usuario u : usuarios) {
            if (u.validarCredenciales(nombreUsuario, contrasena)) {
                usuario = u;
                System.out.println("\nBienvenido, "+ usuario.getNombreCompleto());
                menuPrincipalUsuario();
                return;
            }
        }
        System.out.println("Nombre de usuario o contraseña incorrectos.");
    }

    public static void recuperarUsuario() {
        System.out.println("\nRECUPERAR CONTRASEÑA");
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();
        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }
        if (usuarioEncontrado == null) {
            System.out.println("El usuario no existe.");
            return;
        }
        System.out.print("Ingrese su nueva contraseña: ");
        String nuevaContrasena = entrada.nextLine();
        usuarioEncontrado.cambiarContrasena(nuevaContrasena);
        System.out.println("Contraseña actualizada correctamente.");
    }

    // MENÚ PRINCIPAL

    public static void menuPrincipalUsuario() {
        int opcion;
        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Gestión de medicamentos");
            System.out.println("2. Gestión de tratamientos y horarios");
            System.out.println("3. Recordatorios y registro de tomas");
            System.out.println("4. Reportes personales");
            System.out.println("5. Cerrar sesión");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    menuMedicamentos();
                    break;
                case 2:
                    menuTratamientos();
                    break;
                case 3:
                    menuRecordatorios();
                    break;
                case 4:
                    System.out.println("Módulo por programar");
                    break;
                case 5:
                    usuario = null;
                    System.out.println("Sesión cerrada correctamente.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    // VALIDAR FECHAS

    public static String leerFechaValida(String mensaje) {
        String fecha;
        boolean valida;
        do {
            valida = true;
            System.out.print(mensaje);
            fecha = entrada.nextLine();
            if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
                System.out.println("La fecha debe ser del dia 2026-11-23 en adelante");
                valida = false;
                continue;
            }
            String[] partes = fecha.split("-");
            int anio = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int dia = Integer.parseInt(partes[2]);
            if (mes < 1 || mes > 12 || dia < 1) {
                System.out.println("La fecha ingresada no es válida");
                valida = false;
                continue;
            }
            int diasMes;
            switch (mes) {
                case 2:
                    if ((anio % 4 == 0 && anio % 100 != 0) || anio % 400 == 0) {
                        diasMes = 29;
                    } else {
                        diasMes = 28;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    diasMes = 30;
                    break;

                default:
                    diasMes = 31;
                    break;
            }
            if (dia > diasMes) {
                System.out.println("El día no existe en ese mes.");
                valida = false;
                continue;
            }
            if (fecha.compareTo("2026-11-23") < 0) {
                System.out.println("La fecha debe ser del dia 2026-11-23 en adelante");
                valida = false;
            }
        } while (!valida);
        return fecha;
    }

    // MÓDULO 2: GESTIÓN DE MEDICAMENTOS

    public static void menuMedicamentos() {
        int opcion;
        do {
            System.out.println("\nGESTIÓN DE MEDICAMENTOS");
            System.out.println("1. Registrar medicamento");
            System.out.println("2. Consultar medicamentos");
            System.out.println("3. Modificar medicamento");
            System.out.println("4. Eliminar medicamento");
            System.out.println("5. Agregar cantidad");
            System.out.println("6. Consultar medicamentos con pocas existencias");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    registrarMedicamento();
                    break;
                case 2:
                    consultarMedicamentos();
                    break;
                case 3:
                    modificarMedicamento();
                    break;
                case 4:
                    eliminarMedicamento();
                    break;
                case 5:
                    agregarCantidad();
                    break;
                case 6:
                    consultarPocasExistencias();
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    public static void registrarMedicamento() {
        System.out.println("\nREGISTRAR MEDICAMENTO");
        System.out.print("Nombre del medicamento: ");
        String nombre = entrada.nextLine();
        System.out.print("Unidad de medida: ");
        String unidad = entrada.nextLine();
        System.out.print("Cantidad disponible: ");
        int cantidad = entrada.nextInt();
        entrada.nextLine();
        if (cantidad < 0) {
            System.out.println("La cantidad no puede ser negativa.");
            return;
        }
        String fecha = leerFechaValida("Fecha de caducidad (YYYY-MM-DD): ");
        Medicamento medicamento = new Medicamento(nombre, unidad, cantidad, fecha);
        usuario.getMedicamentos().add(medicamento);
        medicamento.registrarMedicamento();
    }

    public static void consultarMedicamentos() {
        System.out.println("\nMEDICAMENTOS REGISTRADOS");
        if (usuario.getMedicamentos().isEmpty()) {
            System.out.println("No hay medicamentos registrados en este perfil.");
            return;
        }
        for (int i = 0; i < usuario.getMedicamentos().size(); i++) {
            System.out.println("\nMEDICAMENTO " + (i + 1));
            usuario.getMedicamentos().get(i).consultarMedicamento();
        }
    }

    public static void modificarMedicamento() {
        System.out.println("\nMODIFICAR MEDICAMENTO");
        if (usuario.getMedicamentos().isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }
        System.out.println("\nMEDICAMENTOS");
        for (int i = 0; i < usuario.getMedicamentos().size(); i++) {
            System.out.println((i + 1) + ". " + usuario.getMedicamentos().get(i).getNombreMedicamento());
        }
        System.out.print("\nSeleccione el medicamento que desea modificar: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        if (opcion < 1 || opcion > usuario.getMedicamentos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Medicamento medicamento = usuario.getMedicamentos().get(opcion - 1);
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = entrada.nextLine();
        System.out.print("Ingrese la nueva unidad de medida: ");
        String nuevaUnidad = entrada.nextLine();
        medicamento.modificarMedicamento(nuevoNombre, nuevaUnidad);
        System.out.print("¿Desea modificar también la fecha de caducidad? (1. Sí / 0. No): ");
        int respuesta = entrada.nextInt();
        entrada.nextLine();
        if (respuesta == 1) {
            System.out.print("Ingrese la nueva fecha de caducidad: ");
            String nuevaFecha = entrada.nextLine();
            medicamento.setFechaCaducidad(nuevaFecha);
        }
    }

    public static void eliminarMedicamento() {
        System.out.println("\nELIMINAR MEDICAMENTO");
        if (usuario.getMedicamentos().isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }
        System.out.println("\nMEDICAMENTOS");
        for (int i = 0; i < usuario.getMedicamentos().size(); i++) {
            System.out.println((i + 1) + ". "
                    + usuario.getMedicamentos().get(i).getNombreMedicamento());
        }
        System.out.print("\nSeleccione el medicamento que desea eliminar: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        if (opcion < 1 || opcion > usuario.getMedicamentos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Medicamento medicamento = usuario.getMedicamentos().get(opcion - 1);
        medicamento.eliminarMedicamento();
        usuario.getMedicamentos().remove(opcion - 1);
        System.out.println("Medicamento eliminado correctamente.");
    }

    public static void agregarCantidad() {
        System.out.println("\nAGREGAR CANTIDAD");
        if (usuario.getMedicamentos().isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }
        System.out.println("\nMEDICAMENTOS");
        for (int i = 0; i < usuario.getMedicamentos().size(); i++) {
            Medicamento medicamento = usuario.getMedicamentos().get(i);
            System.out.println((i + 1) + ". "
                    + medicamento.getNombreMedicamento()
                    + " - Cantidad: " + medicamento.getCantidad());
        }
        System.out.print("\nSeleccione el medicamento: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        if (opcion < 1 || opcion > usuario.getMedicamentos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Medicamento medicamento = usuario.getMedicamentos().get(opcion - 1);
        System.out.print("Ingrese la cantidad que desea agregar: ");
        int cantidad = entrada.nextInt();
        entrada.nextLine();
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            return;
        }
        medicamento.agregarCantidad(cantidad);
        System.out.println("Cantidad actualizada correctamente.");
        System.out.println("Cantidad disponible: " + medicamento.getCantidad());
    }

    public static void consultarPocasExistencias() {
        System.out.println("\nMEDICAMENTOS CON POCAS EXISTENCIAS");
        boolean encontrado = false;
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.isEstado() && medicamento.getCantidad() <= 5) {
                medicamento.consultarMedicamento();
                System.out.println("-------------------------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay medicamentos con pocas existencias.");
        }
    }

    public static Medicamento buscarMedicamento() {
        System.out.print("Ingrese el nombre del medicamento: ");
        String nombre = entrada.nextLine();
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.isEstado()
                    && medicamento.getNombreMedicamento().equalsIgnoreCase(nombre)) {
                return medicamento;
            }
        }
        System.out.println("Medicamento no encontrado.");
        return null;
    }

    // MÓDULO 3: TRATAMIENTOS Y HORARIOS

    public static void menuTratamientos() {
        int opcion;
        do {
            System.out.println("\nGESTIÓN DE TRATAMIENTOS");
            System.out.println("1. Registrar tratamiento");
            System.out.println("2. Consultar tratamientos");
            System.out.println("3. Modificar tratamiento");
            System.out.println("4. Programar toma");
            System.out.println("5. Consultar programaciones");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    registrarTratamiento();
                    break;
                case 2:
                    consultarTratamientos();
                    break;
                case 3:
                    modificarTratamiento();
                    break;
                case 4:
                    programarToma();
                    break;
                case 5:
                    consultarProgramaciones();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    public static void registrarTratamiento() {
        System.out.println("\nREGISTRAR TRATAMIENTO");
        System.out.print("Nombre del tratamiento: ");
        String nombre = entrada.nextLine();
        Tratamiento tratamiento = new Tratamiento(nombre);
        if (usuario.getMedicamentos().isEmpty()) {
            System.out.println("No hay medicamentos registrados en este perfil.");
            return;
        }
        System.out.println("\nMEDICAMENTOS DISPONIBLES");
        for (int i = 0; i < usuario.getMedicamentos().size(); i++) {
            Medicamento medicamento = usuario.getMedicamentos().get(i);
            if (medicamento.isEstado()) {
                System.out.println((i + 1) + ". " + medicamento.getNombreMedicamento());
            }
        }
        boolean continuar = true;
        boolean medicamentoAgregado = false;
        while (continuar) {
            System.out.print("\nSeleccione el número del medicamento: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion < 1 || opcion > usuario.getMedicamentos().size()) {
                System.out.println("Selección no válida.");
                continue;
            }
            Medicamento medicamento = usuario.getMedicamentos().get(opcion - 1);
            if (!medicamento.isEstado()) {
                System.out.println("Este medicamento no está disponible.");
                continue;
            }
            if (tratamiento.getMedicamentos().contains(medicamento)) {
                System.out.println("Este medicamento ya fue seleccionado.");
                continue;
            }
            tratamiento.getMedicamentos().add(medicamento);
            medicamentoAgregado = true;
            System.out.println("Medicamento agregado correctamente.");
            System.out.print("\n¿Desea agregar otro medicamento? (1. Sí / 0. No): ");
            int respuesta = entrada.nextInt();
            entrada.nextLine();
            if (respuesta != 1) {
                continuar = false;
            }
        }
        if (medicamentoAgregado) {
            usuario.getTratamientos().add(tratamiento);
            tratamiento.registrarTratamiento();
        } else {
            System.out.println("No se registró el tratamiento");
        }
    }

    public static void consultarTratamientos() {
        System.out.println("\nTRATAMIENTOS REGISTRADOS");
        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados en este perfil.");
            return;
        }
        for (int i = 0; i < usuario.getTratamientos().size(); i++) {
            System.out.println("\nTRATAMIENTO " + (i + 1));
            usuario.getTratamientos().get(i).consultarTratamiento();
            System.out.println("MEDICAMENTOS ASOCIADOS:");
            for (Medicamento medicamento : usuario.getTratamientos().get(i).getMedicamentos()) {
                System.out.println("- " + medicamento.getNombreMedicamento());
            }
        }
    }

    public static void modificarTratamiento() {
        System.out.println("\nMODIFICAR TRATAMIENTO");
        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados.");
            return;
        }
        System.out.println("\nTRATAMIENTOS");
        for (int i = 0; i < usuario.getTratamientos().size(); i++) {
            System.out.println((i + 1) + ". " +
                    usuario.getTratamientos().get(i).getNombreTratamiento());
        }
        System.out.print("\nSeleccione el tratamiento que desea modificar: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        if (opcion < 1 || opcion > usuario.getTratamientos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Tratamiento tratamiento = usuario.getTratamientos().get(opcion - 1);
        System.out.print("Ingrese el nuevo nombre del tratamiento: ");
        String nuevoNombre = entrada.nextLine();
        tratamiento.modificarTratamiento(nuevoNombre);
        System.out.println("Tratamiento modificado correctamente.");
    }

    public static void programarToma() {
        System.out.println("\nPROGRAMAR TOMA");
        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados");
            return;
        }
        System.out.println("\nTRATAMIENTOS");
        for (int i = 0; i < usuario.getTratamientos().size(); i++) {
            System.out.println((i + 1) + ". "
                    + usuario.getTratamientos().get(i).getNombreTratamiento());
        }
        System.out.print("\nSeleccione el tratamiento: ");
        int opcionTratamiento = entrada.nextInt();
        entrada.nextLine();
        if (opcionTratamiento < 1 || opcionTratamiento > usuario.getTratamientos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Tratamiento tratamiento = usuario.getTratamientos().get(opcionTratamiento - 1);
        if (tratamiento.getMedicamentos().isEmpty()) {
            System.out.println("Este tratamiento no tiene medicamentos.");
            return;
        }
        System.out.println("\nMEDICAMENTOS");
        for (int i = 0; i < tratamiento.getMedicamentos().size(); i++) {
            System.out.println((i + 1) + ". " + tratamiento.getMedicamentos().get(i).getNombreMedicamento());
        }
        System.out.print("\nSeleccione el medicamento: ");
        int opcionMedicamento = entrada.nextInt();
        entrada.nextLine();
        if (opcionMedicamento < 1 || opcionMedicamento > tratamiento.getMedicamentos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Medicamento medicamento = tratamiento.getMedicamentos().get(opcionMedicamento - 1);
        System.out.print("Hora de administración: ");
        String hora = entrada.nextLine();
        System.out.print("Frecuencia (Horas): ");
        String frecuencia = entrada.nextLine();
        System.out.print("Días de administración: ");
        String dias = entrada.nextLine();
        String fecha = leerFechaValida("Fecha de inicio (YYYY-MM-DD): ");
        Horario horario = new Horario(hora, frecuencia, dias);
        HoraProgramacion programacion = new HoraProgramacion(fecha, hora);
        horario.getProgramaciones().add(programacion);
        medicamento.getHorarios().add(horario);
        horario.configurarHorario();
        System.out.println("Toma programada correctamente");
    }

    public static void consultarProgramaciones() {
        System.out.println("\nPROGRAMACIONES REGISTRADAS´");
        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados.");
            return;
        }
        int contador = 1;
        boolean hayProgramaciones = false;
        for (int i = 0; i < usuario.getTratamientos().size(); i++) {
            Tratamiento tratamiento = usuario.getTratamientos().get(i);
            for (int j = 0; j < tratamiento.getMedicamentos().size(); j++) {
                Medicamento medicamento = tratamiento.getMedicamentos().get(j);
                if (!medicamento.getHorarios().isEmpty()) {
                    for (int k = 0; k < medicamento.getHorarios().size(); k++) {
                        Horario horario = medicamento.getHorarios().get(k);
                        System.out.println("\nProgramación " + contador);
                        System.out.println("Tratamiento: " + tratamiento.getNombreTratamiento());
                        System.out.println("Medicamento: " + medicamento.getNombreMedicamento());
                        horario.consultarHorario();
                        contador++;
                        hayProgramaciones = true;
                    }
                }
            }
        }
        if (!hayProgramaciones) {
            System.out.println("No hay programaciones registradas.");
        }
    }

    // MÓDULO 4: RECORDATORIOS Y REGISTRO DE TOMAS.

    public static void menuRecordatorios() {
        int opcion;
        do {
            System.out.println("\nRECORDATORIOS Y REGISTRO DE TOMAS");
            System.out.println("1. Programar recordatorio");
            System.out.println("2. Consultar recordatorios");
            System.out.println("3. Registrar toma");
            System.out.println("4. Consultar historial de administración");
            System.out.println("5. Filtrar historial por estado");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            switch (opcion) {
                case 1:
                    programarRecordatorio();
                    break;
                case 2:
                    consultarRecordatorios();
                    break;
                case 3:
                    registrarToma();
                    break;
                case 4:
                    consultarHistorial();
                    break;
                case 5:
                    filtrarHistorialEstado();
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    public static void programarRecordatorio() {
        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados.");
            return;
        }
        System.out.println("TRATAMIENTOS");
        for (int i = 0; i < usuario.getTratamientos().size(); i++) {
            System.out.println((i + 1) + ". " + usuario.getTratamientos().get(i).getNombreTratamiento());
        }
        System.out.print("Seleccione el tratamiento: ");
        int opcionTratamiento = entrada.nextInt();
        entrada.nextLine();
        if (opcionTratamiento < 1 || opcionTratamiento > usuario.getTratamientos().size()) {
            System.out.println("Opción no válida.");
            return;
        }
        Tratamiento tratamiento = usuario.getTratamientos().get(opcionTratamiento - 1);
        if (tratamiento.getMedicamentos().isEmpty()) {
            System.out.println("El tratamiento no tiene medicamentos registrados.");
            return;
        }
        System.out.println("MEDICAMENTOS");
        for (int i = 0; i < tratamiento.getMedicamentos().size(); i++) {
            System.out.println((i + 1) + ". " + tratamiento.getMedicamentos().get(i).getNombreMedicamento());
        }
        System.out.print("Seleccione el medicamento: ");
        int opcionMedicamento = entrada.nextInt();
        entrada.nextLine();
        if (opcionMedicamento < 1 || opcionMedicamento > tratamiento.getMedicamentos().size()) {
            System.out.println("Opción no válida.");
            return;
        }
        Medicamento medicamento = tratamiento.getMedicamentos().get(opcionMedicamento - 1);
        if (medicamento.getHorarios().isEmpty()) {
            System.out.println("El medicamento no tiene horarios programados.");
            return;
        }
        System.out.println("HORARIOS");
        for (int i = 0; i < medicamento.getHorarios().size(); i++) {
            Horario horario = medicamento.getHorarios().get(i);
            System.out.println((i + 1) + ". Hora: "
                    + horario.getHoraAdministracion()
                    + " | Frecuencia: " + horario.getFrecuencia());
        }
        System.out.print("Seleccione el horario: ");
        int opcionHorario = entrada.nextInt();
        entrada.nextLine();
        if (opcionHorario < 1 || opcionHorario > medicamento.getHorarios().size()) {
            System.out.println("Opción no válida.");
            return;
        }
        Horario horario = medicamento.getHorarios().get(opcionHorario - 1);
        String fecha = leerFechaValida("Fecha del recordatorio (YYYY-MM-DD): ");
        HoraProgramacion programacion = new HoraProgramacion(fecha, horario.getHoraAdministracion());
        Recordatorio recordatorio = new Recordatorio(tratamiento.getNombreTratamiento(), horario.getHoraAdministracion(), horario.getFrecuencia());
        programacion.getRecordatorios().add(recordatorio);
        horario.getProgramaciones().add(programacion);
        recordatorio.programarRecordatorio();
    }

    public static void consultarRecordatorios() {
        System.out.println("\nRECORDATORIOS REGISTRADOS");
        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados.");
            return;
        }
        boolean encontrados = false;
        for (Tratamiento tratamiento : usuario.getTratamientos()) {
            for (Medicamento medicamento : tratamiento.getMedicamentos()) {
                for (Horario horario : medicamento.getHorarios()) {
                    for (HoraProgramacion programacion : horario.getProgramaciones()) {
                        for (Recordatorio recordatorio : programacion.getRecordatorios()) {
                            System.out.println("\nTRATAMIENTO: " + tratamiento.getNombreTratamiento());
                            System.out.println("MEDICAMENTO: " + medicamento.getNombreMedicamento());
                            System.out.println("FECHA: " + programacion.getFechaProgramada());
                            System.out.println("HORA: " + programacion.getHoraProgramada());
                            System.out.println("FRECUENCIA: " + recordatorio.getFrecuencia());
                            encontrados = true;
                        }
                    }
                }
            }
        }
        if (!encontrados) {
            System.out.println("No hay recordatorios registrados.");
        }
    }

    public static void registrarToma() {
        System.out.println("\nREGISTRAR TOMA");
        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados.");
            return;
        }
        System.out.println("\nTRATAMIENTOS");
        for (int i = 0; i < usuario.getTratamientos().size(); i++) {
            System.out.println((i + 1) + ". " + usuario.getTratamientos().get(i).getNombreTratamiento());
        }
        System.out.print("\nSeleccione el tratamiento: ");
        int opcionTratamiento = entrada.nextInt();
        entrada.nextLine();
        if (opcionTratamiento < 1 || opcionTratamiento > usuario.getTratamientos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Tratamiento tratamiento = usuario.getTratamientos().get(opcionTratamiento - 1);

        if (tratamiento.getMedicamentos().isEmpty()) {
            System.out.println("No hay medicamentos asociados.");
            return;
        }
        System.out.println("\nMEDICAMENTOS");
        for (int i = 0; i < tratamiento.getMedicamentos().size(); i++) {
            System.out.println((i + 1) + ". " + tratamiento.getMedicamentos().get(i).getNombreMedicamento());
        }
        System.out.print("\nSeleccione el medicamento: ");
        int opcionMedicamento = entrada.nextInt();
        entrada.nextLine();
        if (opcionMedicamento < 1 || opcionMedicamento > tratamiento.getMedicamentos().size()) {
            System.out.println("Selección no válida.");
            return;
        }
        Medicamento medicamento = tratamiento.getMedicamentos().get(opcionMedicamento - 1);
        System.out.println("\nESTADO DE LA TOMA");
        System.out.println("1. REALIZADA");
        System.out.println("2. OMITIDA");
        System.out.println("3. PENDIENTE");
        System.out.print("Seleccione el estado: ");
        int opcionEstado = entrada.nextInt();
        entrada.nextLine();
        String estado;
        switch (opcionEstado) {
            case 1:
                estado = "REALIZADA";
                break;
            case 2:
                estado = "OMITIDA";
                break;
            case 3:
                estado = "PENDIENTE";
                break;
            default:
                System.out.println("Selección no válida.");
                return;
        }
        int cantidad = 0;
        if (estado.equals("REALIZADA")) {
            System.out.print("Ingrese la cantidad administrada: ");
            cantidad = entrada.nextInt();
            entrada.nextLine();
            if (cantidad <= 0 || cantidad > medicamento.getCantidad()) {
                System.out.println("Cantidad no válida o existencias insuficientes.");
                return;
            }
            medicamento.descontarCantidad(cantidad);
        }
        RegistroToma registro = new RegistroToma();
        registro.setMedicamento(medicamento);
        registro.setEstadoToma(estado);
        registro.setCantidadAdministrada(cantidad);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        registro.setFechaHoraReal(LocalDateTime.now().format(formato));
        System.out.print("Observación (opcional): ");
        String observacion = entrada.nextLine();
        registro.setObservacion(observacion);
        registro.registrarToma();
        usuario.getHistorial().registrarRegistro(registro);
    }

    public static void consultarHistorial() {
        System.out.println("\nHISTORIAL DE ADMINISTRACIÓN");
        usuario.getHistorial().consultarHistorial();
    }

    public static void filtrarHistorialEstado() {
        System.out.println("\nFILTRAR HISTORIAL POR ESTADO");
        System.out.println("1. REALIZADA");
        System.out.println("2. OMITIDA");
        System.out.println("3. PENDIENTE");
        System.out.print("Seleccione el estado: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();
        String estado;
        switch (opcion) {
            case 1:
                estado = "REALIZADA";
                break;
            case 2:
                estado = "OMITIDA";
                break;
            case 3:
                estado = "PENDIENTE";
                break;
            default:
                System.out.println("Selección no válida.");
                return;
        }
        usuario.getHistorial().filtrarPorEstado(estado);
    }
  }