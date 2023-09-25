import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Campeonato {
    private List<Porteros> listaPorteros; // Lista para almacenar los porteros del campeonato
    private List<Extremos> listaExtremos; // Lista para almacenar los extremos del campeonato

    public Campeonato() {
        this.listaPorteros = new ArrayList<>();
        this.listaExtremos = new ArrayList<>();
    }

    // Método para agregar un portero al campeonato
    public void agregarPortero(Porteros portero) {
        listaPorteros.add(portero);
    }

    // Método para agregar un extremo al campeonato
    public void agregarExtremo(Extremos extremo) {
        listaExtremos.add(extremo);
    }

    // Método para mostrar todos los jugadores registrados en el campeonato
    public void mostrarJugadores() {
        System.out.println("Porteros registrados:");
        for (Porteros portero : listaPorteros) {
            System.out.println(portero.toString());
        }

        System.out.println("Extremos registrados:");
        for (Extremos extremo : listaExtremos) {
            System.out.println(extremo.toString());
        }
    }

    // Método para encontrar y mostrar los 3 mejores porteros según su efectividad
    public void mejoresPorteros() {
        Collections.sort(listaPorteros, Comparator.comparingDouble(Porteros::calcularEfectividad).reversed());

        System.out.println("Los 3 mejores porteros:");

        for (int i = 0; i < Math.min(listaPorteros.size(), 3); i++) {
            System.out.println(listaPorteros.get(i).toString());
        }
    }

    // Método para contar la cantidad de extremos con más del 85% de efectividad
    public int extremos85() {
        int contador = 0;

        for (Extremos extremo : listaExtremos) {
            double efectividad = extremo.calcularEfectividad();
            if (efectividad > 85.0) {
                contador++;
            }
        }
        return contador;
    }
}



