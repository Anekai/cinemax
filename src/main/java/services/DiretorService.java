
package services;

import daos.DiretorDAO;
import entities.Diretor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiretorService {
    
    @Autowired
    DiretorDAO dao;

    public void insert(Diretor entity) {
        dao.insert(entity);
    }

    public void update(Diretor entity) {
        dao.update(entity);
    }

    public void delete(Diretor entity) {
        dao.delete(entity);
    }
    
    public Diretor findById(Integer id) {
        return dao.findById(id);
    }

    public List<Diretor> find() {
        return dao.find(new Diretor());
    }
    
    public List<Diretor> find(Diretor entity) {
        return dao.find(entity);
    }
    
}
