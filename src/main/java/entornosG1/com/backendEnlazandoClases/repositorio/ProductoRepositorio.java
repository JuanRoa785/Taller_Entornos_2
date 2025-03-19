package entornosG1.com.backendEnlazandoClases.repositorio;

import entornosG1.com.backendEnlazandoClases.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roa
 */
public interface ProductoRepositorio extends JpaRepository<Producto, Long>{
    
}
