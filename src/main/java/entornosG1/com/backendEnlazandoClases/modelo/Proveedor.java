package entornosG1.com.backendEnlazandoClases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 *
 * @author roa
 */
@Entity
@Table(name=Proveedor.TABLE_NAME)
public class Proveedor {
    public static final String TABLE_NAME = "proveedor";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    
    @Size(min = 3, max = 50, message = "La ciudad DEBE tener entre 3 y 50 caracteres")
    @Column(name = "ciudad", nullable = true, length = 50)
    private String ciudad;
    
    @Size(min = 10, max = 50, message = "La dirección DEBE tener entre 10 y 50 caracteres")
    @Column(name = "direccion", nullable = true, length = 50)
    private String direccion;
    
    @Size(min = 3, max = 100, message = "El nombre DEBE estar entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;
    
    @Size(min = 10, max = 15, message = "El telefono DEBE estar entre 10 y 15 caracteres")
    @Column(name = "telefono", nullable = true, length = 20)
    private String telefono;
    
    @Size(min = 10, max = 10, message = "El NIT DEBE tener 10 caracteres")
    @Column(name = "nit", nullable = true, length = 20)
    private String nit;

    public Proveedor() {
        
    }

    public Proveedor(Long id, String ciudad, String direccion, String nombre, String telefono, String nit) {
        this.id = id;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nit = nit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
