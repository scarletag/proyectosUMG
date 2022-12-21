
package controladores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Grado;

public class GradoController {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static final String SELECT = "SELECT * FROM grados";
    private static final String SELECT_ID = "SELECT * FROM grados WHERE idgrados = ?";
    private static final String INSERT = "INSERT INTO grados VALUES(?)";
    private static final String UPDATE = "UPDATE grados SET nombre_grado = ? WHERE idgrados = ?" ;
    private static final String DELETE = "DELETE FROM grados WHERE idgrados = ?";

    public static List<Grado> mostrarGrados(){
        List<Grado> grados = new ArrayList<>();
        Grado Grados = null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                Grados.setIdgrados(rs.getInt("idgrados"));
                Grados.setNombre_grado(rs.getString("nombre_grado"));
                grados.add(Grados);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return grados;
    }
    public static List<Grado> mostrarPorId(Grado grado){
        List<Grado> grados = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT_ID);
            rs = ps.executeQuery();
            if(rs.next()){
                grado.setIdgrados(rs.getInt("idgrados"));
                grado.setNombre_grado(rs.getString("nombre_grado"));
                grados.add(grado);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return grados;
    }
    public static int insertarRegistro(Grado grado){
        int respuesta = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(INSERT);
            ps.setString(1, grado.getNombre_grado());
            respuesta = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
    public int modificarRegistro(Grado grado){
        int respuesta = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(UPDATE);
            ps.setString(1, grado.getNombre_grado());
            ps.setInt(2, grado.getIdgrados());
            respuesta = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
    }
    public int eliminarRegistro(Grado grado){
        int respuesta = 0;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(DELETE);
            ps.setInt(1, grado.getIdgrados());
            respuesta = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(GradoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return respuesta;
        
    }
}
