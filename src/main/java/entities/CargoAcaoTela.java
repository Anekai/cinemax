
package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cargos_acoes_telas")
@SequenceGenerator(allocationSize = 1, name = "seq_cargo_acao_tela", sequenceName = "seq_cargo_acao_tela")
public class CargoAcaoTela implements Serializable {
    
    private Integer id;
    private Cargo cargo;
    private AcaoTela acaoTela;
    
    @Id
    @GeneratedValue(generator = "seq_cargo_acao_tela", strategy = GenerationType.IDENTITY)
    @Column(name = "id_cargo_acao_tela")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
}
