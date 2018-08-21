
package entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produtos")
@SequenceGenerator(allocationSize = 1, name = "seq_exibicao", sequenceName = "seq_exibicao")
public class Exibicao implements Serializable {
        
    private Integer id;
    private Calendar dataExibicao;
    private Sala sala;
    private Sessao sessao;
    private Filme filme;

    public Exibicao() {}

    public Exibicao(Integer id) {
        setId(id);
    }
    
    @Id
    @GeneratedValue(generator = "seq_exibicao", strategy = GenerationType.IDENTITY)
    @Column(name = "id_exibicao")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dt_exibicao")
    @Temporal(value = TemporalType.TIMESTAMP)
    public Calendar getDataExibicao() {
        return dataExibicao;
    }

    public void setDataExibicao(Calendar dataExibicao) {
        this.dataExibicao = dataExibicao;
    }

    @JoinColumn(name = "id_sala")
    @ManyToOne
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @JoinColumn(name = "id_sessao")
    @ManyToOne
    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
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
