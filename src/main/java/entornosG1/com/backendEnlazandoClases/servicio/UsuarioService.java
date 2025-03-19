package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Usuario;
import entornosG1.com.backendEnlazandoClases.repositorio.UsuarioRepositorio;
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
public class UsuarioService  implements  IUsuarioService{

    @Autowired
    UsuarioRepositorio UsuarioRepositorio;
    
    @Override
    public List<Usuario> getUsuarios() {
       return UsuarioRepositorio.findAll();
    }

    @Override
    public Usuario nuevoUsuario(Usuario usuario) {
       return UsuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        Usuario usuario = UsuarioRepositorio.findById(id).orElse(null);
        if (usuario == null) {
            return null;
        }
        return usuario;
    }

    @Override
    public int borrarUsuario(Long id) {
       UsuarioRepositorio.deleteById(id);
       return 1;
    }
}
