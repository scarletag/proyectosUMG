
package modelos;


public class Estadocurso {
    private String tipo_estado_curso;
    private String idestado_curso;
    
    public Estadocurso(){
        super();
    }
    public Estadocurso(String tipo_estado_curso, String idestado_curso){
        this.tipo_estado_curso=tipo_estado_curso;
        this.idestado_curso=idestado_curso;
    }

    public Estadocurso(String idestado_curso) {
        this.idestado_curso = idestado_curso;
    }

    public String getTipo_estado_curso() {
        return tipo_estado_curso;
    }

    public void setTipo_estado_curso(String tipo_estado_curso) {
        this.tipo_estado_curso = tipo_estado_curso;
    }

    public String getIdestado_curso() {
        return idestado_curso;
    }

    public void setIdestado_curso(String idestado_curso) {
        this.idestado_curso = idestado_curso;
    }
    
}
