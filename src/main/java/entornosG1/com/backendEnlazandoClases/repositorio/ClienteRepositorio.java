package entornosG1.com.backendEnlazandoClases.repositorio;

import entornosG1.com.backendEnlazandoClases.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roa
 */
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    
}
