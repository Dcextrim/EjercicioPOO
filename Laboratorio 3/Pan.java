public class Pan extends Producto {

    private Clase clase;

    public Pan(int id, String nombre, int cantidad_disponible, int cantidad_vendidos, Estado estado, double precio, Clase clase) {
        super(id, nombre, cantidad_disponible, cantidad_vendidos, estado, precio);
        this.clase = clase;
    }

    public enum Clase{
        DULCE,SALADO
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "Pan{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad_disponible=" + cantidad_disponible +
                ", cantidad_vendidos=" + cantidad_vendidos +
                ", estado=" + estado +
                ", precio=" + precio +
                ", clase=" + clase +
                '}';
    }
}
