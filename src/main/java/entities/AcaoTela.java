
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
@Table(name = "acoes_telas")
@SequenceGenerator(allocationSize = 1, name = "seq_acao_tela", sequenceName = "seq_acao_tela")
public class AcaoTela implements Serializable {
    
    private Integer id;
    private Acao acao;
    private Tela tela;
    
    @Id
    @GeneratedValue(generator = "seq_acao_tela", strategy = GenerationType.IDENTITY)
    @Column(name = "id_acao_tela")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
}
