import java.util.Scanner;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Universidad universidad = new Universidad();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n*** Menú Principal ***");
            System.out.println("1. Agregar Sede");
            System.out.println("2. Registrar Estudiante");
            System.out.println("3. Ingresar nota de examen");
            System.out.println("4. Calcular Estadisticas Generales");
            System.out.println("5.Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la sede: ");
                
                    String nombreSede = scanner.nextLine();
                    Sede sede = new Sede(nombreSede);
                    universidad.agregarSede(sede);
                    System.out.println("Sede agregada con éxito.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el apellido del estudiante: ");
                    String apellidoEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el código único del estudiante: ");
                    String codigoEstudiante = scanner.nextLine();
                    System.out.print("Ingrese la fecha de nacimiento del estudiante: ");
                    String fechaNacimientoEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el correo electrónico del estudiante: ");
                    String correoEstudiante = scanner.nextLine();

                    Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante, codigoEstudiante,
                            fechaNacimientoEstudiante, correoEstudiante);

                    System.out.print("¿En qué sede desea registrar al estudiante? Ingrese el nombre de la sede: ");
                    String nombreSedeEstudiante = scanner.nextLine();
                    Sede sedeEstudiante = buscarSedePorNombre(universidad, nombreSedeEstudiante);

                    if (sedeEstudiante != null) {
                        sedeEstudiante.registrarEstudiante(estudiante);
                        System.out.println("Estudiante registrado en la sede con éxito.");
                    } else {
                        System.out.println("La sede ingresada no existe.");
                    }
                    break;

                case 3:
                System.out.print("Ingrese el código único del estudiante: ");
                String codigoEstudiantex = scanner.nextLine();
                Estudiante estudiantex = buscarEstudiantePorCodigo(universidad, codigoEstudiantex);

                if (estudiantex != null) {
                    System.out.print("Ingrese el nombre del examen: ");
                    String nombreExamen = scanner.nextLine();
                    System.out.print("Ingrese la nota del examen: ");
                    double notaExamen = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea

                    Examen examen = new Examen(nombreExamen, notaExamen);
                    estudiantex.agregarExamen(examen);
                    System.out.println("Examen y nota agregados con éxito.");
                } else {
                    System.out.println("El estudiante con código único ingresado no existe.");
                }
                break;
                case 4:
                    List<String> estadisticasGenerales = universidad.calcularEstadisticasGenerales();
                    System.out.println("\n*** Estadísticas Generales de la Universidad ***");
                    for (String estadistica : estadisticasGenerales) {
                        System.out.println(estadistica);
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    // Método para buscar una sede por nombre en la universidad
    private static Sede buscarSedePorNombre(Universidad universidad, String nombreSede) {
        for (Sede sede : universidad.obtenerSedes()) {
            if (sede.getNombreSede().equalsIgnoreCase(nombreSede)) {
                return sede;
            }
        }
        return null;
    }
    // Método para buscar un estudiante por código único en la universidad
    private static Estudiante buscarEstudiantePorCodigo(Universidad universidad, String codigoEstudiante) {
        for (Sede sede : universidad.obtenerSedes()) {
            for (Estudiante estudiante : sede.getEstudiantes()) {
                if (estudiante.getCodigoUnico().equalsIgnoreCase(codigoEstudiante)) {
                    return estudiante;
                }
            }
        }
        return null;
    }
}
