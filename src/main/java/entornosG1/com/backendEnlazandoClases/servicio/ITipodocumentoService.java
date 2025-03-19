package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Tipodocumento;
import java.util.List;

/**
 *
 * @author Juan Diego Roa
 */
public interface ITipodocumentoService {
    List<Tipodocumento> getTipodocumento();
    
    Tipodocumento nuevoTipodocumento(Tipodocumento tipodocumento);
    
    Tipodocumento buscarTipodocumento(Long id);
    
    Tipodocumento borrarTipodocumento(Long id);
}
