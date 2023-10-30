
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que controla los dispositivos electrónicos y permite realizar acciones sobre ellos.
 */
public class ControladorDispositivo {
    // Atributos de la clase ControladorDispositivo
    public List<DispositivoBase> dispositivos;
    public String csvFilePath="Producto.csv";

    public ControladorDispositivo(List<DispositivoBase> dispositivos) {
        this.dispositivos = dispositivos;
    }

    /**
     * Constructor de la clase ControladorDispositivo.
     */
    public ControladorDispositivo() {
        dispositivos = new ArrayList<>();
    }

    public void mostrarEstadoActual(DispositivoBase dispositivo) {
        dispositivo.mostrarEstadoActual();
    }

    public DispositivoBase dispositivoMasCaro() {
        return Collections.max(dispositivos);
    }

    public DispositivoBase dispositivoMasBarato() {
        return Collections.min(dispositivos);
    }

    public void cargarDispositivosDesdeCSV(String csvFilePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String linea;

            // Leer y descartar la primera línea (cabecera)
            reader.readLine();

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length >= 4) {
                    String tipo = datos[4];
                    if (tipo.equalsIgnoreCase("TelefonoInteligente")) {
                        if (datos.length >= 11) {
                            String marca = datos[0];
                            String modelo = datos[1];
                            double precio = Double.parseDouble(datos[2]);
                            int cuotas = Integer.parseInt(datos[3]);
                            int ram = Integer.parseInt(datos[5]);
                            String procesador = datos[6];
                            int almacenamiento = Integer.parseInt(datos[7]);
                            boolean admiteMicroUSB = Boolean.parseBoolean(datos[8]);
                            boolean incluyeCuboCargador = Boolean.parseBoolean(datos[9]);
                            boolean es5G = Boolean.parseBoolean(datos[10]);
    
                            DispositivoBase dispositivo = new TelefonoInteligente(precio, marca, modelo, cuotas, ram, procesador, almacenamiento, admiteMicroUSB, incluyeCuboCargador, es5G);
                            dispositivos.add(dispositivo);
                        } else {
                            System.out.println("Faltan atributos para crear un Teléfono Inteligente.");
                        }
                    } else if (tipo.equalsIgnoreCase("ComputadoraPortatil")) {
                        if (datos.length >= 11) {
                            String marca = datos[0];
                            String modelo = datos[1];
                            double precio = Double.parseDouble(datos[2]);
                            int cuotas = Integer.parseInt(datos[3]);
                            int ram = Integer.parseInt(datos[5]);
                            String tipoDiscoDuro = datos[6];
                            int velocidadCPU = Integer.parseInt(datos[7]);
                            int velocidadGPU = Integer.parseInt(datos[8]);
    
                            DispositivoBase dispositivo = new ComputadoraPortatil(precio, marca, modelo, cuotas, ram, tipoDiscoDuro, velocidadCPU, velocidadGPU);
                            dispositivos.add(dispositivo);
                        } else {
                            System.out.println("Faltan atributos para crear una Computadora Portátil.");
                        }
                    } else {
                        System.out.println("Tipo de dispositivo desconocido o no válido: " + tipo);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que devuelve la lista de dispositivos electrónicos.
     * @return Lista de dispositivos electrónicos.
     */
    public List<DispositivoBase> getDispositivos() {
        return dispositivos;
    }
}
