
package modelos;


public class Gastosvarios {
    private String nombre_gasto, descripcion_gasto, costo_gasto, fecha_gasto;
    private String idgastos_varios;
    
    public Gastosvarios(){
        super();
    }

    public Gastosvarios(String idgastos_varios) {
        this.idgastos_varios = idgastos_varios;
    }

    public Gastosvarios(String nombre_gasto, String descripcion_gasto, String costo_gasto, String fecha_gasto, String idgastos_varios) {
        this.nombre_gasto = nombre_gasto;
        this.descripcion_gasto = descripcion_gasto;
        this.costo_gasto = costo_gasto;
        this.fecha_gasto = fecha_gasto;
        this.idgastos_varios = idgastos_varios;
    }

    public String getNombre_gasto() {
        return nombre_gasto;
    }

    public void setNombre_gasto(String nombre_gasto) {
        this.nombre_gasto = nombre_gasto;
    }

    public String getDescripcion_gasto() {
        return descripcion_gasto;
    }

    public void setDescripcion_gasto(String descripcion_gasto) {
        this.descripcion_gasto = descripcion_gasto;
    }

    public String getCosto_gasto() {
        return costo_gasto;
    }

    public void setCosto_gasto(String costo_gasto) {
        this.costo_gasto = costo_gasto;
    }

    public String getFecha_gasto() {
        return fecha_gasto;
    }

    public void setFecha_gasto(String fecha_gasto) {
        this.fecha_gasto = fecha_gasto;
    }

    public String getIdgastos_varios() {
        return idgastos_varios;
    }

    public void setIdgastos_varios(String idgastos_varios) {
        this.idgastos_varios = idgastos_varios;
    }
    
}
