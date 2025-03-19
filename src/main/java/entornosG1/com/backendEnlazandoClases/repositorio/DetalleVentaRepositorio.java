package entornosG1.com.backendEnlazandoClases.repositorio;

import entornosG1.com.backendEnlazandoClases.modelo.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roa
 */
public interface DetalleVentaRepositorio extends JpaRepository<DetalleVenta, Long>{
    
}
