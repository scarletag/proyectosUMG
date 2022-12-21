
package modelos;


public class Horario {
    private String horario;
    private String idehorarios;
    
    public Horario(){
        super();
    }
    public Horario(String horario, String idehorarios){
        this.horario=horario;
        this.idehorarios=idehorarios=idehorarios;
    }

    public Horario(String idehorarios) {
        this.idehorarios = idehorarios;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getIdehorarios() {
        return idehorarios;
    }

    public void setIdehorarios(String idehorarios) {
        this.idehorarios = idehorarios;
    }
    
}
