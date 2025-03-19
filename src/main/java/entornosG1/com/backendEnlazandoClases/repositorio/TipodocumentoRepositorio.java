package entornosG1.com.backendEnlazandoClases.repositorio;

import entornosG1.com.backendEnlazandoClases.modelo.Tipodocumento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author roa
 */
public interface TipodocumentoRepositorio  extends JpaRepository<Tipodocumento, Long>{
    
}
