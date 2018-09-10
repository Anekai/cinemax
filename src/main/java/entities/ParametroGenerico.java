
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "parametros_genericos")
@SequenceGenerator(allocationSize = 1, name = "seq_parametro_generico", sequenceName = "seq_parametro_generico")
public class ParametroGenerico implements Serializable {
    
    private Integer id;
    private String nome;
    private String valor;
    
    public ParametroGenerico() {}

    public ParametroGenerico(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "seq_parametro_generico", strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro_generico")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nm_parametro")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "tx_valor")
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}
