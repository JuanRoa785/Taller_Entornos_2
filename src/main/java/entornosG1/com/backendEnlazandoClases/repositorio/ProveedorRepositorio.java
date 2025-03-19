package entornosG1.com.backendEnlazandoClases.repositorio;

import entornosG1.com.backendEnlazandoClases.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roa
 */
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    
}
