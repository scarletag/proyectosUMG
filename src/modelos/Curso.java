
package modelos;

public class Curso {
    private String nombre_curso, usuarios_usuario ;
    private String idcurso;
    
    public Curso(){
        super();
    }
    
    //constructor para registrar cursos
    public Curso(String nombre_curso,String usuarios_curso, String idcurso){
        
        this.nombre_curso=nombre_curso;
        this.usuarios_usuario=usuarios_curso;
        this.idcurso=idcurso;
    }
    //constructor para mostrar todos los registros de curso
    public Curso(String nombre_curso){
        this.nombre_curso=nombre_curso;        
    }
    //constructor para autentificacion del curso
    public Curso(String nombre_curso, String idcurso){
        this.nombre_curso=nombre_curso;
        this.idcurso=idcurso;
    }
    //metodos seter y geter
    public String getNombre_curso() {
        return nombre_curso;
    }

    public void setNombre_curso(String nombre_curso) {
        this.nombre_curso = nombre_curso;
    }

    public String getUsuarios_usuario() {
        return usuarios_usuario;
    }

    public void setUsuarios_usuario(String usuarios_usuario) {
        this.usuarios_usuario = usuarios_usuario;
    }

    public String getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(String idcurso) {
        this.idcurso = idcurso;
    }

}
