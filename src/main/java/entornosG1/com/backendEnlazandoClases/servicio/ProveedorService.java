package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Proveedor;
import entornosG1.com.backendEnlazandoClases.repositorio.ProveedorRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author roa
 */
@Service
@Transactional
public class ProveedorService  implements  IProveedorService{
    @Autowired
    ProveedorRepositorio proveedorRepositorio;

    @Override
    public List<Proveedor> getProveedores() {
       return proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor nuevoProveedor(Proveedor proveedor) {
       return proveedorRepositorio.save(proveedor);
    }

    @Override
    public Proveedor buscarProveedor(Long id) {
       return proveedorRepositorio.findById(id).orElse(null);
    }

    @Override
    public Proveedor borrarProveedor(Long id) {
        Proveedor proveedor = proveedorRepositorio.findById(id).orElse(null);
        if(proveedor ==null){
            return null;
        }
        proveedorRepositorio.delete(proveedor);
        return proveedor;
    }
}
