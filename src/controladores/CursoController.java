
package controladores;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Curso;
import modelos.hash;


public class CursoController {
    //variables SQL
    static Connection conexion = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    // Crear querys constantes
    private static final String SELECT = "SELECT nombre_curso, usuarios_usuario, idcurso FROM cursos;";
    private static final String SELECT_ID = "SELECT idcurso, nombre_curso, usuarios_usuario FROM cursos = ? ";
    private static final String INSERT = "INSERT INTO cursos VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE cursos SET nombre_curso = ?, usuarios_usuario = ? WHERE idcurso = ?  ";
    private static final String DELETE = "DELETE FROM cursos WHERE curso = ? ";
    
    // creacion de metodos
    //metodo para listar
    public static List<Curso> mostrarCurso(){
        List<Curso> cursos = new ArrayList<>();
        Curso user = null;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while(rs.next()){
              String idcurso = rs.getString("idcurso");
              String nombre_curso = rs.getString("nombre_curso");
              String usuarios_usuario = rs.getString("usuarios_usuario");
                            
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cursos;
    }
    //modificar registro de usuario
    public static int modificarCurso(Curso curso){
        int respuesta = 0;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(UPDATE);
            
            ps.setString(1, curso.getNombre_curso());
            ps.setString(2, curso.getUsuarios_usuario());
            ps.setString(3, curso.getIdcurso());
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
    //metodo para buscar
    public static List<Curso> buscarCurso(Curso curso){
        List<Curso> cursos = new ArrayList<>();
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(SELECT_ID);
            ps.setString(1, curso.getIdcurso());
            rs = ps.executeQuery();
            if(rs.next()){
               curso.setIdcurso(rs.getString("idcurso"));
               curso.setNombre_curso(rs.getString("nombre_curso"));
               curso.setUsuarios_usuario(rs.getString("usuarios_usuario"));
               cursos.add(curso);
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return cursos;
    }
    //metodo para eliminar
    public static int eliminarCurso(Curso curso){
        int respuesta = 0;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(DELETE);
            ps.setString(1, curso.getNombre_curso());
            respuesta = ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return respuesta;
    }
    // Metodo para registrar usuario
    public static int registrarCursos(Curso curso){
        int registrado = 0;
        try {
            conexion = Conexion.conectar();
            ps = conexion.prepareStatement(INSERT);
            ps.setString(1, curso.getNombre_curso());
            ps.setString(2, curso.getUsuarios_usuario());
            registrado = ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return registrado;
    }
}

