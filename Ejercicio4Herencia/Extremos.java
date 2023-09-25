public class Extremos extends Jugador {
    private int pases;
    private int asistenciasEfectivas;

    public Extremos(String nombre, String pais, int faltas, int golesDirectos, int totalLanzamientos,
                   int pases, int asistenciasEfectivas) {
        super(nombre, pais, faltas, golesDirectos, totalLanzamientos);
        this.pases = pases;
        this.asistenciasEfectivas = asistenciasEfectivas;
    }

    // Getters y setters para Extremo
    public int getPases() {
        return pases;
    }

    public void setPases(int pases) {
        this.pases = pases;
    }

    public int getAsistenciasEfectivas() {
        return asistenciasEfectivas;
    }

    public void setAsistenciasEfectivas(int asistenciasEfectivas) {
        this.asistenciasEfectivas = asistenciasEfectivas;
    }

    // Método CalcularEfectividad en la clase Extremo (anula el método en la clase base)
    @Override
    public double calcularEfectividad() {
        double efectividad = ((pases + asistenciasEfectivas - faltas) * 100.0) /
                             (pases + asistenciasEfectivas + faltas);
        efectividad += (golesDirectos * 100.0) / totalLanzamientos;
        return efectividad;
    }

    // Método toString en la clase Extremo (anula el método en la clase base)
    @Override
    public String toString() {
        return super.toString() +
               "Pases: " + pases + "\n" +
               "Asistencias Efectivas: " + asistenciasEfectivas + "\n";
    }

    
}

