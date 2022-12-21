
package controladores;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelos.Estadocurso;


public class EstadocursoController {
    private static Connection con = null;
    private static PreparedStatement ps=null;
    private static ResultSet rs = null;
    private static final String SELECT="SELECT * FROM estado_curso";
    private static final String SELECT_ID="SELECT * FROM estados_curso WHERE idestado_curso=?";
    private static final String INSERT="INSERT INTO estados_curso VALUES(?)";
    private static final String UPDATE="UPDATE estados_curso SET estados_curso=?, WHERE idestado_curso=?";
    private static final String DELETE="DELETE FROM estados_curso WHERE idestado_curso=?";
    
    public static List<Estadocurso> mostrarEstadocurso(){
        List<Estadocurso> estado_curso = new ArrayList<>();
        Estadocurso estadocurso= null;
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
                estadocurso.setIdestado_curso(rs.getString("idestado_curso"));
                estadocurso.setTipo_estado_curso(rs.getString("tipo_estado_curso"));
                estado_curso.add(estadocurso);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return estado_curso;
    }
    public static List<Estadocurso> mostrarPorId(Estadocurso estadocurso){
        List<Estadocurso> estado_curso = new ArrayList<>();
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(SELECT);
            rs = ps.executeQuery();
            if(rs.next()){
                estadocurso.setIdestado_curso(rs.getString("idestado_curso"));
                estadocurso.setTipo_estado_curso(rs.getString("tipo_estado_curso"));
                estado_curso.add(estadocurso);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return estado_curso;
    }
    public static int insertarRegistro(Estadocurso estadocurso){
        int respuesta=0;
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
    public static int modificarRegistro(Estadocurso estadocurso){
        int respuesta=0;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(UPDATE);
            ps.setString(1, estadocurso.getIdestado_curso());
            ps.setString(2, estadocurso.getTipo_estado_curso());
            respuesta=ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
    public static int eliminarRegistro(Estadocurso estadocurso){
        int respuesta=0;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(DELETE);
            ps.setString(1, estadocurso.getIdestado_curso());
            ps.setString(2, estadocurso.getTipo_estado_curso());
            respuesta=ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
}
