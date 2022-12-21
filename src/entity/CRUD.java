
package entity;
import java.util.List;

public interface CRUD<T, ID> {
    
    // metodo para listar
    List<T> listar();
    // metodo para listar por id
    List<T> listarPorId(ID entity);
    // metodo para agregar
    boolean agregar(T entity);
    // metodo para modificar
    boolean modificar(T entity);
    // metodo para eliminar
    boolean eliminar(ID id);
    // metodo para eliminar todos los registros
    boolean eliminarTodos();
    
}
