import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato(); // Crear una instancia de Campeonato

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú Principal");
            System.out.println("1. Mostrar Jugadores");
            System.out.println("2. Mostrar Mejores Porteros");
            System.out.println("3. Contar Extremos con más de 85% de efectividad");
            System.out.println("4.Agregar Jugador");
            System.out.println("5. Salir");
            System.out.print("Ingrese su elección: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    campeonato.mostrarJugadores();
                    break;
                case 2:
                    campeonato.mejoresPorteros();
                    break;
                case 3:
                    int cantidadExtremos = campeonato.extremos85();
                    System.out.println("Cantidad de extremos con más de 85% de efectividad: " + cantidadExtremos);
                    break;
                    case 4:
                    // Agregar un nuevo jugador
                    System.out.println("Ingrese los datos del nuevo jugador:");
                    System.out.print("Nombre: ");
                    String nombreNuevo = scanner.next();
                    System.out.print("País: ");
                    String paisNuevo = scanner.next();
                    System.out.print("Faltas: ");
                    int faltasNuevo = scanner.nextInt();
                    System.out.print("Goles Directos: ");
                    int golesDirectosNuevo = scanner.nextInt();
                    System.out.print("Total de Lanzamientos: ");
                    int totalLanzamientosNuevo = scanner.nextInt();
                
                    // Determinar si el jugador es Portero o Extremo
                    System.out.print("¿Es un Portero? (S/N): ");
                    String esPortero = scanner.next().toLowerCase();
                    
                    if (esPortero.equals("s")) {
                        System.out.print("Paradas Efectivas: ");
                        int paradasEfectivasNuevo = scanner.nextInt();
                        System.out.print("Goles Recibidos: ");
                        int golesRecibidosNuevo = scanner.nextInt();
                        
                        Porteros nuevoPortero = new Porteros(nombreNuevo, paisNuevo, faltasNuevo, golesDirectosNuevo,
                                                           totalLanzamientosNuevo, paradasEfectivasNuevo, golesRecibidosNuevo);
                        campeonato.agregarPortero(nuevoPortero);
                    } else {
                        System.out.print("Pases: ");
                        int pasesNuevo = scanner.nextInt();
                        System.out.print("Asistencias Efectivas: ");
                        int asistenciasEfectivasNuevo = scanner.nextInt();
                        
                        Extremos nuevoExtremo = new Extremos(nombreNuevo, paisNuevo, faltasNuevo, golesDirectosNuevo,
                                                           totalLanzamientosNuevo, pasesNuevo, asistenciasEfectivasNuevo);
                        campeonato.agregarExtremo(nuevoExtremo);
                    }
                    break;
                
                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
    }
}

