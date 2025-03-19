package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Cliente;
import entornosG1.com.backendEnlazandoClases.repositorio.ClienteRepositorio;
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
public class ClienteService implements IClienteService{
    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Cliente nuevoCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public Cliente borrarCliente(Long id) {
        Cliente cliente = clienteRepositorio.findById(id).orElse(null);
        if(cliente == null){
            return null;
        } else {
            clienteRepositorio.delete(cliente);
            return cliente;
        }
    }
}
