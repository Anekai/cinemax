
package services;

import daos.CargoAcaoTelaDAO;
import entities.CargoAcaoTela;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CargoAcaoTelaService {
    
    @Autowired
    CargoAcaoTelaDAO dao;

    public void insert(CargoAcaoTela entity) {
        dao.insert(entity);
    }

    public void update(CargoAcaoTela entity) {
        dao.update(entity);
    }

    public void delete(CargoAcaoTela entity) {
        dao.delete(entity);
    }
    
    public CargoAcaoTela findById(Integer id) {
        return dao.findById(id);
    }

    public List<CargoAcaoTela> find() {
        return dao.find(new CargoAcaoTela());
    }
    
    public List<CargoAcaoTela> find(CargoAcaoTela entity) {
        return dao.find(entity);
    }
    
}
