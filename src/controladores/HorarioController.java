
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Horario;
import java.sql.SQLException;


public class HorarioController {
    private static Connection con = null;
    private static PreparedStatement ps=null;
    private static ResultSet rs = null;
    private static final String SELECT="SELECT * FROM horarios";
    private static final String SELECT_ID="SELECT * FROM horarios WHERE idhorarios=?";
    private static final String INSERT="INSERT INTO horarios VALUES(?)";
    private static final String UPDATE="UPDATE horarios SET horarios=?, WHERE idehorarios=?";
    private static final String DELETE="DELETE FROM horarios WHERE idehorarios=?";
    
    public static List<Horario>mostrarHorario(){
     List<Horario> horarios = new ArrayList<>();
     Horario horario = null;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(SELECT);
            rs=ps.executeQuery();
            while(rs.next()){
                horario.setIdehorarios(rs.getString("idhorarios"));
                horario.setHorario(rs.getString("horario"));
                horarios.add(horario);
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return horarios;
    }
    public static List<Horario> mostrarPorId(Horario horario){
        List<Horario> horarios = new ArrayList<>();
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(SELECT);
            rs=ps.executeQuery();
            if(rs.next()){
                horario.setIdehorarios(rs.getString("idhorarios"));
                horario.setHorario(rs.getString("horarios"));
                horarios.add(horario);   
            }
            con.close();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return horarios;
    }
    public static int insertarRegistro(Horario horario){
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
        public static int modificarRegistro(Horario horario){
            int respuesta=0;
            try {
               con=Conexion.conectar();
               ps=con.prepareStatement(UPDATE);
               ps.setString(1, horario.getIdehorarios());           
               ps.setString(2, horario.getHorario());
               respuesta=ps.executeUpdate();
               con.close();
               
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            return respuesta;
        }
        public static int eliminarRegistro(Horario horario){
            int respuesta=0;
            try {
                con=Conexion.conectar();
                ps=con.prepareStatement(DELETE);
                ps.setString(1, horario.getIdehorarios());
                ps.setString(2, horario.getHorario());
                respuesta=ps.executeUpdate();
                con.close();
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            return respuesta;
        }
        
        
    }
    

