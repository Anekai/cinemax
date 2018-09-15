
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
import types.TelaType;

@Entity
@Table(name = "permissoes")
@SequenceGenerator(allocationSize = 1, name = "seq_permissao", sequenceName = "seq_permissao")
public class Permissao implements Serializable {
    
    private Integer id;
    private Cargo cargo;
    private TelaType tela;
    private SimNaoType permiteVisualizar;
    private SimNaoType permiteCriar;
    private SimNaoType permiteEditar;

    public Permissao() {}
    
    public Permissao(Integer id) {
        this.id = id;
    }
    
    @Id
    @GeneratedValue(generator = "seq_permissao", strategy = GenerationType.IDENTITY)
    @Column(name = "id_permissao")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @JoinColumn(name = "id_cargo")
    @ManyToOne
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Column(name = "dm_tela")
    @Enumerated(EnumType.STRING)
    public TelaType getTela() {
        return tela;
    }

    public void setTela(TelaType tela) {
        this.tela = tela;
    }

    @Column(name = "dm_permite_visualizar")
    @Enumerated(EnumType.STRING)
    public SimNaoType getPermiteVisualizar() {
        return permiteVisualizar;
    }

    public void setPermiteVisualizar(SimNaoType permiteVisualizar) {
        this.permiteVisualizar = permiteVisualizar;
    }

    @Column(name = "dm_permite_criar")
    @Enumerated(EnumType.STRING)
    public SimNaoType getPermiteCriar() {
        return permiteCriar;
    }

    public void setPermiteCriar(SimNaoType permiteCriar) {
        this.permiteCriar = permiteCriar;
    }

    @Column(name = "dm_permite_editar")
    @Enumerated(EnumType.STRING)
    public SimNaoType getPermiteEditar() {
        return permiteEditar;
    }

    public void setPermiteEditar(SimNaoType permiteEditar) {
        this.permiteEditar = permiteEditar;
    }
    
    
    
}
