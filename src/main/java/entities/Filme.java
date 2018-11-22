
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
import types.SimNaoType;

@Entity
@Table(name = "filmes")
@SequenceGenerator(allocationSize = 1, name = "seq_filme", sequenceName = "seq_filme")
public class Filme implements Serializable {
    
    private Integer id;
    private String ano;
    private String titulo;
    private String descricao;
    private Integer duracao;
    private SimNaoType ativo;
    private SimNaoType emCartaz;
    private Diretor diretor;
    private Genero genero;
    private FaixaEtaria faixaEtaria;
    private byte[] poster;
    
    public Filme() {}

    public Filme(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_filme", strategy = GenerationType.IDENTITY)
    @Column(name = "id_filme")
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "tx_ano")
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Column(name = "tx_titulo")
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "tx_descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Column(name = "vl_duracao")
    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    @Column(name = "dm_ativo")
    @Enumerated(EnumType.STRING)
    public SimNaoType getAtivo() {
        return ativo;
    }

    public void setAtivo(SimNaoType ativo) {
        this.ativo = ativo;
    }

    @Column(name = "dm_em_cartaz")
    @Enumerated(EnumType.STRING)
    public SimNaoType getEmCartaz() {
        return emCartaz;
    }

    public void setEmCartaz(SimNaoType emCartaz) {
        this.emCartaz = emCartaz;
    }

    @JoinColumn(name = "id_diretor")
    @ManyToOne
    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    @JoinColumn(name = "id_genero")
    @ManyToOne
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @JoinColumn(name = "id_faixa_etaria")
    @ManyToOne
    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    @Column(name = "tx_poster")
    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }
    
    
    
}
