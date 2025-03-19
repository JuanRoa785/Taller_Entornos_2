package entornosG1.com.backendEnlazandoClases.controlador;

import entornosG1.com.backendEnlazandoClases.modelo.Producto;
import entornosG1.com.backendEnlazandoClases.servicio.ProductoService;
import entornosG1.com.backendEnlazandoClases.servicio.ProveedorService;
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
 * @author Juan Diego Roa
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    
    @Autowired
    ProveedorService ProveedorService;
    
    @GetMapping("/list")
    public List<Producto> cargarProductos(){
        return productoService.getProducto();
    }
    
    @GetMapping("/list/{id}")
    public Producto buscarPorId(@PathVariable Long id){
        Producto producto = productoService.buscarProducto(id);
        if(producto == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        } 
        return producto;
    }
    
    @PostMapping("/addProduct")
    public ResponseEntity<Producto> agregarProducto(@Valid @RequestBody Producto producto){
        if(ProveedorService.buscarProveedor(producto.getIdProveedor().getId()) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor invalido");
        }
        Producto obj = productoService.nuevoProducto(producto);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping("/updateProduct")
    public ResponseEntity<Producto> editar(@Valid @RequestBody Producto producto){
        Producto obj = productoService.borrarProducto(producto.getId());
        if (obj != null) {
            
            if(ProveedorService.buscarProveedor(producto.getIdProveedor().getId()) == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Proveedor invalido");
            }
            
            obj.setIdProveedor(producto.getIdProveedor());
            obj.setIvaCompra(producto.getIvaCompra());
            obj.setNombre(producto.getNombre());
            obj.setPrecioCompra(producto.getPrecioCompra());
            obj.setPrecioVenta(producto.getPrecioVenta());
            
            productoService.nuevoProducto(obj);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Producto> eliminar(@PathVariable Long id){
        Producto obj = productoService.buscarProducto(id);
        if(obj != null) {
            productoService.borrarProducto(id);
            return new ResponseEntity<>(obj, HttpStatus.OK);
        }
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
    }
}
