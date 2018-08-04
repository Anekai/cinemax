
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import types.SimNaoType;

@Entity
@Table(name = "sessoes")
@SequenceGenerator(allocationSize = 1, name = "seq_sessao", sequenceName = "seq_sessao")
public class Sessao implements Serializable {
    
    private Integer id;
    private Calendar dataExibicao;
    private BigDecimal preco;
    private SimNaoType ativo;
    private Sala sala;
    private Filme filme;
    
    public Sessao() {}

    public Sessao(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_sessao", strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingresso")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dt_exibicao")
    @Temporal(value = TemporalType.DATE)
    public Calendar getDataExibicao() {
        return dataExibicao;
    }

    public void setDataExibicao(Calendar dataExibicao) {
        this.dataExibicao = dataExibicao;
    }

    @Column(name = "vl_preco")
    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @Column(name = "dm_ativo")
    @Enumerated(EnumType.STRING)
    public SimNaoType getAtivo() {
        return ativo;
    }

    public void setAtivo(SimNaoType ativo) {
        this.ativo = ativo;
    }

    @JoinColumn(name = "id_sala")
    @ManyToOne
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @JoinColumn(name = "id_filme")
    @ManyToOne
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    
    
}
