
package services;

import daos.FaixaEtariaDAO;
import entities.FaixaEtaria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FaixaEtariaService {
    
    @Autowired
    FaixaEtariaDAO dao;

    public void insert(FaixaEtaria entity) {
        dao.insert(entity);
    }

    public void update(FaixaEtaria entity) {
        dao.update(entity);
    }

    public void delete(FaixaEtaria entity) {
        dao.delete(entity);
    }
    
    public FaixaEtaria findById(Integer id) {
        return dao.findById(id);
    }

    public List<FaixaEtaria> find() {
        return dao.find(new FaixaEtaria());
    }
    
    public List<FaixaEtaria> find(FaixaEtaria entity) {
        return dao.find(entity);
    }
    
}
