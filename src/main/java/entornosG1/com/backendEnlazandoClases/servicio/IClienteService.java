package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Cliente;
import java.util.List;

/**
 *
 * @author roa
 */
public interface IClienteService {
    List<Cliente> getClientes();
    
    Cliente nuevoCliente(Cliente cliente);
    
    Cliente buscarCliente(Long id);
    
    Cliente borrarCliente(Long id);
}
