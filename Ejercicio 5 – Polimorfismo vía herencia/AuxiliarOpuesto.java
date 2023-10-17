public class AuxiliarOpuesto extends Jugador {
    private int ataquesEfectivos;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalServicios, int ataquesEfectivos, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataquesEfectivos = ataquesEfectivos;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    public int getAtaquesEfectivos() {
        return ataquesEfectivos;
    }

    public void setAtaquesEfectivos(int ataquesEfectivos) {
        this.ataquesEfectivos = ataquesEfectivos;
    }

    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    // Método para calcular la efectividad específica para los jugadores Auxiliar/Opuesto
    @Override
    public double calcularEfectividad() {
        double efectividadGeneral = super.calcularEfectividad();
        return efectividadGeneral + ((ataquesEfectivos + bloqueosEfectivos - bloqueosFallidos - errores) * 100.0 / (ataquesEfectivos + bloqueosEfectivos + bloqueosFallidos + errores));
    }
}
