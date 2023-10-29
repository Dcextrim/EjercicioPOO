import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Tienda {
    private List<Producto> inventario;
    
    public Tienda() {
        this.inventario = new ArrayList<>();
    }
    
    // Método para cargar productos desde un archivo CSV
    public void cargarProductosDesdeCSV(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|"); // Separar los datos por el carácter '|'

                if (partes.length < 6) {
                    System.out.println("Error: Formato de línea CSV incorrecto");
                    continue;
                }

                int id = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                int cantidad_disponible = Integer.parseInt(partes[2].trim());
                int cantidad_vendidos = Integer.parseInt(partes[3].trim());
                Producto.Estado estado = Producto.Estado.valueOf(partes[4].trim());
                double precio = Double.parseDouble(partes[5].trim());

                // Detecta la categoría y crea el producto correspondiente
                if (partes.length >= 7) {
                    String categoria = partes[6].trim();
                    switch (categoria) {
                        case "Bebidas":
                            if (partes.length >= 8 && partes.length >= 9) {
                                int ml = Integer.parseInt(partes[7].trim());
                                Bebida.Tipo tipo = Bebida.Tipo.valueOf(partes[8].trim());
                                inventario.add(new Bebida(id, nombre, cantidad_disponible, cantidad_vendidos, estado, precio, ml, tipo));
                            }
                            break;
                        case "Snacks":
                            if (partes.length >= 10) {
                                int gramos = Integer.parseInt(partes[7].trim());
                                Snack.Sabor sabor = Snack.Sabor.valueOf(partes[8].trim());
                                Snack.Tamaño tamaño = Snack.Tamaño.valueOf(partes[9].trim());
                                inventario.add(new Snack(id, nombre, cantidad_disponible, cantidad_vendidos, estado, precio, gramos, sabor, tamaño));
                            }
                            break;
                        case "Pan":
                            if (partes.length >= 8) {
                                Pan.Clase clase = Pan.Clase.valueOf(partes[7].trim());
                                inventario.add(new Pan(id, nombre, cantidad_disponible, cantidad_vendidos, estado, precio, clase));
                            }
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar un producto por ID
    public Producto buscarProductoPorID(int id) {
        for (Producto producto : inventario) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Producto no encontrado
    }
    
    // Método para listar productos de una categoría
    public List<Producto> listarProductosPorCategoria(String categoria) {
        List<Producto> productosPorCategoria = new ArrayList<>();
        for (Producto producto : inventario) {
            if (producto instanceof Bebida && categoria.equalsIgnoreCase("Bebidas")) {
                productosPorCategoria.add(producto);
            } else if (producto instanceof Snack && categoria.equalsIgnoreCase("Snacks")) {
                productosPorCategoria.add(producto);
            }else if (producto instanceof Pan && categoria.equalsIgnoreCase("Pan")){
                productosPorCategoria.add(producto);
            }
        }
        return productosPorCategoria;
    }
    
    // Método para calcular el total de ventas
    public double calcularTotalVentas() {
        double totalVentas = 0;
        for (Producto producto : inventario) {
            totalVentas += producto.getCantidad_vendidos() * producto.getPrecio();
        }
        return totalVentas;
    }
    
    // Método para calcular la comisión por categoría
public Map<String, Double> calcularComisionPorCategoria() {
    Map<String, Double> comisionesPorCategoria = new HashMap<>();
    for (Producto producto : inventario) {
        if (producto instanceof Bebida) {
            double comision = 0.20 * producto.getPrecio() * producto.getCantidad_vendidos();
            comisionesPorCategoria.put("Bebidas", comision);
        } else if (producto instanceof Snack) {
            double comision = 0.20 * producto.getPrecio() * producto.getCantidad_vendidos();
            comisionesPorCategoria.put("Snacks", comision);
        } else if (producto instanceof Pan) {
            double comision = 0.20 * producto.getPrecio() * producto.getCantidad_vendidos();
            comisionesPorCategoria.put("Pan", comision);
        }
    }
    return comisionesPorCategoria;
}
}
