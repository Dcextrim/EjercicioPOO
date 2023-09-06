import java.util.ArrayList;
import java.util.List;

public class Sede {
    // Propiedades
    private String nombreSede;
    private ArrayList<Estudiante> estudiantes;

    // Constructor
    public Sede(String nombreSede) {
        this.nombreSede = nombreSede;
        this.estudiantes = new ArrayList<>();
    }

    // Métodos Getter y Setter
    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    // Método para registrar un estudiante en la sede
    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    // Método para calcular las estadísticas de los exámenes de los estudiantes en la sede
    public List<String> calcularEstadisticasExamenes() {
        List<String> estadisticas = new ArrayList<>();

        // Verificar si hay estudiantes en la sede
        if (estudiantes.isEmpty()) {
            return estadisticas;
        }

        // Listas para almacenar las notas de cada examen
        List<Double> notasMatematica = new ArrayList<>();
        List<Double> notasLenguaje = new ArrayList<>();
        List<Double> notasQuimica = new ArrayList<>();
        List<Double> notasFisica = new ArrayList<>();
        List<Double> notasComprensionLectora = new ArrayList<>();
        List<Double> notasEstadistica = new ArrayList<>();

        // Calcular las estadísticas para cada examen
        for (Estudiante estudiante : estudiantes) {
            for (Examen examen : estudiante.getListaExamenes()) {
                String nombreExamen = examen.getNombreExamen();
                double nota = examen.getNotaExamen();

                switch (nombreExamen) {
                    case "Matematica":
                        notasMatematica.add(nota);
                        break;
                    case "Lenguaje":
                        notasLenguaje.add(nota);
                        break;
                    case "Quimica":
                        notasQuimica.add(nota);
                        break;
                    case "Fisica":
                        notasFisica.add(nota);
                        break;
                    case "Comprension Lectora":
                        notasComprensionLectora.add(nota);
                        break;
                    case "Estadística":
                        notasEstadistica.add(nota);
                        break;
                }
            }
        }

        // Calcular el promedio para cada examen
        estadisticas.add("Matemática - Promedio: " + calcularPromedio(notasMatematica));
        estadisticas.add("Lenguaje - Promedio: " + calcularPromedio(notasLenguaje));
        estadisticas.add("Química - Promedio: " + calcularPromedio(notasQuimica));
        estadisticas.add("Física - Promedio: " + calcularPromedio(notasFisica));
        estadisticas.add("Comprensión Lectora - Promedio: " + calcularPromedio(notasComprensionLectora));
        estadisticas.add("Estadística - Promedio: " + calcularPromedio(notasEstadistica));

        return estadisticas;
    }

    // Método para calcular el promedio de una lista de notas
    private double calcularPromedio(List<Double> notas) {
        if (notas.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        for (double nota : notas) {
            suma += nota;
        }

        return suma / notas.size();
    }
}
