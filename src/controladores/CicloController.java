
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Ciclo;



public class CicloController {
  private static Connection con = null;
  private static PreparedStatement ps = null;
  private static ResultSet rs = null;
  private static final String SELECT = "SELECT * FROM ciclo_escolar";
  private static final String SELECT_ID = "SELECT * FROM ciclo_escolar WHERE idciclo_escolar = ?";
  private static final String INSERT = "INSERT INTO ciclo_escolar VALUES(?)";
  private static final String UPDATE = "UPDATE ciclo_escolar SET ciclo_escolar = ?, WHERE idciclo_escolar =?";
  private static final String DELETE = "DELETE FROM ciclo_escolar WHERE idciclo_escolar =?";
  
  public static List<Ciclo> mostrarCiclo(){
      List<Ciclo> ciclo_escolar = new ArrayList<>();
      Ciclo ciclo = null;
      try {
         con = Conexion.conectar();
         ps = con.prepareStatement(SELECT);
         rs = ps.executeQuery();
         while(rs.next()){
             ciclo.setIdciclo_escolar(rs.getInt("idciclo_escolar"));
             ciclo.setCiclo_escolar(rs.getString("ciclo_escolar"));
             ciclo_escolar.add(ciclo);
         }
         con.close();
      } catch (Exception e) {
          e.printStackTrace(System.out);
      }
      return ciclo_escolar;
  }
  public static List<Ciclo> mostrarPorId(Ciclo ciclo){
      List<Ciclo> ciclo_escolar = new ArrayList<>();
      try {
          con = Conexion.conectar();
          ps = con.prepareStatement(SELECT);
          rs = ps.executeQuery();
          if(rs.next()){
              ciclo.setIdciclo_escolar(rs.getInt("idciclo_escolar"));
              ciclo.setCiclo_escolar(rs.getString("ciclo_escolar"));
              ciclo_escolar.add(ciclo);
          }
          con.close();
      } catch (Exception e) {
          e.printStackTrace(System.out);
      }
      
      return ciclo_escolar ;
  }
  public static int insertarRegistro(Ciclo ciclo){
      int respuesta = 0;
      try {
          con = Conexion.conectar();
          ps = con.prepareStatement(INSERT);
          rs = ps.executeQuery();
          respuesta = ps.executeUpdate();
          con.close();
          
      } catch (Exception e) {
          e.printStackTrace(System.out);
      }
      return respuesta;
  }
  public static int modificarRegistro(Ciclo ciclo){
      int respuesta = 0;
      try {
          con = Conexion.conectar();
          ps = con.prepareStatement(UPDATE);
          ps.setInt(1, ciclo.getIdciclo_escolar());
          ps.setString(2, ciclo.getCiclo_escolar());
          respuesta = ps.executeUpdate();
          con.close();
          
      } catch (Exception e) {
          e.printStackTrace(System.out);
      }
      return respuesta;
  }
  public static int eliminarRegistro(Ciclo ciclo){
      int respuesta=0;
      try {
          con=Conexion.conectar();
          ps=con.prepareStatement(DELETE);
          ps.setInt(1, ciclo.getIdciclo_escolar());
          ps.setString(2, ciclo.getCiclo_escolar());
          respuesta = ps.executeUpdate();
          con.close();
          
      } catch (Exception e) {
          e.printStackTrace(System.out);
      }
      return respuesta;
  }
  

}
