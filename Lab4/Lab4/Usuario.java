import java.util.ArrayList;

public class Usuario {
    private String username;
    private String password;
    private String tipo;
    private ArrayList<Reserva> reservas;

    public Usuario(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
        reservas = new ArrayList<Reserva>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
}