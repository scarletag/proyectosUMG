
package controladores;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Usuario;
import modelos.hash;


public class UsuarioController {
    //variables SQL
    static Connection conexion = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    //variables globales
    public static String nombre, apellido;
    public static int rol;
    // Crear querys constantes
    private static final String SELECT = "SELECT usuario, nombre, apellido, direccion, telefono, edad, correo, rol FROM usuarios INNER JOIN roles ON roles_idroles = idroles;";
    private static final String SELECT_ID = "SELECT usuario, nombre, apellido, direccion, telefono, edad, correo, rol FROM usuarios INNER JOIN roles ON roles_idroles = idroles WHERE usuario = ? ";
    private static final String LOGIN = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";
    private static final String INSERT = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE usuarios SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ?, edad = ?, roles_idroles = ? WHERE usuario = ? AND roles_idroles = ?  ";
    private static final String DELETE = "DELETE FROM usuarios WHERE usuario = ? AND roles_idroles = ?";
    private static final String UPDATE_PASSWORD = "UPDATE usuarios SET contraseña = ? WHERE usuario = ? ";
    
    
    // creacion de metodos
    // metodo para autenticar
    public static boolean autenticar(Usuario usuario){
        boolean autenticado = false;
        String hashPassword = hash.sha1(usuario.getContraseña());
        try {
           conexion = Conexion.conectar();
           ps = conexion.prepareStatement(LOGIN);
           ps.setString(1, usuario.getUsuario());
           ps.setString(2, hashPassword);
           rs = ps.executeQuery();
           if(rs.next()){
              nombre = rs.getString("nombre");
              apellido = rs.getString("apellido");
              rol = rs.getInt("roles_idroles");
              conexion.close();
              return !autenticado; 
           }
           conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return autenticado;
    }
    //metodo para listar
    public static List<Usuario> mostrarUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario user = null;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
              String usuario = rs.getString("usuario");
              String contraseña = rs.getString("contraseña");
              String nombre = rs.getString("nombre");
              String apellido = rs.getString("apellido");
              String direccion = rs.getString("direccion");
              String telefono = rs.getString("telefono");
              String correo = rs.getString("correo");
              int edad = rs.getInt("edad");
              String nombreRol = rs.getString("rol");
              user = new Usuario(usuario, contraseña, nombre, apellido, direccion, telefono, correo, nombreRol, edad);
              usuarios.add(user);
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return usuarios;
    }
    //modificar registro de usuario
    public static int modificarUsuario(Usuario usuario){
        int respuesta = 0;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(UPDATE);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setInt(6, usuario.getEdad());
            ps.setInt(7, usuario.getRoles_idroles());
            ps.setString(8, usuario.getUsuario());
            ps.setInt(9, usuario.getRoles_idroles());
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
    //metodo para buscar
    public static List<Usuario> buscarUsuario(Usuario usuario){
        List<Usuario> usuarios = usuarios = new ArrayList<>();;
        Usuario user = null;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(SELECT_ID);
            ps.setString(1, usuario.getUsuario());
            rs = ps.executeQuery();
            if(rs.next()){
                user = new Usuario();
                user.setUsuario(rs.getString("usuario"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido(rs.getString("apellido"));
                user.setDireccion(rs.getString("direccion"));
                user.setTelefono(rs.getString("Telefono"));
                user.setCorreo(rs.getString("correo"));
                user.setEdad(rs.getInt("edad"));
                user.setNombreRol(rs.getString("rol"));
                usuarios.add(user);
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return usuarios;
    }
    //metodo para eliminar
    public static int eliminarUsuario(Usuario usuario){
        int respuesta = 0;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(DELETE);
            ps.setString(1, usuario.getUsuario());
            ps.setInt(2, usuario.getRoles_idroles());
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
    // Metodo para registrar usuario
    public static int registrarUsuario(Usuario usuario){
        int registrado = 0;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(INSERT);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContraseña());
            ps.setString(3, usuario.getNombre());
            ps.setString(4, usuario.getApellido());
            ps.setString(5, usuario.getDireccion());
            ps.setString(6, usuario.getTelefono());
            ps.setInt(7, usuario.getEdad());
            ps.setString(8, usuario.getCorreo());
            ps.setInt(9, usuario.getRoles_idroles());
            registrado = ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrado;
    }
    public static boolean modificarContraseña(Usuario usuario){
        boolean encontrado = false;
        int respuesta = 0;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(UPDATE_PASSWORD);
            ps.setString(1, usuario.getContraseña());
            ps.setString(2, usuario.getUsuario());
            respuesta = ps.executeUpdate();
            if( respuesta != 0 ){
               conexion.close();
               return !encontrado;
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return encontrado;
    }
}
