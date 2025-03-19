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

/**
 *
 * @author roa
 */
@Entity
@Table(name=DetalleVenta.TABLE_NAME)
public class DetalleVenta {
    public static final String TABLE_NAME = "detalleventa";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @ManyToOne
    @NotNull(message = "El ID de la venta NO puede ser nulo")
    @JoinColumn(name = "idVenta", nullable = false)
    private Venta idVenta;
    
    @ManyToOne
    @NotNull(message = "El ID del producto NO puede ser nulo")
    @JoinColumn(name = "idProducto", nullable = false)
    private Producto idProducto;
    
    @NotNull(message = "La cantidad del Producto NO puede ser nula")
    @Positive(message = "La cantidad del Producto debe ser mayor a cero")
    @Column(name = "cantidadProducto", nullable = false)
    private Long cantidadProducto;
    
    @NotNull(message = "El valor total NO puede ser nulo")
    @Positive(message = "El valor total DEBE ser mayor a cero")
    @Column(name = "valorTotal", nullable = false)
    private Double valorTotal;
    
    @NotNull(message = "El valor de la venta NO puede ser nulo")
    @Positive(message = "El valor de la venta DEBE ser mayor a cero")
    @Column(name = "valorVenta", nullable = false)
    private Double valorVenta;
    
    @NotNull(message = "El valor del IVA NO puede ser nulo")
    @Positive(message = "El valor del IVA debe ser mayor a cero")
    @Column(name = "valorIva", nullable = false)
    private Double valorIva;

    public DetalleVenta() {
        
    }

    public DetalleVenta(Long id, Venta idVenta, Producto idProducto, Long cantidadProducto, Double valorTotal, Double valorVenta, Double valorIva) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidadProducto = cantidadProducto;
        this.valorTotal = valorTotal;
        this.valorVenta = valorVenta;
        this.valorIva = valorIva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Long getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Long cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Double getValorIva() {
        return valorIva;
    }

    public void setValorIva(Double valorIva) {
        this.valorIva = valorIva;
    }
}
