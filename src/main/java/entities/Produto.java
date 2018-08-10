package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import types.SimNaoType;
import types.TipoUnidadeType;

@Entity
@Table(name = "produtos")
@SequenceGenerator(allocationSize = 1, name = "seq_produto", sequenceName = "seq_produto")
public class Produto implements Serializable {
 
    private static final long serialVersionUID = 4708483401333597676L;

    private Integer id;
    private String nome;
    private TipoUnidadeType unidade;
    private Integer quantidade;
    private BigDecimal preco;
    private SimNaoType ativo;

    public Produto() {}

    public Produto(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_produto", strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
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
    
    @Column(name = "dm_unidade")
    @Enumerated(EnumType.STRING)
    public TipoUnidadeType getUnidade() {
        return unidade;
    }
    
    public void setUnidade(TipoUnidadeType unidade) {
        this.unidade = unidade;
    }
    
    @Column(name = "vl_quantidade")
    public Integer getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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