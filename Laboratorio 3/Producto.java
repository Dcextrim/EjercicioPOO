public class Producto {

    protected int id;
    protected String nombre;
    protected int cantidad_disponible;
    protected int cantidad_vendidos;
    protected Estado estado;
    protected double precio;

    public Producto(int id, String nombre, int cantidad_disponible, int cantidad_vendidos, Estado estado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad_disponible = cantidad_disponible;
        this.cantidad_vendidos = cantidad_vendidos;
        this.estado = estado;
        this.precio = precio;
    }

    public enum Estado{
        DISPONIBLE, NODISPONIBLE
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(int cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public int getCantidad_vendidos() {
        return cantidad_vendidos;
    }

    public void setCantidad_vendidos(int cantidad_vendidos) {
        this.cantidad_vendidos = cantidad_vendidos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad_disponible=" + cantidad_disponible +
                ", cantidad_vendidos=" + cantidad_vendidos +
                ", estado=" + estado +
                ", precio=" + precio +
                '}';
    }
}