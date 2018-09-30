
package services;

import daos.TelaDAO;
import entities.Tela;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TelaService {
    
    @Autowired
    TelaDAO dao;

    public void insert(Tela entity) {
        dao.insert(entity);
    }

    public void update(Tela entity) {
        dao.update(entity);
    }

    public void delete(Tela entity) {
        dao.delete(entity);
    }
    
    public Tela findById(Integer id) {
        return dao.findById(id);
    }

    public List<Tela> find() {
        return dao.find(new Tela());
    }
    
    public List<Tela> find(Tela entity) {
        return dao.find(entity);
    }
    
}
