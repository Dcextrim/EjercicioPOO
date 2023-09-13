import java.util.Arrays;

public class Laboratorio {
    private int capacidad;
    private String horarioApertura;
    private String horarioCierre;
    private Curso[][] horarios;

    public Laboratorio(int capacidad, String horarioApertura, String horarioCierre) {
        this.capacidad = capacidad;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.horarios = new Curso[7][14]; // 7 días a la semana, 14 horas por día
    }

    public boolean asignarCurso(Curso curso, int dia, int hora) {
        // Verificar si el horario está disponible y si la capacidad es suficiente
        if (dia >= 0 && dia < 7 && hora >= 0 && hora < 14 &&
            horarios[dia][hora] == null && curso.getCantidadEstudiantes() <= capacidad) {
            horarios[dia][hora] = curso;
            return true; // Asignación exitosa
        }
        return false; // No se pudo asignar el curso
    }

    public void verInformacionCurso(int dia, int hora) {
        if (dia >= 0 && dia < 7 && hora >= 0 && hora < 14 && horarios[dia][hora] != null) {
            Curso curso = horarios[dia][hora];
            System.out.println("Información del curso en el día " + dia + ", hora " + hora + ":");
            System.out.println("Código del curso: " + curso.getCodigo());
            System.out.println("Nombre del curso: " + curso.getNombre());
            System.out.println("Profesor: " + curso.getProfesor().getNombreCompleto());
            // Agregar más información del curso según sea necesario
        } else {
            System.out.println("No hay un curso asignado en el día " + dia + ", hora " + hora + ".");
        }
    }

    public boolean eliminarCurso(int dia, int hora) {
        if (dia >= 0 && dia < 7 && hora >= 0 && hora < 14 && horarios[dia][hora] != null) {
            horarios[dia][hora] = null;
            return true; // Eliminación exitosa
        }
        return false; // No se pudo eliminar el curso
    }

    //Metodo para ver la informacion general del profesor
    public void verProfesor(int dia, int hora) {
        if (dia >= 0 && dia < 7 && hora >= 0 && hora < 14 && horarios[dia][hora] != null) {
            Curso curso = horarios[dia][hora];
            Profesor profesor = curso.getProfesor();
            
            System.out.println("Profesor asignado en el día " + dia + ", hora " + hora + ":");
            System.out.println("Nombre del profesor: " + profesor.getNombreCompleto());
            System.out.println("Carné del profesor: " + profesor.getCarne());
            System.out.println("Correo electrónico del profesor: " + profesor.getCorreoElectronico());
            System.out.println("Teléfono del profesor: " + profesor.getTelefono());
        } else {
            System.out.println("No hay un curso asignado en el día " + dia + ", hora " + hora + ".");
        }
    }
    
    //Metodos para ver la disponibilidad de horario
    public void disponibilidadHorarios() {
        for (int dia = 0; dia < 7; dia++) {
            for (int hora = 0; hora < 14; hora++) {
                if (horarios[dia][hora] == null) {
                    // El espacio está disponible, puedes asignar cursos aquí si es necesario
                    System.out.println("Disponible en el día " + dia + ", hora " + hora + ".");
                }
            }
        }
    }

    //Metodo para ver el procentaje de responsabilidad de un profesor
    public void profesorResponsabilidad(String nombreProfesor) {
        int totalHorarios = 7 * 14; // Total de horarios posibles en una semana
        int contador = 0; // Contador para llevar un registro de la cantidad de veces que el profesor está asignado
    
        for (int dia = 0; dia < 7; dia++) {
            for (int hora = 0; hora < 14; hora++) {
                if (horarios[dia][hora] != null) {
                    Profesor profesor = horarios[dia][hora].getProfesor();
                    if (profesor.getNombreCompleto().equals(nombreProfesor)) {
                        contador++;
                    }
                }
            }
        }
    
        double porcentajeResponsabilidad = (contador * 100.0) / totalHorarios;
    
        System.out.println("El profesor " + nombreProfesor + " está asignado " + contador + " veces.");
        System.out.println("Porcentaje de responsabilidad: " + porcentajeResponsabilidad + "%");
    }
    
}
