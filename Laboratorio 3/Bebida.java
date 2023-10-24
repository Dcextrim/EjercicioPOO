public class Bebida extends Producto {

    private int ml;
    private Tipo tipo;

    public Bebida(int id, String nombre, int cantidad_disponible, int cantidad_vendidos, Estado estado, double precio, int ml, Tipo tipo) {
        super(id, nombre, cantidad_disponible, cantidad_vendidos, estado, precio);
        this.ml = ml;
        this.tipo = tipo;
    }

    public enum Tipo{
        COLA,PEPSI,GATORADE,VINO
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad_disponible=" + cantidad_disponible +
                ", cantidad_vendidos=" + cantidad_vendidos +
                ", estado=" + estado +
                ", precio=" + precio +
                ", ml=" + ml +
                ", tipo=" + tipo +
                '}';
    }
}
