import java.util.ArrayList;

public class Estudiante {
    // Propiedades
    private String nombre;
    private String apellido;
    private String codigoUnico;
    private String fechaNacimiento;
    private String correoElectronico;
    private ArrayList<Examen> listaExamenes;

    // Constructor
    public Estudiante(String nombre, String apellido, String codigoUnico, String fechaNacimiento, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoUnico = codigoUnico;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.listaExamenes = new ArrayList<>();
    }

    // Métodos Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<Examen> getListaExamenes() {
        return listaExamenes;
    }

    // Método para agregar un examen a la lista de exámenes realizados por el estudiante
    public void agregarExamen(Examen examen) {
        listaExamenes.add(examen);
    }
}