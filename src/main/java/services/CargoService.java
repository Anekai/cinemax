
package services;

import daos.CargoDAO;
import entities.Cargo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CargoService {
    
    @Autowired
    CargoDAO dao;

    public void insert(Cargo entity) {
        dao.insert(entity);
    }

    public void update(Cargo entity) {
        dao.update(entity);
    }

    public void delete(Cargo entity) {
        dao.delete(entity);
    }
    
    public Cargo findById(Integer id) {
        return dao.findById(id);
    }

    public List<Cargo> find() {
        return dao.find(new Cargo());
    }
    
    public List<Cargo> find(Cargo entity) {
        return dao.find(entity);
    }
    
}
