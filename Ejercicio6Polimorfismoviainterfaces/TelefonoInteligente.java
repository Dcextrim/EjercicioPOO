/**
 * Clase que representa un teléfono inteligente, hereda de DispositivoBase.
 */
public class TelefonoInteligente extends DispositivoBase {
    // Atributos específicos de los teléfonos inteligentes
    private int ram;
    private String procesador;
    private int almacenamientoInterno;
    private boolean admiteMicroUSB;
    private boolean incluyeCuboCargador;
    private boolean es5G;

    /**
     * Constructor de la clase TelefonoInteligente.
     * @param precio Precio del teléfono inteligente.
     * @param marca Marca del teléfono inteligente.
     * @param modelo Modelo del teléfono inteligente.
     * @param cuotas Cuotas permitidas para la compra.
     * @param ram Cantidad de RAM en GB.
     * @param procesador Procesador del teléfono.
     * @param almacenamiento Almacenamiento interno en GB.
     * @param admiteMicroUSB Si admite o no micro USB.
     * @param incluyeCuboCargador Si incluye o no el cubo cargador.
     * @param es5G Si es compatible con 5G.
     */
    public TelefonoInteligente(
        double precio, String marca, String modelo, int cuotas,
        int ram2, String procesador, int almacenamiento,
        boolean admiteMicroUSB, boolean incluyeCuboCargador, boolean es5G
    ) {
        super(precio, marca, modelo, cuotas);
        this.ram = ram2;
        this.procesador = procesador;
        this.almacenamientoInterno = almacenamiento;
        this.admiteMicroUSB = admiteMicroUSB;
        this.incluyeCuboCargador = incluyeCuboCargador;
        this.es5G = es5G;
    }

    

    public int getRAM() {
        return ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public int getAlmacenamientoInterno() {
        return almacenamientoInterno;
    }

    public boolean admiteMicroUSB() {
        return admiteMicroUSB;
    }

    public boolean incluyeCuboCargador() {
        return incluyeCuboCargador;
    }

    public boolean es5G() {
        return es5G;
    }

}
