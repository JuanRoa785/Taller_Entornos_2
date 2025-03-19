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
@Table(name=Venta.TABLE_NAME)
public class Venta {
    public static final String TABLE_NAME = "venta";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @ManyToOne
    @NotNull(message = "El ID del cliente NO puede ser nulo")
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente idCliente;
    
    @ManyToOne
    @NotNull(message = "El ID del usuario NO puede ser nulo")
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;
    
    @NotNull(message = "El IVA NO puede ser nulo")
    @Positive(message = "El IVA DEBE ser mayor a cero")
    @Column(name = "ivaVenta", nullable = false)
    private Double ivaVenta;
    
    @NotNull(message = "El total de la venta NO puede ser nulo")
    @Positive(message = "El total de la venta DEBE ser mayor a cero")
    @Column(name = "totalVenta", nullable = false)
    private Double totalVenta;
    
    @NotNull(message = "El valor de la venta NO puede ser nulo")
    @Positive(message = "El valor de la venta DEBE ser mayor a cero")
    @Column(name = "valorVenta", nullable = false)
    private Double valorVenta;

    public Venta() {
        
    }

    public Venta(Long id, Cliente idCliente, Usuario idUsuario, Double ivaVenta, Double totalVenta, Double valorVenta) {
        this.id = id;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.ivaVenta = ivaVenta;
        this.totalVenta = totalVenta;
        this.valorVenta = valorVenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Double getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(Double ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }
}
