import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Kayac implements IKayac {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private String usuarioAEditar;
    private String nuevoTipoUsuario;

    @Override
    public Usuario login(String username, String password) {
        for(Usuario usuario : usuarios){
            if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password)){
                System.out.println("Sesion Iniciada con exito");
                return usuario;
            }
        }
        System.out.println("Nombre de usuario o contraseña incorrectos");
        return null;
    }

    @Override
    public void registroUsuario(String username, String password, String tipo) {
        if (usuarios.isEmpty()) {
            Usuario nuevoUsuario = new Usuario(username, password, tipo);
            usuarios.add(nuevoUsuario);
            guardarUsuario();
        } else {
            for (Usuario usuario : usuarios) {
                if (usuario.getUsername().equals(username)) {
                }
            }
        }
    }

    @Override
    public void cambiarPassword(String nuevaPassword) {
        for(Usuario usuario : usuarios){
            if(usuario.getPassword().equals(nuevaPassword)){
                System.out.println("No utilizar contraseñas antiguas");
            }else{
                System.out.println("Nueva contraseña guardad con éxito");
                usuario.setPassword(nuevaPassword);
                guardarUsuario();
            }
        }
    }

    @Override
    public void cambiarTipoUsuario() {
        Usuario usuarioEncontrado = null;

        // Buscar el usuario en la lista de usuarios
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(usuarioAEditar)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        // Si se encontró el usuario, cambiar el tipo
        if (usuarioEncontrado != null) {
            // Establecer el nuevo tipo directamente
            usuarioEncontrado.setTipo(nuevoTipoUsuario);
            System.out.println("Tipo de usuario actualizado con éxito.");
        } else {
            System.out.println("Error al cambiar el tipo de usuario. Usuario no encontrado.");
        }

        // Restablecer los atributos después de la operación
        usuarioAEditar = null;
        nuevoTipoUsuario = null;
    }


    @Override
    public void reservacion(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea,String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                String numeroTarjeta = "";
                int cuotas =0;
                String claseVuelo="";
                String numeroAsiento ="";
                int cantidadMaletas=0;
                Reserva nuevaReserva = new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea,numeroTarjeta,cuotas,claseVuelo,numeroAsiento,cantidadMaletas);
                usuario.getReservas().add(nuevaReserva);
                guardarReserva();
                System.out.println("\nReserva registrada con éxito.");
            }
        }
        System.out.println("Error al registrar la reservación");
        
    }

    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento,int cantidadMaletas) {
        for (Reserva reserva : reservas) {
            if (reserva != null) {
                // Completa los valores restantes de la reserva
                reserva.setNumeroTarjeta(numeroTarjeta);
                reserva.setCuotas(cuotas);
                reserva.setClaseVuelo(claseVuelo);
                reserva.setNumeroAsiento(numeroAsiento);
                reserva.setCantidadMaletas(cantidadMaletas);
                System.out.println("Confirmación exitosa de la reserva.");
            } else {
                System.out.println("Error al confirmar la reserva. La reserva no existe.");
            }
        }
    }

    @Override
    public String itinerario() {
        return null;
    }


    @Override
    public void guardarUsuario() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Usuarios.csv"))) {
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Reservas.csv"))) {
            for (Usuario usuario : usuarios) {
                for (Reserva reserva : usuario.getReservas()) {
                    bw.write(usuario.getUsername() + ";" + reserva.getFechaVuelo() + ";" + reserva.isTipoVuelo() + ";" +reserva.getCantidadBoletos() + ";" + reserva.getAerolinea()+";"+reserva.getNumeroTarjeta()+";"+reserva.getCuotas()+";"+reserva.getClaseVuelo()+";"+reserva.getNumeroAsiento()+";"+reserva.getCantidadMaletas());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void leerUsuario() {
        try (BufferedReader br = new BufferedReader(new FileReader("Usuario.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    String username = partes[0];
                    String password = partes[1];
                    String tipo = partes[2];
                    usuarios.add(new Usuario(username,password,tipo));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void leerReserva() {
        try (BufferedReader br = new BufferedReader(new FileReader("Reservas.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 9) {
                    String username = partes[0];
                    String fechaVuelo = partes[1];
                    boolean tipoVuelo =Boolean.parseBoolean(partes[2]);
                    int cantidadBoletos = Integer.parseInt(partes[3]);
                    String aerolinea = partes[4];
                    String numeroTarjeta = partes[5];
                    int cuotas = Integer.parseInt(partes[6]);
                    String claseVuelos = partes[7];
                    String numeroAsiento = partes[8];
                    int cantidadMaletas = Integer.parseInt(partes[9]);

                    Usuario usuarioEncontrado = null;
                    for (Usuario usuario : usuarios){
                        if(usuario.getUsername().equals(username)){
                            usuarioEncontrado=usuario;
                            break;
                        }
                    }if(usuarioEncontrado != null){
                        usuarioEncontrado.getReservas().add(new Reserva(fechaVuelo, tipoVuelo, cantidadBoletos, aerolinea, numeroTarjeta, cuotas, claseVuelos, numeroAsiento, cantidadMaletas));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}