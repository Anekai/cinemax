
package services;

import daos.GeneroDAO;
import entities.Genero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GeneroService {
    
    @Autowired
    GeneroDAO dao;

    public void insert(Genero entity) {
        dao.insert(entity);
    }

    public void update(Genero entity) {
        dao.update(entity);
    }

    public void delete(Genero entity) {
        dao.delete(entity);
    }
    
    public Genero findById(Integer id) {
        return dao.findById(id);
    }

    public List<Genero> find() {
        return dao.find(new Genero());
    }
    
    public List<Genero> find(Genero entity) {
        return dao.find(entity);
    }
    
}
