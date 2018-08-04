
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
@Table(name = "faixas_etarias")
@SequenceGenerator(allocationSize = 1, name = "seq_faixa_etaria", sequenceName = "seq_faixa_etaria")
public class FaixaEtaria implements Serializable {
    
    private Integer id;
    private String nome;
    private String descricao;
    private SimNaoType ativo;

    public FaixaEtaria() {}

    public FaixaEtaria(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "seq_faixa_etaria", strategy = GenerationType.IDENTITY)
    @Column(name = "id_faixa_etaria")
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
    
    @Column(name = "tx_descricao")
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
