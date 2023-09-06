public class Examen {
    // Propiedades
    private String nombreExamen;
    private double notaExamen;

    // Constructor
    public Examen(String nombreExamen, double notaExamen) {
        this.nombreExamen = nombreExamen;
        this.notaExamen = notaExamen;
    }

    // Métodos Getter y Setter
    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    public void setNotaExamen(double notaExamen) {
        this.notaExamen = notaExamen;
    }
}
