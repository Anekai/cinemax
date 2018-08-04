
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
@Table(name = "cargos")
@SequenceGenerator(allocationSize = 1, name = "seq_cargo", sequenceName = "seq_cargo")
public class Cargo implements Serializable {
    
    private Integer id;
    private String nome;
    private String funcionalidade;
    private SimNaoType ativo;

    public Cargo() {}

    public Cargo(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "seq_cargo", strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo")
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
    
    @Column(name = "tx_funcionalidades")
    public String getFuncionalidade() {
        return funcionalidade;
    }
    public void setFuncionalidade(String funcionalidade) {
        this.funcionalidade = funcionalidade;
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
