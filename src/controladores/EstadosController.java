
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Estado;


public class EstadosController {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    private static final String SELECT = "SELECT * FROM estados";
    private static final String SELECT_ID = "SELECT * FROM estados WHERE idestados=?";
    private static final String INSERT = "INSERT INTO estados VALUES(?)";
    private static final String UPDATE ="UPDATE estados SET estados=?, WHERE idestados=?";
    private static final String DELETE = "DELETE FROM estados WHERE idestados=?";
    
    public static List<Estado> mostrarEstado(){
        List<Estado> estados = new ArrayList<>();
        Estado estado = null;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(SELECT);
            rs=ps.executeQuery();
            while(rs.next()){
                estado.setIdestados(rs.getString("idestados"));
                estado.setTipo_estado(rs.getString("tipo_estado"));
                estados.add(estado);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return estados;
    }
    public static List<Estado>mostrarPorId(Estado estado){
        List<Estado> estados=new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(SELECT);
            rs=ps.executeQuery();
            if(rs.next()){
            estado.setIdestados(rs.getString("idestado"));
            estado.setTipo_estado(rs.getString("tipo_estado"));
            estados.add(estado);
        }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return estados;
    }
    public static int insertarRegistro(Estado estados){
        int respuesta =0;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(INSERT);
            rs=ps.executeQuery();
            respuesta=ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
    public static int modificarRegistro(Estado estado){
        int respuesta=0;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(UPDATE);
            ps.setString(1,estado.getIdestados());
            ps.setString(2,estado.getTipo_estado());
            respuesta=ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
    public static int eliminarRegistro(Estado estado){
        int respuesta=0;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(DELETE);
            ps.setString(1,estado.getIdestados());
            ps.setString(2,estado.getTipo_estado());
            respuesta=ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
        
    }
}
