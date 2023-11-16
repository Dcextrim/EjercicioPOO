import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kayac implements IKayac {
    private List<Usuario> usuarios;

    public Kayac() {
        this.usuarios = new ArrayList<>();
    }

    @Override
    public Usuario login(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void registroUsuario(String username, String password, String tipo) {
        Usuario nuevoUsuario = new Usuario(username, password, tipo);
        usuarios.add(nuevoUsuario);
        guardarUsuario();
        System.out.println("Usuario registrado con éxito.");
    }

    @Override
    public void cambiarPassword(String nuevaPassword) {
        Usuario usuarioActual = obtenerUsuarioActual();
    if (usuarioActual != null) {
        usuarioActual.setPassword(nuevaPassword);
        System.out.println("Contraseña cambiada con éxito.");
        guardarUsuario();
    } else {
        System.out.println("No se pudo cambiar la contraseña. Usuario no encontrado.");
    }
    }

    @Override
    public void cambiarTipoUsuario() {
        Usuario usuarioActual = obtenerUsuarioActual();
    if (usuarioActual != null) {
        usuarioActual.setTipo("premium");
        System.out.println("Ahora eres un usuario premium.");
        guardarUsuario();
    } else {
        System.out.println("No se pudo cambiar el tipo de usuario. Usuario no encontrado.");
    }
    }

    @Override
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String username) {
        Usuario usuario = buscarUsuarioPorUsername(username);
        if (usuario != null) {
            Reserva nuevaReserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, "", 0, "", "", 0);
            usuario.getReservas().add(nuevaReserva);
            guardarReserva();
            System.out.println("Reserva realizada con éxito.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas) {
        Usuario usuarioActual = obtenerUsuarioActual();
        if (usuarioActual != null && usuarioActual.getReservas().size() >= 0) {
            Reserva ultimaReserva = usuarioActual.getReservas().get(usuarioActual.getReservas().size());
            ultimaReserva.setNumeroTarjeta(numeroTarjeta);
            ultimaReserva.setCuotas(cuotas);
            ultimaReserva.setClaseVuelo(claseVuelo);
            ultimaReserva.setNumeroAsiento(numeroAsiento);
            ultimaReserva.setCantidadMaletas(cantidadMaletas);
            System.out.println("Confirmación realizada con éxito.");
            guardarReserva();
        } else {
            System.out.println("No hay reservas para confirmar.");
        }
    }

    @Override
    public String itinerario() {
        Usuario usuarioActual = obtenerUsuarioActual();
        if (usuarioActual != null && usuarioActual.getReservas().size() > 0) {
            Reserva ultimaReserva = usuarioActual.getReservas().get(usuarioActual.getReservas().size() - 1);
            return ultimaReserva.toString();
        } else {
            return "No hay reservas para mostrar en el itinerario.";
        }
    }

    @Override
    public void guardarUsuario() {
         String archivoUsuarios = "Usuarios.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoUsuarios))) {
            for (Usuario usuario : usuarios) {
                bw.write(usuario.getUsername() + ";" + usuario.getPassword() + ";" + usuario.getTipo());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarReserva() {
        String archivoReservas = "Reservas.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivoReservas))) {
            for (Usuario usuario : usuarios) {
                for (Reserva reserva : usuario.getReservas()) {
                    bw.write(usuario.getUsername() + ";" + reserva.getFechaVuelo() + ";" +
                            reserva.isTipoVuelo() + ";" + reserva.getCantidadBoletos() + ";" +
                            reserva.getAerolinea() + ";" + reserva.getNumeroTarjeta() + ";" +
                            reserva.getCuotas() + ";" + reserva.getClaseVuelo() + ";" +
                            reserva.getNumeroAsiento() + ";" + reserva.getCantidadMaletas());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leerUsuario() {
        String archivoUsuarios = "Usuarios.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    String username = partes[0];
                    String password = partes[1];
                    String tipo = partes[2];
                    usuarios.add(new Usuario(username, password, tipo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leerReserva() {
        String archivoReservas = "reservas.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(archivoReservas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 10) {
                    String username = partes[0];
                    String fechaVuelo = partes[1];
                    boolean tipoVuelo = Boolean.parseBoolean(partes[2]);
                    int cantidadBoletos = Integer.parseInt(partes[3]);
                    String aerolinea = partes[4];
                    String numeroTarjeta = partes[5];
                    int cuotas = Integer.parseInt(partes[6]);
                    String claseVuelo = partes[7];
                    String numeroAsiento = partes[8];
                    int cantidadMaletas = Integer.parseInt(partes[9]);

                    Usuario usuarioEncontrado = buscarUsuarioPorUsername(username);
                    if (usuarioEncontrado != null) {
                        Reserva reserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea,
                                numeroTarjeta, cuotas, claseVuelo, numeroAsiento, cantidadMaletas);
                        usuarioEncontrado.getReservas().add(reserva);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Usuario obtenerUsuarioActual() {
        if (!usuarios.isEmpty()) {
            return usuarios.get(0);
        } else {
            return null;
        }
    }

    private Usuario buscarUsuarioPorUsername(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                return usuario;
            }
        }
        return null;
    }
}
