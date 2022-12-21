
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Gastosvarios;


public class GastosvariosController {
    private static Connection con=null;
    private static PreparedStatement ps=null;
    private static ResultSet rs=null;
    private static final String SELECT="SELECT * FROM gastos_varios";
    private static final String SELECT_ID="SELECT * FROM gastos_varios WHERE idgastos_varios=?";
    private static final String INSERT="INSERT INTO gastos_varios VALUES(?)";
    private static final String UPDATE="UPDATE gastos_varios SET gastos_varios=?, WHERE idgastos_varios=?";
    private static final String DELETE="DELETE FROM gastos_varios WHERE idgastos_varios=?";
    
    public static List<Gastosvarios> mostrarGastosvarios(){
        List<Gastosvarios> gastos_varios = new ArrayList<>();
        Gastosvarios gastosv = null;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(SELECT);
            rs=ps.executeQuery();
            while(rs.next()){
                gastosv.setIdgastos_varios(rs.getString("idgastos_varios"));
                gastosv.setNombre_gasto(rs.getString("nombre_gasto"));
                gastosv.setDescripcion_gasto(rs.getString("descripcion_gasto"));
                gastosv.setCosto_gasto(rs.getString("costo_gasto"));
                gastosv.setFecha_gasto(rs.getString("fecha_gasto"));
                gastos_varios.add(gastosv);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return gastos_varios;
    }
        public static List<Gastosvarios> mostrarPorId(Gastosvarios gastosv){
            List<Gastosvarios> gastos_varios = new ArrayList<>();
            try {
                con=Conexion.conectar();
                ps=con.prepareStatement(SELECT);
                rs=ps.executeQuery();
                if(rs.next()){
                    gastosv.setIdgastos_varios(rs.getString("idgastos_varios"));
                    gastosv.setNombre_gasto(rs.getString("nombre_gasto"));
                    gastosv.setDescripcion_gasto(rs.getString("descripcion_gasto"));
                    gastosv.setCosto_gasto(rs.getString("costo_gasto"));
                    gastosv.setFecha_gasto(rs.getString("fecha_gasto"));
                }
                con.close();
            } catch (Exception e) {
                e.printStackTrace(System.out);
    
        }
            return gastos_varios;
        
    }
        public static int insertarRegistros(Gastosvarios gastosv){
            int  respuesta=0;
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
        public static int modificarRegistro(Gastosvarios gastosv){
            int respuesta=0;
            try {
               con=Conexion.conectar();
               ps=con.prepareStatement(UPDATE);
               ps.setString(1, gastosv.getIdgastos_varios());
               ps.setString(2, gastosv.getNombre_gasto());
               ps.setString(3, gastosv.getDescripcion_gasto());
               ps.setString(4, gastosv.getCosto_gasto());
               ps.setString(5, gastosv.getFecha_gasto());
               respuesta=ps.executeUpdate();
               con.close();
               
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            return respuesta;
        }
        public static int eliminarRegistro(Gastosvarios gastosv){
            int respuesta=0;
            try {
                con=Conexion.conectar();
                ps=con.prepareStatement(DELETE);
                ps.setString(1, gastosv.getIdgastos_varios());
                ps.setString(2, gastosv.getNombre_gasto());
                ps.setString(3, gastosv.getDescripcion_gasto());
                ps.setString(4, gastosv.getCosto_gasto());
                ps.setString(5, gastosv.getFecha_gasto());
                respuesta=ps.executeUpdate();
                con.close();
                
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            return respuesta;
            
            
            
        }
}
