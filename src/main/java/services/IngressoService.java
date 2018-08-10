
package services;

import daos.IngressoDAO;
import entities.Ingresso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IngressoService {

    @Autowired
    IngressoDAO dao;

    public void insert(Ingresso entity) {
        dao.insert(entity);
    }

    public void update(Ingresso entity) {
        dao.update(entity);
    }

    public void delete(Ingresso entity) {
        dao.delete(entity);
    }
    
    public Ingresso findById(Integer id) {
        return dao.findById(id);
    }

    public List<Ingresso> find() {
        return dao.find(new Ingresso());
    }
    
    public List<Ingresso> find(Ingresso entity) {
        return dao.find(entity);
    }
    
}
