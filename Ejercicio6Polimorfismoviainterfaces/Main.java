import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que contiene el método main para ejecutar el programa.
 */
public class Main {
    /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Código principal del programa
        // Crea el controlador de dispositivos
        ControladorDispositivo controlador = new ControladorDispositivo();
        controlador.cargarDispositivosDesdeCSV("Productos.csv");

        // Menú de opciones
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- Menú de Opciones -----");
            System.out.println("1. Mostrar estado actual de un dispositivo");
            System.out.println("2. Encontrar dispositivo más caro");
            System.out.println("3. Encontrar dispositivo más barato");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                System.out.print("Ingrese el índice del dispositivo: ");
                int indice = scanner.nextInt();
                List<DispositivoBase> dispositivos = controlador.getDispositivos(); // Obtener la lista de dispositivos
                if (indice >= 0 && indice < dispositivos.size()) {
                    // Menú de opciones adicionales
                    int opcionSubMenu;
                    do {
                        controlador.mostrarEstadoActual(dispositivos.get(indice)); // Mostrar estado actual
                        System.out.println("----- Opciones adicionales -----");
                        System.out.println("1. Subir Volumen");
                        System.out.println("2. Bajar Volumen");
                        System.out.println("3. Aumentar Brillo");
                        System.out.println("4. Disminuir Brillo");
                        System.out.println("5. Volver al menú principal");
                        System.out.print("Ingrese la opción: ");
                        opcionSubMenu = scanner.nextInt();
            
                        switch (opcionSubMenu) {
                            case 1:
                                // Subir volumen
                                dispositivos.get(indice).subirVolumen();
                                break;
                            case 2:
                                // Bajar volumen
                                dispositivos.get(indice).bajarVolumen();
                                break;
                            case 3:
                                // Aumentar brillo
                                dispositivos.get(indice).aumentarBrillo();
                                break;
                            case 4:
                                // Disminuir brillo
                                dispositivos.get(indice).disminuirBrillo();
                                break;
                            case 5:
                                System.out.println("Volviendo al menú principal.");
                                break;
                            default:
                                System.out.println("Opción no válida. Inténtelo de nuevo.");
                                break;
                        }
                    } while (opcionSubMenu != 5);
                } else {
                    System.out.println("Índice no válido.");
                }
                break;
                case 2:
                    DispositivoBase masCaro = controlador.dispositivoMasCaro();
                    System.out.println("El dispositivo más caro es:");
                    controlador.mostrarEstadoActual(masCaro);
                    break;
                case 3:
                    DispositivoBase masBarato = controlador.dispositivoMasBarato();
                    System.out.println("El dispositivo más barato es:");
                    controlador.mostrarEstadoActual(masBarato);
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }
}
