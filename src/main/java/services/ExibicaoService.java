
package services;

import daos.ExibicaoDAO;
import entities.Exibicao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExibicaoService {
    
    @Autowired
    ExibicaoDAO dao;

    public void insert(Exibicao entity) {
        dao.insert(entity);
    }

    public void update(Exibicao entity) {
        dao.update(entity);
    }

    public void delete(Exibicao entity) {
        dao.delete(entity);
    }
    
    public Exibicao findById(Integer id) {
        return dao.findById(id);
    }

    public List<Exibicao> find() {
        return dao.find(new Exibicao());
    }
    
    public List<Exibicao> find(Exibicao entity) {
        return dao.find(entity);
    }
    
}
