
package services;

import daos.FilmeDAO;
import entities.Filme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FilmeService {
    
    @Autowired
    FilmeDAO dao;

    public void insert(Filme entity) {
        dao.insert(entity);
    }

    public void update(Filme entity) {
        dao.update(entity);
    }

    public void delete(Filme entity) {
        dao.delete(entity);
    }
    
    public Filme findById(Integer id) {
        return dao.findById(id);
    }

    public List<Filme> find() {
        return dao.find(new Filme());
    }
    
    public List<Filme> find(Filme entity) {
        return dao.find(entity);
    }
    
}
