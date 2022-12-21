
package modelos;

public class Ciclo {
    private int idciclo_escolar;
    private String ciclo_escolar;
    
    public Ciclo(){
        super();
    }

    public Ciclo(int idciclo_escolar, String ciclo_escolar) {
        this.idciclo_escolar = idciclo_escolar;
        this.ciclo_escolar = ciclo_escolar;
    }

    public Ciclo(int idciclo_escolar) {
        this.idciclo_escolar = idciclo_escolar;
    }

    public int getIdciclo_escolar() {
        return idciclo_escolar;
    }

    public void setIdciclo_escolar(int idciclo_escolar) {
        this.idciclo_escolar = idciclo_escolar;
    }

    public String getCiclo_escolar() {
        return ciclo_escolar;
    }

    public void setCiclo_escolar(String ciclo_escolar) {
        this.ciclo_escolar = ciclo_escolar;
    }
    
    
}
