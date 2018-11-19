
package entities;

import java.io.Serializable;
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
import types.OperacaoType;

@Entity
@Table(name = "arquivos_auditorias")
@SequenceGenerator(allocationSize = 1, name = "seq_arquivo_auditoria", sequenceName = "seq_arquivo_auditoria")
public class ArquivoAuditoria implements Serializable {
    
    private Long id;
    private OperacaoType operacao;
    private Calendar dataStamp;
    private String usuarioStamp;
    private String tabela;
    private String dados;

    public ArquivoAuditoria() {}

    public ArquivoAuditoria(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "seq_arquivo_auditoria", strategy = GenerationType.IDENTITY)
    @Column(name = "id_arquivo_auditoria")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "dm_operacao")
    @Enumerated(EnumType.STRING)
    public OperacaoType getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoType operacao) {
        this.operacao = operacao;
    }

    @Column(name = "data_stamp")
    @Temporal(value = TemporalType.TIMESTAMP)
    public Calendar getDataStamp() {
        return dataStamp;
    }

    public void setDataStamp(Calendar dataStamp) {
        this.dataStamp = dataStamp;
    }

    @Column(name = "usuario_stamp")
    public String getUsuarioStamp() {
        return usuarioStamp;
    }

    public void setUsuarioStamp(String usuarioStamp) {
        this.usuarioStamp = usuarioStamp;
    }

    @Column(name = "nm_tabela")
    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    @Column(name = "tx_dados")
    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
    
}
