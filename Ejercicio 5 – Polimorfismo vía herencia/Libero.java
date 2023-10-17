public class Libero extends Jugador {
    private int recibosEfectivos;

    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    
    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    // Método para calcular la efectividad específica para los líberos
    @Override
    public double calcularEfectividad() {
        double efectividadGeneral = super.calcularEfectividad();
        return efectividadGeneral + (recibosEfectivos * 100.0 / getTotalServicios());
    }
}