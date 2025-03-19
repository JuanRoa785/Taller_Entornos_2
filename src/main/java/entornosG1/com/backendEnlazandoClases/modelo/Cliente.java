package entornosG1.com.backendEnlazandoClases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 *
 * @author roa
 */
@Entity
@Table(name=Cliente.TABLE_NAME)
public class Cliente {
     public static final String TABLE_NAME = "cliente";
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @ManyToOne
    @NotNull(message = "El ID del tipo de documento NO puede ser nulo")
    @JoinColumn(name = "idTipoDocumento", nullable = false)
    private Tipodocumento idTipodocumento;
    
    @NotNull(message = "El número del documento NO puede ser nulo") 
    @Size(min = 5, max = 100, message = "El documento DEBE tener minimo 5 caracteres")
    @Column(name = "numeroDocumento", nullable = false, length = 25, unique = true)
    private String numeroDocumento;
    
    @NotNull(message = "La dirección NO puede ser nula")
    @Size(min = 10, max = 50, message = "La dirección DEBE tener entre 10 y 50 caracteres")
    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;
    
    @NotNull(message = "El correo NO puede ser nulo")
    @Size(min =10, message = "El email debe tener MINIMO 10 caracteres")
    @Email(message = "El correo electronico ingresado, NO es valido")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    
    @NotNull(message = "El nombre NO puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre DEBE estar entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @NotNull(message = "El telefono NO puede ser nulo")
    @Size(min = 10, max = 10, message = "El telefono DEBE tener 10 caracteres")
    @Column(name = "telefono", nullable = false, length = 20)
    private String telefono;

    public Cliente() {
    
    }

    public Cliente(Long id, Tipodocumento idTipodocumento, String numeroDocumento, String direccion, String email, String nombre, String telefono) {
        this.id = id;
        this.idTipodocumento = idTipodocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipodocumento getIdTipodocumento() {
        return idTipodocumento;
    }

    public void setIdTipodocumento(Tipodocumento idTipodocumento) {
        this.idTipodocumento = idTipodocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
