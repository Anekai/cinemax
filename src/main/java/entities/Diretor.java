
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import types.SimNaoType;

@Entity
@Table(name = "diretores")
@SequenceGenerator(allocationSize = 1, name = "seq_diretor", sequenceName = "seq_diretor")
public class Diretor implements Serializable {
    
    private Integer id;
    private String nome;
    private SimNaoType ativo;

    public Diretor() {}

    public Diretor(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "seq_diretor", strategy = GenerationType.IDENTITY)
    @Column(name = "id_diretor")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "tx_nome")
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Column(name = "dm_ativo")
    @Enumerated(EnumType.STRING)
    public SimNaoType getAtivo() {
        return ativo;
    }
    
    public void setAtivo(SimNaoType ativo) {
        this.ativo = ativo;
    }
    
}
