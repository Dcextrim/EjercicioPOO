public class Pasador extends Jugador {
    private int pases;
    private int fintasEfectivas;

    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintasEfectivas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintasEfectivas = fintasEfectivas;
    }

    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getFintasEfectivas() {
        return fintasEfectivas;
    }

    public void setFintasEfectivas(int fintasEfectivas) {
        this.fintasEfectivas = fintasEfectivas;
    }

    // Método para calcular la efectividad específica para los pasadores
    @Override
    public double calcularEfectividad() {
        double efectividadGeneral = super.calcularEfectividad();
        return efectividadGeneral + ((pases + fintasEfectivas - errores) * 100.0 / (pases + fintasEfectivas + errores));
    }
}
