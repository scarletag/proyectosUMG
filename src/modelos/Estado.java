
package modelos;


public class Estado {
    private String tipo_estado;
    private String idestados;
    
    public Estado(){
        super();
    }
    public Estado(String tipo_estado, String idestados){
        this.tipo_estado=tipo_estado;
        this.idestados=idestados;
    }

    public Estado(String idestados) {
        this.idestados = idestados;
    }

    public String getTipo_estado() {
        return tipo_estado;
    }

    public void setTipo_estado(String tipo_estado) {
        this.tipo_estado = tipo_estado;
    }

    public String getIdestados() {
        return idestados;
    }

    public void setIdestados(String idestados) {
        this.idestados = idestados;
    }
    
}
