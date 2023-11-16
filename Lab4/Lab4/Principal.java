import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kayac kayac = new Kayac();

        // Cargar datos desde archivos CSV
        kayac.leerUsuario();
        kayac.leerReserva();

        boolean salir = false;
        while (!salir) {
            System.out.println("********** Menú Principal **********");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su nombre de usuario: ");
                    String username = scanner.nextLine();
                    System.out.print("Ingrese su contraseña: ");
                    String password = scanner.nextLine();
                    Usuario usuario = kayac.login(username, password);
                    if (usuario != null) {
                        menuUsuario(scanner, kayac, usuario);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese un nuevo nombre de usuario: ");
                    String nuevoUsername = scanner.nextLine();
                    System.out.print("Ingrese una nueva contraseña: ");
                    String nuevoPassword = scanner.nextLine();
                    System.out.print("Seleccione un plan (base o premium): ");
                    String tipo = scanner.nextLine();
                    kayac.registroUsuario(nuevoUsername, nuevoPassword, tipo);
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        // Guardar datos en archivos CSV antes de salir
        kayac.guardarUsuario();
        kayac.guardarReserva();

        System.out.println("¡Hasta luego!");
    }

    private static void menuUsuario(Scanner scanner, Kayac kayac, Usuario usuario) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n********** Menú de Usuario **********");
            System.out.println("1. Realizar Reserva");
            System.out.println("2. Confirmar Reserva");
            System.out.println("3. Ver Itinerario");
            System.out.println("4. Cambiar Contraseña");
            System.out.println("5. Cambiar de Plan a Premium");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la fecha de vuelo (dd/mm/yyyy): ");
                    String fechaVuelo = scanner.nextLine();
                    System.out.print("¿Es un vuelo de ida y vuelta? (true/false): ");
                    boolean tipoVuelo = scanner.nextBoolean();
                    System.out.print("Ingrese la cantidad de boletos: ");
                    int cantidadBoletos = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese la aerolínea: ");
                    String aerolinea = scanner.nextLine();
                    kayac.reservacion(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, usuario.getUsername());
                    break;
                case 2:
                    System.out.print("Ingrese el número de tarjeta: ");
                    String numeroTarjeta = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de cuotas (1-24): ");
                    int cuotas = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese la clase de vuelo (Coach/Primera Clase): ");
                    String claseVuelo = scanner.nextLine();
                    System.out.print("Ingrese el número de asiento: ");
                    String numeroAsiento = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de maletas: ");
                    int cantidadMaletas = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    kayac.confirmacion(numeroTarjeta, cuotas, claseVuelo, numeroAsiento, cantidadMaletas);
                    break;
                case 3:
                    System.out.println("Itinerario:");
                    String itinerario = kayac.itinerario();
                    System.out.println(itinerario);
                    break;
                case 4:
                    System.out.print("Ingrese la nueva contraseña: ");
                    String nuevaPassword = scanner.nextLine();
                    kayac.cambiarPassword(nuevaPassword);
                case 5:
                    kayac.cambiarTipoUsuario();
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }
}
