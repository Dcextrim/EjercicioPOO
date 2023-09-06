import java.util.ArrayList;
import java.util.List;

public class Universidad {
    // Propiedades
    private List<Sede> sedes;

    // Constructor
    public Universidad() {
        this.sedes = new ArrayList<>();
    }

    // Método para agregar una nueva sede a la universidad
    public void agregarSede(Sede sede) {
        sedes.add(sede);
    }

    // Método para obtener todas las sedes de la universidad
    public List<Sede> obtenerSedes() {
        return sedes;
    }

    // Método para buscar un estudiante por código único en la universidad
    public Estudiante buscarEstudiantePorCodigo(String codigoEstudiante) {
        for (Sede sede : sedes) {
            for (Estudiante estudiante : sede.getEstudiantes()) {
                if (estudiante.getCodigoUnico().equalsIgnoreCase(codigoEstudiante)) {
                    return estudiante;
                }
            }
        }
        return null;
    }

    // Método para buscar una sede por nombre en la universidad
    public Sede buscarSedePorNombre(String nombreSede) {
        for (Sede sede : sedes) {
            if (sede.getNombreSede().equalsIgnoreCase(nombreSede)) {
                return sede;
            }
        }
        return null;
    }

    // Método para calcular las estadísticas generales de la universidad
    public List<String> calcularEstadisticasGenerales() {
        List<String> estadisticasGenerales = new ArrayList<>();
        int totalEstudiantes = 0;

        for (Sede sede : sedes) {
            totalEstudiantes += sede.getEstudiantes().size();
            List<String> estadisticasSede = sede.calcularEstadisticasExamenes();
            estadisticasGenerales.add("Estadísticas de la sede " + sede.getNombreSede() + ":");
            estadisticasGenerales.addAll(estadisticasSede);
        }

        estadisticasGenerales.add("Total de estudiantes en la universidad: " + totalEstudiantes);
        return estadisticasGenerales;
    }
}
