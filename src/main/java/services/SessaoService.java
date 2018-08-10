
package services;

import daos.SessaoDAO;
import entities.Sessao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SessaoService {
    
    @Autowired
    SessaoDAO dao;

    public void insert(Sessao entity) {
        dao.insert(entity);
    }

    public void update(Sessao entity) {
        dao.update(entity);
    }

    public void delete(Sessao entity) {
        dao.delete(entity);
    }
    
    public Sessao findById(Integer id) {
        return dao.findById(id);
    }

    public List<Sessao> find() {
        return dao.find(new Sessao());
    }
    
    public List<Sessao> find(Sessao entity) {
        return dao.find(entity);
    }
    
}
