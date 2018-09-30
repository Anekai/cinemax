
package services;

import daos.AcaoDAO;
import entities.Acao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AcaoService {
    
    @Autowired
    AcaoDAO dao;

    public void insert(Acao entity) {
        dao.insert(entity);
    }

    public void update(Acao entity) {
        dao.update(entity);
    }

    public void delete(Acao entity) {
        dao.delete(entity);
    }
    
    public Acao findById(Integer id) {
        return dao.findById(id);
    }

    public List<Acao> find() {
        return dao.find(new Acao());
    }
    
    public List<Acao> find(Acao entity) {
        return dao.find(entity);
    }
    
}
