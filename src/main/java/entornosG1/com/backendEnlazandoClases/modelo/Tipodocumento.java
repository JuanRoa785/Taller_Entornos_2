package entornosG1.com.backendEnlazandoClases.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author roa
 */
@Entity
@Table(name=Tipodocumento.TABLE_NAME)
public class Tipodocumento {
    
    public static final String TABLE_NAME = "tipodocumento";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "La descripción del tipo de documento NO puede ser nula")
    @Column(name = "tipo", length = 50, nullable = false)
    private String tipo;

    public Tipodocumento() {
    
    }

    public Tipodocumento(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
