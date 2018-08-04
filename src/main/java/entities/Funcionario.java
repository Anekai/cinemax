package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import types.SimNaoType;

@Entity
@Table(name = "funcionarios")
@SequenceGenerator(allocationSize = 1, name = "seq_funcionario", sequenceName = "seq_funcionario")
public class Funcionario implements Serializable {
 
    private Integer id;
    private String nome;
    private String sobrenome;
    private Calendar dataNascimento;
    private Calendar dataContratacao;
    private String login;
    private String senha;
    private SimNaoType ativo;
    private Cargo cargo;

    public Funcionario() {}

    public Funcionario(Integer id) {
        setId(id);
    }

    @Id
    @GeneratedValue(generator = "seq_funcionario", strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
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
    
    @Column(name = "tx_sobrenome")
    public String getSobreNome() {
        return sobrenome;
    }
    public void setSobreNome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    @Column(name = "dt_nascimento")
    @Temporal(value = TemporalType.DATE)
    public Calendar getDataNascimento() {
        return dataNascimento;
    }
    
    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Column(name = "dt_contratacao")
    @Temporal(value = TemporalType.DATE)
    public Calendar getDataContratacao() {
        return dataContratacao;
    }
    
    public void setDataContratacao(Calendar dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    
    @Column(name = "tx_login")
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "tx_senha")
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Column(name = "dm_ativo")
    @Enumerated(EnumType.STRING)
    public SimNaoType getAtivo() {
        return ativo;
    }
    
    public void setAtivo(SimNaoType ativo) {
        this.ativo = ativo;
    }
    
    @JoinColumn(name = "id_cargo")
    @ManyToOne
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
