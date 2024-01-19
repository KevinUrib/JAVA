
package modelo;

import java.util.List;

/**
 *
 * @author Kevin Uribe
 */
public interface CRUD {
    
    public List listar();
    
    public int add(Object[] o);
    
    public int actualizar(Object[] o);
    
    public void eliminar(int id);
   
  
}
