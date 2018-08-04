
package entities;

import java.io.Serializable;
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
import types.PoltronaType;
import types.SimNaoType;
import types.TipoIngressoType;

@Entity
@Table(name = "ingressos")
@SequenceGenerator(allocationSize = 1, name = "seq_ingresso", sequenceName = "seq_ingresso")
public class Ingresso implements Serializable {
    
    private Integer id;
    private TipoIngressoType tipoIngresso;
    private PoltronaType poltrona;
    private SimNaoType ativo;
    private Sessao sessao;
    private Funcionario funcionario;
    
    public Ingresso() {}

    public Ingresso(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_ingresso", strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingresso")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dm_tipo")
    @Enumerated(EnumType.STRING)
    public TipoIngressoType getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngressoType tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    @Column(name = "dm_poltrona")
    @Enumerated(EnumType.STRING)
    public PoltronaType getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(PoltronaType poltrona) {
        this.poltrona = poltrona;
    }

    @Column(name = "dm_ativo")
    @Enumerated(EnumType.STRING)
    public SimNaoType getAtivo() {
        return ativo;
    }

    public void setAtivo(SimNaoType ativo) {
        this.ativo = ativo;
    }

    @JoinColumn(name = "id_sessao")
    @ManyToOne
    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    @JoinColumn(name = "id_funcionario")
    @ManyToOne
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
}
