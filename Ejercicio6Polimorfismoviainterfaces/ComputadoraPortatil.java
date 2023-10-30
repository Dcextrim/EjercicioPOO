/**
 * Clase que representa una computadora portátil, hereda de DispositivoBase.
 */
public class ComputadoraPortatil extends DispositivoBase {
    // Atributos específicos de las computadoras portátiles
    private int ram;
    private String tipoDiscoDuro;
    private int velocidadCPU;
    private int velocidadGPU;
    
/**
     * Constructor de la clase ComputadoraPortatil.
     * @param precio Precio de la computadora portátil.
     * @param marca Marca de la computadora portátil.
     * @param modelo Modelo de la computadora portátil.
     * @param cuotas Cuotas permitidas para la compra.
     * @param ram Cantidad de RAM en GB.
     * @param tipoDiscoDuro Tipo de disco duro (HDD o SSD).
     * @param velocidadCPU Velocidad del CPU.
     * @param velocidadGPU Velocidad del GPU.
     */
    public ComputadoraPortatil(
        double precio, String marca, String modelo, int cuotas,
        int ram, String tipoDiscoDuro, int velocidadCPU, int velocidadGPU
    ) {
        super(precio, marca, modelo, cuotas);
        this.ram = ram;
        this.tipoDiscoDuro = tipoDiscoDuro;
        this.velocidadCPU = velocidadCPU;
        this.velocidadGPU = velocidadGPU;
    }

    public int getRAM() {
        return ram;
    }

    public String getTipoDiscoDuro() {
        return tipoDiscoDuro;
    }

    public int getVelocidadCPU() {
        return velocidadCPU;
    }

    public int getVelocidadGPU() {
        return velocidadGPU;
    }

}
