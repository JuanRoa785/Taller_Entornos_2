package entornosG1.com.backendEnlazandoClases.servicio;

import entornosG1.com.backendEnlazandoClases.modelo.Producto;
import entornosG1.com.backendEnlazandoClases.repositorio.ProductoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Juan Diego Roa
 */
@Service
@Transactional
public class ProductoService implements IProductoService{
    @Autowired
    ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> getProducto() {
       return productoRepositorio.findAll();
    }

    @Override
    public Producto nuevoProducto(Producto producto) {
       return productoRepositorio.save(producto);
    }

    @Override
    public Producto buscarProducto(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    @Override
    public Producto borrarProducto(Long id) {
        Producto producto = this.buscarProducto(id);
        if(producto == null){
            return null;
        }
        productoRepositorio.delete(producto);
        return producto;
    }
}
