package entornosG1.com.backendEnlazandoClases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 *
 * @author roa
 */

@Entity
@Table(name=Producto.TABLE_NAME)
public class Producto {
    public static final String TABLE_NAME = "producto";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @ManyToOne
    @NotNull(message = "El ID del proveedor NO puede ser nulo")
    @JoinColumn(name = "idProveedor", nullable = false)
    private Proveedor idProveedor;
    
    @NotNull(message = "El IVA NO puede ser nulo")
    @Positive(message = "El IVA DEBE ser mayor a cero")
    @Column(name = "ivaCompra", nullable = false)
    private Double ivaCompra;
    
    @Size(min = 3, max = 100, message = "El nombre DEBE estar entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;
    
    @NotNull(message = "El precio de compra NO puede ser nulo")
    @Positive(message = "El precio de compra DEBE ser mayor a cero")
    @Column(name = "precioCompra", nullable = false)
    private Double precioCompra;
    
    @NotNull(message = "El precio de venta NO puede ser nulo")
    @Positive(message = "El precio de venta DEBE ser mayor a cero")
    @Column(name = "precioVenta", nullable = false)
    private Double precioVenta;

    public Producto() {
        
    }

    public Producto(Long id, Proveedor idProveedor, Double ivaCompra, String nombre, Double precioCompra, Double precioVenta) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.ivaCompra = ivaCompra;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Double getIvaCompra() {
        return ivaCompra;
    }

    public void setIvaCompra(Double ivaCompra) {
        this.ivaCompra = ivaCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }
}
