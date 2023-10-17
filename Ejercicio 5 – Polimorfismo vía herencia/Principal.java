import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú Principal");
            System.out.println("1. Ingresar jugador");
            System.out.println("2. Mostrar jugadores");
            System.out.println("3. Mostrar mejores líberos");
            System.out.println("4. Contar pasadores con efectividad mayor al 80%");
            System.out.println("5. Guardar catálogo en archivo");
            System.out.println("6. Cargar catálogo desde archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de la lectura del número

            switch (opcion) {
                case 1:
                    agregarJugador(torneo, scanner);
                    break;

                case 2:
                    torneo.mostrarJugadores();
                    break;

                case 3:
                    torneo.mostrarMejoresLiberos(3);
                    break;

                case 4:
                    torneo.contarPasadoresConEfectividad();
                    break;

                case 5:
                    torneo.guardarCSV("Jugadores.CSV");
                    System.out.println("Catálogo guardado en archivo 'Jugadores.CSV'.");
                    break;

                case 6:
                    torneo.cargarCSV("Jugadores.CSV");
                    System.out.println("Catálogo cargado desde archivo 'Jugadores.CSV'.");
                    break;

                case 0:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public static void agregarJugador(Torneo torneo, Scanner scanner) {
        System.out.println("Ingrese los datos del jugador:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("País: ");
        String pais = scanner.nextLine();
        System.out.print("Errores: ");
        int errores = scanner.nextInt();
        System.out.print("Aces: ");
        int aces = scanner.nextInt();
        System.out.print("Total de servicios: ");
        int totalServicios = scanner.nextInt();

        System.out.println("Seleccione el tipo de jugador:");
        System.out.println("1. Libero");
        System.out.println("2. Pasador");
        System.out.println("3. Auxiliar/Opuesto");
        int tipoJugador = scanner.nextInt();

        torneo.crearYAgregarJugador(tipoJugador, nombre, pais, errores, aces, totalServicios, scanner);
    }
}
