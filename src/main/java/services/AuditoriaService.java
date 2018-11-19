
package services;

import daos.AuditoriaDAO;
import entities.Auditoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditoriaService {
    
    @Autowired
    AuditoriaDAO dao;

    public void insert(Auditoria entity) {
        dao.insert(entity);
    }

    public void update(Auditoria entity) {
        dao.update(entity);
    }

    public void delete(Auditoria entity) {
        dao.delete(entity);
    }
    
    public Auditoria findById(Integer id) {
        return dao.findById(id);
    }

    public List<Auditoria> find() {
        return dao.find(new Auditoria());
    }
    
    public List<Auditoria> find(Auditoria entity) {
        return dao.find(entity);
    }
    
    public void arquivarAuditoria(String dataInicial, String dataFinal) {
        dao.arquivarAuditoria(dataInicial, dataFinal);
    }
    
}
