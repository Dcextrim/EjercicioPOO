public class Jugador {
    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int totalServicios;

    public Jugador(String nombre, String pais, int errores, int aces, int totalServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getErrores() {
        return errores;
    }

    public int getAces() {
        return aces;
    }

    public int getTotalServicios() {
        return totalServicios;
    }

    public double calcularEfectividad() {
        return ((double) (totalServicios - errores) * 100 / (totalServicios + errores)) + (aces * 100 / totalServicios);
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("País: " + pais);
        System.out.println("Errores: " + errores);
        System.out.println("Aces: " + aces);
        System.out.println("Total de Servicios: " + totalServicios);
        System.out.println("Efectividad: " + calcularEfectividad() + "%");
    }

    public static Jugador fromCSV(String csv) {
        String[] datos = csv.split(",");
        if (datos.length != 5) {
            // Manejo de errores: la cadena CSV no tiene el formato esperado
            return null;
        }

        String nombre = datos[0];
        String pais = datos[1];
        int errores = Integer.parseInt(datos[2]);
        int aces = Integer.parseInt(datos[3]);
        int totalServicios = Integer.parseInt(datos[4]);

        return new Jugador(nombre, pais, errores, aces, totalServicios);
    }
    public String toCSV() {
        // Construir una cadena CSV con los datos del jugador
        return nombre + "," + pais + "," + errores + "," + aces + "," + totalServicios;
    }
}