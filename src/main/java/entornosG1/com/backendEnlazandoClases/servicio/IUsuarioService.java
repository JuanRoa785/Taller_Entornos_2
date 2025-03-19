package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Usuario;
import java.util.List;

/**
 *
 * @author roa
 */
public interface IUsuarioService {
    List<Usuario> getUsuarios();
    
    Usuario nuevoUsuario(Usuario usuario);
    
    Usuario buscarUsuario(Long id);
    
    int borrarUsuario(Long id);
}
