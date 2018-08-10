
package services;

import daos.SalaDAO;
import entities.Sala;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalaService {
    
    @Autowired
    SalaDAO dao;

    public void insert(Sala entity) {
        dao.insert(entity);
    }

    public void update(Sala entity) {
        dao.update(entity);
    }

    public void delete(Sala entity) {
        dao.delete(entity);
    }
    
    public Sala findById(Integer id) {
        return dao.findById(id);
    }

    public List<Sala> find() {
        return dao.find(new Sala());
    }
    
    public List<Sala> find(Sala entity) {
        return dao.find(entity);
    }
    
}
