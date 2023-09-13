import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Laboratorio laboratorio = new Laboratorio(30, "07:00 am", "09:00 pm"); // Ejemplo de capacidad y horarios

        while (true) {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Asignar curso");
            System.out.println("2. Ver información de curso");
            System.out.println("3. Eliminar curso");
            System.out.println("4. Ver datos del periodo");
            System.out.println("5. Disponibilidad del horario");
            System.out.println("6. Responsabilidad del profesor");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Solicitar información sobre el curso al usuario
                    scanner.nextLine(); // Limpiar el búfer de entrada
                    System.out.print("Ingrese el código del curso: ");
                    String codigoCurso = scanner.nextLine();
                    System.out.print("Ingrese el nombre del curso: ");
                    String nombreCurso = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de períodos por día: ");
                    int cantidadPeriodos = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el búfer de entrada
                    System.out.print("Ingrese los días de la semana (por ejemplo, 'lunes martes'): ");
                    String diasSemana = scanner.nextLine();
                    System.out.print("Ingrese el horario (por ejemplo, '07:00 am'): ");
                    String horario = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de estudiantes: ");
                    int cantidadEstudiantes = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el búfer de entrada
                    System.out.print("Ingrese el nombre completo del profesor: ");
                    String nombreProfesor = scanner.nextLine();
                    System.out.print("Ingrese el carné del profesor: ");
                    String carneProfesor = scanner.nextLine();
                    System.out.print("Ingrese el correo electrónico del profesor: ");
                    String correoProfesor = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del profesor: ");
                    String telefonoProfesor = scanner.nextLine();
                
                    // Crear un objeto Profesor con la información ingresada
                    Profesor profesor = new Profesor(nombreProfesor, carneProfesor, correoProfesor, telefonoProfesor);
                
                    // Crear un objeto Curso con la información ingresada
                    String[] diasArray = diasSemana.split(" "); // Dividir los días por espacio en blanco
                    Curso curso = new Curso(codigoCurso, nombreCurso, cantidadPeriodos, diasArray, horario, cantidadEstudiantes, profesor);
                
                    // Intentar asignar el curso al laboratorio
                    System.out.print("Ingrese el día (0-6): ");
                    int diaAsignar = scanner.nextInt();
                    System.out.print("Ingrese la hora (0-13): ");
                    int horaAsignar = scanner.nextInt();
                
                    if (laboratorio.asignarCurso(curso, diaAsignar, horaAsignar)) {
                        System.out.println("Curso asignado con éxito.");
                    } else {
                        System.out.println("No se pudo asignar el curso. Verifique la disponibilidad y la capacidad del laboratorio.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el día (0-6): ");
                    int dia = scanner.nextInt();
                    System.out.print("Ingrese la hora (0-13): ");
                    int hora = scanner.nextInt();
                    laboratorio.verInformacionCurso(dia, hora);
                    break;
                case 3:
                    System.out.print("Ingrese el día (0-6): ");
                    int diaEliminar = scanner.nextInt();
                    System.out.print("Ingrese la hora (0-13): ");
                    int horaEliminar = scanner.nextInt();
                    if (laboratorio.eliminarCurso(diaEliminar, horaEliminar)) {
                        System.out.println("Curso eliminado con éxito.");
                    } else {
                        System.out.println("No se pudo eliminar el curso.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el día (0-6): ");
                    int diaVerProfesor = scanner.nextInt();
                    System.out.print("Ingrese la hora (0-13): ");
                    int horaVerProfesor = scanner.nextInt();
                    laboratorio.verProfesor(diaVerProfesor, horaVerProfesor);
                    break;
                case 5:
                    laboratorio.disponibilidadHorarios();
                    break;
                case 6:
                    scanner.nextLine(); // Limpiar el búfer de entrada
                    System.out.print("Ingrese el nombre completo del profesor: ");
                    String nombreProfesorr = scanner.nextLine();
                    laboratorio.profesorResponsabilidad(nombreProfesorr);
                    break;
                case 7:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
