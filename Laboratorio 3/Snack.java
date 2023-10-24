public class Snack extends Producto {

    private int gramos;
    private Sabor sabor;
    private Tamaño tamaño;

    public Snack(int id, String nombre, int cantidad_disponible, int cantidad_vendidos, Estado estado, double precio, int gramos, Sabor sabor, Tamaño tamaño) {
        super(id, nombre, cantidad_disponible, cantidad_vendidos, estado, precio);
        this.gramos = gramos;
        this.sabor = sabor;
        this.tamaño = tamaño;
    }

    public enum Sabor{
        POLLO,PIZZA,PAPA,JAMON,PAVO
    }

    public enum Tamaño{
        PEQUEÑO,MEDIANO,GRANDE
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Tamaño getTamaño() {
        return tamaño;
    }

    public void setTamaño(Tamaño tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad_disponible=" + cantidad_disponible +
                ", cantidad_vendidos=" + cantidad_vendidos +
                ", estado=" + estado +
                ", precio=" + precio +
                ", gramos=" + gramos +
                ", sabor=" + sabor +
                ", tamaño=" + tamaño +
                '}';
    }
}
