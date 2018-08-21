
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
    private Calendar horario;
    private BigDecimal preco;
    private SimNaoType ativo;
    
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
    @Temporal(value = TemporalType.TIMESTAMP)
    public Calendar getHorario() {
        return horario;
    }

    public void setHorario(Calendar horario) {
        this.horario = horario;
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

}
