/**
 * Interfaz que define las acciones que pueden realizar los dispositivos electrónicos.
 */
public interface DispositivoElectronico {
    // Métodos para controlar dispositivos
    void encender();
    void apagar();
    void subirVolumen();
    void bajarVolumen();
    void aumentarBrillo();
    void disminuirBrillo();
    void mostrarInformacion();
    void mostrarEstadoActual();
    void controlarVideosPublicitarios();
    double getPrecio();
}