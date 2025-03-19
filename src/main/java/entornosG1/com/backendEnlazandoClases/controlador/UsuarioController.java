package entornosG1.com.backendEnlazandoClases.controlador;

import entornosG1.com.backendEnlazandoClases.modelo.Usuario;
import entornosG1.com.backendEnlazandoClases.servicio.UsuarioService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author roa
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/list")
    public List<Usuario> cargarUsuario(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/list/{id}")
    public Usuario buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarUsuario(id);
        if(usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        } 
        return usuario;
    }
    
    @PostMapping("/addUser")
    public ResponseEntity<Usuario> agregarUsuario(@Valid @RequestBody Usuario usuario){
        Usuario obj = usuarioService.nuevoUsuario(usuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/updateUser")
    public ResponseEntity<Usuario> editar(@Valid @RequestBody Usuario usuario){
        Usuario obj = usuarioService.buscarUsuario(usuario.getId());
        if (obj != null) {
            obj.setEmail(usuario.getEmail());
            obj.setIdTipodocumento(usuario.getIdTipodocumento());
            obj.setNombre(usuario.getNombre());
            obj.setNombreUsuario(usuario.getNombreUsuario());
            obj.setNumeroDocumento(usuario.getNumeroDocumento());
            obj.setPassword(usuario.getPassword());
            usuarioService.nuevoUsuario(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }  
    }
    
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Usuario> eliminar(@PathVariable Long id){
        Usuario obj = usuarioService.buscarUsuario(id);
        if(obj != null) {
            usuarioService.borrarUsuario(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado");
        }
    }
}
