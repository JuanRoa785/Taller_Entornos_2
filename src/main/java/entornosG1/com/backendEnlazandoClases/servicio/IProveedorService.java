package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Proveedor;
import java.util.List;

/**
 *
 * @author roa
 */
public interface IProveedorService {
    List<Proveedor> getProveedores();
    
    Proveedor nuevoProveedor(Proveedor proveedor);
    
    Proveedor buscarProveedor(Long id);
    
    Proveedor borrarProveedor(Long id);
}
