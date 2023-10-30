/**
 * Clase base abstracta para dispositivos electrónicos con implementación parcial de la interfaz DispositivoElectronico
 * y capacidad de comparación para determinar el dispositivo más caro o más barato.
 */
public abstract class DispositivoBase implements DispositivoElectronico, Comparable<DispositivoBase> {
    // Atributos comunes a los dispositivos electrónicos
    private double precio;
    private String marca;
    private String modelo;
    private int cuotas;
    private boolean encendido;
    private int volumen;
    private int brillo;
    private int videoActual;

    /**
     * Constructor de la clase DispositivoBase.
     * @param precio Precio del dispositivo.
     * @param marca Marca del dispositivo.
     * @param modelo Modelo del dispositivo.
     * @param cuotas Cuotas permitidas para la compra.
     */
    public DispositivoBase(double precio, String marca, String modelo, int cuotas) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.cuotas = cuotas;
        this.encendido = false;
        this.videoActual = 1;
        this.volumen = 50;
        this.brillo = 50;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCuotas() {
        return cuotas;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public int videoActual() {
        return videoActual;
    }

    public int getVolumen() {
        return volumen;
    }

    public int getBrillo() {
        return brillo;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public void subirVolumen() {
        volumen += (this instanceof TelefonoInteligente) ? 2 : 10;
        if (volumen > 100) {
            volumen = 100;
        }
    }

    public void bajarVolumen() {
        volumen -= (this instanceof TelefonoInteligente) ? 2 : 10;
        if (volumen < 0) {
            volumen = 0;
        }
    }

    public void aumentarBrillo() {
        brillo += (this instanceof TelefonoInteligente) ? 3 : 5;
        if (brillo > 100) {
            brillo = 100;
        }
    }

    public void disminuirBrillo() {
        brillo -= (this instanceof TelefonoInteligente) ? 3 : 5;
        if (brillo < 0) {
            brillo = 0;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);

    }

    public void mostrarEstadoActual() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Encendido: " + encendido);
        System.out.println("Número de Video: " + videoActual);
        System.out.println("Volumen: " + volumen);
        System.out.println("Brillo: " + brillo);
        System.out.println("Precio: $" + precio);
        System.out.println("Cuotas permitidas: " + cuotas);
    }

    public void controlarVideosPublicitarios() {
        // Controlar videos publicitarios
        if (encendido) {
            videoActual = (videoActual % ((this instanceof TelefonoInteligente) ? 3 : 5)) + 1;
            System.out.println("Reproduciendo video " + videoActual);
        } else {
            System.out.println("El dispositivo está apagado. Enciéndelo para reproducir videos.");
        }
    }

    /**
     * Método de comparación para determinar el dispositivo más caro o más barato.
     * @param otroDispositivo Otro dispositivo a comparar.
     * @return Valor negativo si este dispositivo es más barato, valor positivo si es más caro, 0 si son iguales.
     */
    @Override
    public int compareTo(DispositivoBase otroDispositivo) {
        return Double.compare(this.precio, otroDispositivo.getPrecio());
    }
}
