
package services;

import daos.PermissaoDAO;
import entities.Permissao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PermissaoService {
    
    @Autowired
    PermissaoDAO dao;

    public void insert(Permissao entity) {
        dao.insert(entity);
    }

    public void update(Permissao entity) {
        dao.update(entity);
    }

    public void delete(Permissao entity) {
        dao.delete(entity);
    }
    
    public Permissao findById(Integer id) {
        return dao.findById(id);
    }

    public List<Permissao> find() {
        return dao.find(new Permissao());
    }
    
    public List<Permissao> find(Permissao entity) {
        return dao.find(entity);
    }
    
}
