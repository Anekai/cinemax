package services;

import daos.ProdutoDAO;
import entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoService {
 
    @Autowired
    ProdutoDAO dao;

    public void insert(Produto entity) {
        dao.insert(entity);
    }

    public void update(Produto entity) {
        dao.update(entity);
    }

    public void delete(Produto entity) {
        dao.delete(entity);
    }
    
    public Produto findById(Integer id) {
        return dao.findById(id);
    }

    public List<Produto> find() {
        return dao.find(new Produto());
    }
    
    public List<Produto> find(Produto entity) {
        return dao.find(entity);
    }

}
