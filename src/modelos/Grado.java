
package modelos;

public class Grado {
    private int idgrados;
    private String nombre_grado;

    public Grado() {
        super();
    }

    public Grado(int idgrados, String nombre_grado) {
        this.idgrados = idgrados;
        this.nombre_grado = nombre_grado;
    }

    public Grado(int idgrados) {
        this.idgrados = idgrados;
    }

    public int getIdgrados() {
        return idgrados;
    }

    public void setIdgrados(int idgrados) {
        this.idgrados = idgrados;
    }

    public String getNombre_grado() {
        return nombre_grado;
    }

    public void setNombre_grado(String nombre_grado) {
        this.nombre_grado = nombre_grado;
    }
    
    
    
    
}
