package entornosG1.com.backendEnlazandoClases.controlador;

import entornosG1.com.backendEnlazandoClases.modelo.Cliente;
import entornosG1.com.backendEnlazandoClases.servicio.ClienteService;
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
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/list")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/list/{id}")
    public Cliente buscarPorId(@PathVariable Long id){
        Cliente cliente = clienteService.buscarCliente(id);
        if(cliente == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
        return cliente;
    }
    
    @PostMapping("/addClient")
    public ResponseEntity<Cliente> agregarCliente(@Valid @RequestBody Cliente cliente){
        Cliente obj = clienteService.nuevoCliente(cliente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/updateClient")
    public ResponseEntity<Cliente> editar(@Valid @RequestBody Cliente cliente){
        Cliente obj = clienteService.buscarCliente(cliente.getId());
        if (obj != null) {
           
            obj.setIdTipodocumento(cliente.getIdTipodocumento());
            obj.setNumeroDocumento(cliente.getNumeroDocumento());
            obj.setDireccion(cliente.getDireccion());
            obj.setEmail(cliente.getEmail());
            obj.setNombre(cliente.getNombre());
            obj.setTelefono(cliente.getTelefono());
            
            clienteService.nuevoCliente(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }  
    }
    
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<Cliente> eliminar(@PathVariable Long id){
        Cliente obj = clienteService.buscarCliente(id);
        if(obj != null) {
            clienteService.borrarCliente(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
    }
}
