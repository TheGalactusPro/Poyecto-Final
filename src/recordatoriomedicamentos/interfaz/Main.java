package recordatoriomedicamentos.interfaz;

import recordatoriomedicamentos.modelo.*;
import recordatoriomedicamentos.negocio.RecuperacionContrasena;
import recordatoriomedicamentos.negocio.Sesion;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Main {

    static Scanner entrada = new Scanner(System.in);
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuario;
    static ArrayList<Medicamento> medicamentos = new ArrayList<>();

    public static void main(String[] args) {
        cargarDatosPredeterminados();
        int opcion;
        do {
            System.out.println("\nRECORDATORIO MEDICAMENTOS");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Recuperar usuario");
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
                    System.out.println("Vuelva pronto");
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    // DATOS PREDETERMINADOS

    public static void cargarDatosPredeterminados() {

        Usuario juan = new Usuario("Juan Pérez", "juan", "1234");
        usuarios.add(juan);

        medicamentos.add(new Medicamento("Paracetamol", "Tabletas", 30, "2028-01-10"));
        medicamentos.add(new Medicamento("Loratadina", "Tabletas", 20, "2028-02-15"));
        medicamentos.add(new Medicamento("Ibuprofeno", "Tabletas", 25, "2028-03-20"));
    }

    // MÓDULO 1: INICIO DE SESIÓN Y USUARIOS

    public static void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = entrada.nextLine();

        usuario = null;

        for (Usuario u : usuarios) {
            if (u.validarCredenciales(nombreUsuario, contrasena)) {
                usuario = u;
                break;
            }
        }

        if (usuario != null) {
            System.out.println("\nBienvenido, " + usuario.getNombreCompleto());

            Sesion sesion = new Sesion(LocalDateTime.now().toString());
            sesion.setNombreUsuario(usuario.getNombreUsuario());
            sesion.iniciarSesion();

            usuario.getSesiones().add(sesion);

            menuPrincipal();
            sesion.cerrarSesion();
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos");
        }
    }

    public static void registrarUsuario() {
        System.out.print("Ingrese su nombre completo: ");
        String nombreCompleto = entrada.nextLine();

        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = entrada.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = entrada.nextLine();

        Usuario nuevoUsuario = new Usuario(nombreCompleto, nombreUsuario, contrasena);
        usuarios.add(nuevoUsuario);

        System.out.println("Usuario registrado correctamente.");
    }

    public static void recuperarUsuario() {
        System.out.print("Ingrese su nombre de usuario actual: ");
        String nombreUsuario = entrada.nextLine();
        Usuario usuarioEncontrado = null;

        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            System.out.println("\n¿Qué desea cambiar?");
            System.out.println("1. Nombre de usuario");
            System.out.println("2. Contraseña");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(entrada.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nuevo nombre de usuario: ");
                    String nuevoNombreUsuario = entrada.nextLine();

                    usuarioEncontrado.setNombreUsuario(nuevoNombreUsuario);

                    System.out.println("Nombre de usuario actualizado correctamente");
                    break;

                case 2:
                    System.out.print("Ingrese la nueva contraseña: ");
                    String nuevaContrasena = entrada.nextLine();

                    usuarioEncontrado.cambiarContrasena(nuevaContrasena);

                    System.out.println("Contraseña actualizada correctamente");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } else {
            System.out.println("El nombre de usuario no existe");
        }
    }

    // MENÚ PRINCIPAL

    public static void menuPrincipal() {
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
                    System.out.println("Sesión cerrada.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);
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

            opcion = Integer.parseInt(entrada.nextLine());
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
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 7);
    }

    public static void registrarMedicamento() {
        System.out.print("Nombre del medicamento: ");
        String nombre = entrada.nextLine();

        System.out.print("Unidad de medida: ");
        String unidad = entrada.nextLine();

        System.out.print("Cantidad disponible: ");
        int cantidad = Integer.parseInt(entrada.nextLine());

        System.out.print("Fecha de caducidad (AAAA-MM-DD): ");
        String fechaCaducidad = entrada.nextLine();

        if (nombre.trim().isEmpty() || unidad.trim().isEmpty()
                || cantidad < 0 || fechaCaducidad.trim().isEmpty()) {
            System.out.println("Datos no válidos.");
            return;
        }

        Medicamento medicamento = new Medicamento(nombre, unidad, cantidad, fechaCaducidad);
        medicamentos.add(medicamento);

        System.out.println("Medicamento registrado correctamente");
    }

    public static void consultarMedicamentos() {
        System.out.println("\nMEDICAMENTOS REGISTRADOS");

        for (Medicamento medicamento : medicamentos) {
            if (medicamento.isEstado()) {
                medicamento.consultarMedicamento();
                System.out.println("-------------------------");
            }
        }
    }

    public static void modificarMedicamento() {
        Medicamento medicamento = buscarMedicamento();

        if (medicamento != null) {
            System.out.print("Nuevo nombre: ");
            String nombre = entrada.nextLine();

            System.out.print("Nueva unidad de medida: ");
            String unidad = entrada.nextLine();

            System.out.print("Nueva fecha de caducidad (AAAA-MM-DD): ");
            String fechaCaducidad = entrada.nextLine();

            if (nombre.trim().isEmpty() || unidad.trim().isEmpty()
                    || fechaCaducidad.trim().isEmpty()) {
                System.out.println("Datos no válidos.");
                return;
            }

            medicamento.modificarMedicamento(nombre, unidad);
            medicamento.setFechaCaducidad(fechaCaducidad);

            System.out.println("Medicamento modificado correctamente.");
        }
    }

    public static void eliminarMedicamento() {
        Medicamento medicamento = buscarMedicamento();

        if (medicamento != null) {
            medicamento.eliminarMedicamento();

            System.out.println("Medicamento eliminado correctamente.");
        }
    }

    public static void agregarCantidad() {
        Medicamento medicamento = buscarMedicamento();

        if (medicamento != null) {
            System.out.print("Cantidad que desea agregar: ");
            int cantidad = Integer.parseInt(entrada.nextLine());

            if (cantidad > 0) {
                medicamento.agregarCantidad(cantidad);

                System.out.println("Cantidad actualizada correctamente.");
                System.out.println("Cantidad disponible: " + medicamento.getCantidad());
            } else {
                System.out.println("Ingrese una cantidad mayor que cero.");
            }
        }
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

        System.out.print("Fecha de inicio: ");
        String fechaInicio = entrada.nextLine();

        System.out.print("Fecha de finalización: ");
        String fechaFin = entrada.nextLine();

        Tratamiento tratamiento = new Tratamiento(
                nombre, fechaInicio, fechaFin
        );

        if (medicamentos.isEmpty()) {
            System.out.println("No hay medicamentos registrados.");
            return;
        }

        System.out.println("\nMEDICAMENTOS DISPONIBLES");

        for (int i = 0; i < medicamentos.size(); i++) {
            Medicamento medicamento = medicamentos.get(i);

            if (medicamento.isEstado()) {
                System.out.println((i + 1) + ". "
                        + medicamento.getNombreMedicamento());
            }
        }

        boolean continuar = true;
        boolean medicamentoAgregado = false;

        while (continuar) {

            System.out.print("\nSeleccione el número del medicamento: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion < 1 || opcion > medicamentos.size()) {
                System.out.println("Selección no válida.");
                continue;
            }

            Medicamento medicamento = medicamentos.get(opcion - 1);

            if (!medicamento.isEstado()) {
                System.out.println("Medicamento no disponible.");
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

            System.out.println("Tratamiento registrado correctamente");
        } else {
            System.out.println("No se registró el tratamiento");
        }
    }

    public static void consultarTratamientos() {
        System.out.println("\nTRATAMIENTOS REGISTRADOS");

        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados");
            return;
        }

        for (int i = 0; i < usuario.getTratamientos().size(); i++) {

            Tratamiento tratamiento = usuario.getTratamientos().get(i);

            System.out.println("\nTratamiento " + (i + 1));
            tratamiento.consultarTratamiento();

            System.out.println("Medicamentos:");

            for (int j = 0; j < tratamiento.getMedicamentos().size(); j++) {
                System.out.println((j + 1) + ". "
                        + tratamiento.getMedicamentos().get(j)
                        .getNombreMedicamento());
            }
        }
    }

    public static void modificarTratamiento() {
        System.out.println("\nMODIFICAR TRATAMIENTO");

        if (usuario.getTratamientos().isEmpty()) {
            System.out.println("No hay tratamientos registrados.");
            return;
        }

        for (int i = 0; i < usuario.getTratamientos().size(); i++) {
            System.out.println((i + 1) + ". "
                    + usuario.getTratamientos().get(i).getNombreTratamiento());
        }

        System.out.print("\nSeleccione el tratamiento que desea modificar: ");
        int opcion = entrada.nextInt();
        entrada.nextLine();

        if (opcion < 1 || opcion > usuario.getTratamientos().size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Tratamiento tratamiento = usuario.getTratamientos().get(opcion - 1);

        System.out.print("Nuevo nombre del tratamiento: ");
        String nombre = entrada.nextLine();

        System.out.print("Nueva fecha de inicio: ");
        String fechaInicio = entrada.nextLine();

        System.out.print("Nueva fecha de finalización: ");
        String fechaFin = entrada.nextLine();

        tratamiento.modificarTratamiento(nombre, fechaInicio, fechaFin);

        System.out.println("Tratamiento modificado correctamente.");
    }

    public static void consultarProgramaciones() {
        System.out.println("\n--- PROGRAMACIONES REGISTRADAS ---");
        boolean encontrado = false;

        for (int i = 0; i < medicamentos.size(); i++) {

            Medicamento medicamento = medicamentos.get(i);
            if (medicamento.isEstado()) {
                for (int j = 0; j < medicamento.getHorarios().size(); j++) {

                    Horario horario = medicamento.getHorarios().get(j);
                    System.out.println("\nMedicamento: " + medicamento.getNombreMedicamento());

                    horario.consultarProgramaciones();
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            System.out.println("No hay programaciones registradas.");
        }
    }

    public static void programarToma() {
        Medicamento medicamento = buscarMedicamento();

        if (medicamento == null) {
            return;
        }

        if (medicamento.getHorarios().isEmpty()) {
            System.out.println("El medicamento no tiene horarios configurados.");
            return;
        }

        System.out.println("\nHORARIOS DISPONIBLES");

        for (int i = 0; i < medicamento.getHorarios().size(); i++) {
            Horario horario = medicamento.getHorarios().get(i);
            System.out.println(i + ". " + horario.getHoraAdministracion()
                    + " - " + horario.getFrecuencia());
        }

        System.out.print("Seleccione un horario: ");
        int indice = Integer.parseInt(entrada.nextLine());

        if (indice < 0 || indice >= medicamento.getHorarios().size()) {
            System.out.println("Horario no válido.");
            return;
        }

        Horario horario = medicamento.getHorarios().get(indice);

        System.out.print("Fecha programada (AAAA-MM-DD): ");
        String fecha = entrada.nextLine();

        System.out.print("Hora programada (HH:MM): ");
        String hora = entrada.nextLine();

        HoraProgramacion programacion = new HoraProgramacion(fecha, hora);

        horario.getProgramaciones().add(programacion);
        programacion.programarToma();

        System.out.println("Toma programada correctamente.");
    }

    // MÓDULO 4: RECORDATORIOS Y REGISTRO DE TOMAS

    public static void menuRecordatorios() {
        int opcion;
        do {
            System.out.println("\nRECORDATORIOS Y REGISTRO DE TOMAS");
            System.out.println("1. Programar recordatorio");
            System.out.println("2. Consultar recordatorios");
            System.out.println("3. Registrar toma");
            System.out.println("4. Consultar historial de administración");
            System.out.println("5. Filtrar historial por estado");
            System.out.println("6. Filtrar historial por fecha");
            System.out.println("7. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(entrada.nextLine());
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
                    usuario.getHistorial().consultarHistorial();
                    break;
                case 5:
                    filtrarHistorialEstado();
                    break;
                case 6:
                    filtrarHistorialFecha();
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);
    }

    public static void programarRecordatorio() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nPROGRAMAR RECORDATORIO");

        Medicamento medicamento = buscarMedicamento();

        if (medicamento == null) {
            System.out.println("No se encontró el medicamento");
            return;
        }

        if (medicamento.getHorarios().isEmpty()) {
            System.out.println("Este medicamento no tiene horarios registrados");
            return;
        }

        System.out.println("\nSeleccione un horario:");

        for (int i = 0; i < medicamento.getHorarios().size(); i++) {
            Horario horario = medicamento.getHorarios().get(i);

            System.out.println((i + 1) + ". Hora: "
                    + horario.getHoraAdministracion());
            System.out.println("\nFrecuencia (Horas): " + horario.getFrecuencia());
            System.out.println("\nDías: " + horario.getDiasSemana());
        }

        System.out.print("\nIngrese el número del horario: ");
        int opcionHorario = Integer.parseInt(entrada.nextLine());

        if (opcionHorario < 1 ||
                opcionHorario > medicamento.getHorarios().size()) {
            System.out.println("Opción de horario no válida.");
            return;
        }

        Horario horarioSeleccionado =
                medicamento.getHorarios().get(opcionHorario - 1);

        Recordatorio recordatorio = new Recordatorio(
                medicamento.getNombreMedicamento(),
                horarioSeleccionado.getHoraAdministracion(),
                horarioSeleccionado.getFrecuencia()
        );

        recordatorio.programarRecordatorio();

        System.out.println("Recordatorio programado correctamente.");
    }

    public static void consultarRecordatorios() {
        System.out.println("\nRECORDATORIOS REGISTRADOS");

        for (Tratamiento tratamiento : usuario.getTratamientos()) {
            for (Medicamento medicamento : tratamiento.getMedicamentos()) {
                for (Horario horario : medicamento.getHorarios()) {
                    for (HoraProgramacion programacion : horario.getProgramaciones()) {
                        for (Recordatorio recordatorio : programacion.getRecordatorios()) {

                            System.out.println("Medicamento: "
                                    + recordatorio.getNombreTratamiento());
                            System.out.println("Hora: "
                                    + recordatorio.getHoraProgramada());
                            System.out.println("Frecuencia: "
                                    + recordatorio.getFrecuencia());
                            System.out.println("Estado:");
                            recordatorio.verificarEstado();
                            System.out.println("-------------------------");
                        }
                    }
                }
            }
        }
    }

    public static void registrarToma() {
        Medicamento medicamento = buscarMedicamento();

        if (medicamento == null) {
            return;
        }

        System.out.println("\n--- ESTADO DE LA TOMA ---");
        System.out.println("1. Realizada");
        System.out.println("2. Omitida");
        System.out.println("3. Pendiente");
        System.out.print("Seleccione una opción: ");

        int opcion = Integer.parseInt(entrada.nextLine());

        String estado;

        switch (opcion) {
            case 1:
                estado = "Realizada";
                break;
            case 2:
                estado = "Omitida";
                break;
            case 3:
                estado = "Pendiente";
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }
        int cantidad = 0;

        if (estado.equals("Realizada")) {
            System.out.print("Cantidad administrada: ");
            cantidad = Integer.parseInt(entrada.nextLine());

            if (cantidad <= 0 || cantidad > medicamento.getCantidad()) {
                System.out.println("Cantidad no disponible");
                return;
            }
            medicamento.descontarCantidad(cantidad);
        }

        RegistroToma registro = new RegistroToma();

        registro.setMedicamento(medicamento);
        registro.setEstadoToma(estado);
        registro.setFechaHoraReal(LocalDateTime.now().toString());
        registro.setCantidadAdministrada(cantidad);

        System.out.print("Observación: ");
        registro.setObservacion(entrada.nextLine());

        registro.registrarToma();

        usuario.getHistorial().registrarRegistro(registro);

        System.out.println("Toma registrada correctamente.");
        System.out.println("Cantidad disponible: " + medicamento.getCantidad());
    }

    public static void filtrarHistorialFecha() {
        System.out.print("Ingrese la fecha inicial (AAAA-MM-DD): ");
        String fechaDesde = entrada.nextLine();

        System.out.print("Ingrese la fecha final (AAAA-MM-DD): ");
        String fechaHasta = entrada.nextLine();

        usuario.getHistorial().filtrarPorFecha(fechaDesde, fechaHasta);
    }

    public static void filtrarHistorialEstado() {
        System.out.print("Ingrese el estado (Realizada, Omitida o Pendiente): ");
        String estado = entrada.nextLine();

        usuario.getHistorial().filtrarPorEstado(estado);
    }
}