import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Cargar productos desde archivo CSV");
            System.out.println("2. Buscar producto por ID");
            System.out.println("3. Listar productos por categoría");
            System.out.println("4. Calcular total de ventas");
            System.out.println("5. Calcular comisión por categoría");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la ruta del archivo CSV: ");
                    String archivoCSV = scanner.nextLine();
                    tienda.cargarProductosDesdeCSV(archivoCSV);
                    System.out.println("Productos cargados correctamente.");
                    break;
                case 2:
                    System.out.print("Ingrese el ID del producto: ");
                    int idProducto = scanner.nextInt();
                    Producto productoEncontrado = tienda.buscarProductoPorID(idProducto);
                    if (productoEncontrado != null) {
                        System.out.println("Producto encontrado: " + productoEncontrado);
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese la categoría (Bebidas, Snacks, Pan, etc.): ");
                    String categoria = scanner.nextLine();
                    List<Producto> productosPorCategoria = tienda.listarProductosPorCategoria(categoria);
                    for (Producto producto : productosPorCategoria) {
                        System.out.println(producto);
                    }
                    break;
                case 4:
                    double totalVentas = tienda.calcularTotalVentas();
                    System.out.println("Total de ventas: Q" + totalVentas);
                    break;
                case 5:
                    System.out.println("Comisión por categoría:");
                    Map<String, Double> comisionesPorCategoria = tienda.calcularComisionPorCategoria();
                    for (Map.Entry<String, Double> entry : comisionesPorCategoria.entrySet()) {
                        System.out.println(entry.getKey() + ": Q" + entry.getValue());
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
