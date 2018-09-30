
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
@Table(name = "telas")
@SequenceGenerator(allocationSize = 1, name = "seq_tela", sequenceName = "seq_tela")
public class Tela implements Serializable {
    
    private Integer id;
    private String nome;
    
    @Id
    @GeneratedValue(generator = "seq_tela", strategy = GenerationType.IDENTITY)
    @Column(name = "id_tela")
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
}
