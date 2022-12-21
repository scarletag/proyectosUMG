/*
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Horariocurso;


public class HorariocursoController {
    private static Connection con = null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    
    private static final String SELECT = "SELECT * FROM horario_cursos";
    private static final String SELECT_ID = "SELECT * FROM horario_cursos WHERE horario_cursoscol";
    private static final String INSERT = "INSERT INTO horario_cursos VALUES(?)";
    private static final String UPDATE = "UPDATE horario_cursos SET horario_cursos =? WHERE horario_cursoscol =?";
    private static final String DELETE = "DELETE FROM horario_cursos WHERE horario_cursoscol=?";
    
    public static List<Horariocurso> mostrarHorariocurso(){
        List<Horariocurso> horario_curso = new ArrayList<>();
        Horariocurso horariocurso = null;
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(SELECT);
            rs=ps.executeQuery();
            while(rs.next()){
                horariocurso.setHorario_cursocol(rs.getString("horario_cursoscol"));
                horariocurso.setGrados_idgrados(rs.getString("grados_idgrados"));
                horariocurso.set(rs.getString("horario_cursos"));
                horario_curso.add(horario);
                
            }
            con.close();
            }
        } catch (Exception e) {
    e.printStackTrace(System.out);
        }
        return horario_curso;
    }
    
*/