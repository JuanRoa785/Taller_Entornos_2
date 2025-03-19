package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Producto;
import java.util.List;

/**
 *
 * @author Juan Diego Roa
 */
public interface IProductoService {
    List<Producto> getProducto();
    
    Producto nuevoProducto(Producto producto);
    
    Producto buscarProducto(Long id);
    
    Producto borrarProducto(Long id);
}
