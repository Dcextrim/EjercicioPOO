public class Curso {
    private String codigo;
    private String nombre;
    private int cantidadPeriodos;
    private String[] diasSemana;
    private String horario;
    private int cantidadEstudiantes;
    private Profesor profesor;

    // Constructor
    public Curso(String codigo, String nombre, int cantidadPeriodos, String[] diasSemana, String horario,
                 int cantidadEstudiantes, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadPeriodos = cantidadPeriodos;
        this.diasSemana = diasSemana;
        this.horario = horario;
        this.cantidadEstudiantes = cantidadEstudiantes;
        this.profesor = profesor;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPeriodos() {
        return cantidadPeriodos;
    }

    public void setCantidadPeriodos(int cantidadPeriodos) {
        this.cantidadPeriodos = cantidadPeriodos;
    }

    public String[] getDiasSemana() {
        return diasSemana;
    }

    public void setDiasSemana(String[] diasSemana) {
        this.diasSemana = diasSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
