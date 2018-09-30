
package services;

import daos.AcaoTelaDAO;
import entities.AcaoTela;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AcaoTelaService {
    
    @Autowired
    AcaoTelaDAO dao;

    public void insert(AcaoTela entity) {
        dao.insert(entity);
    }

    public void update(AcaoTela entity) {
        dao.update(entity);
    }

    public void delete(AcaoTela entity) {
        dao.delete(entity);
    }
    
    public AcaoTela findById(Integer id) {
        return dao.findById(id);
    }

    public List<AcaoTela> find() {
        return dao.find(new AcaoTela());
    }
    
    public List<AcaoTela> find(AcaoTela entity) {
        return dao.find(entity);
    }
    
}
