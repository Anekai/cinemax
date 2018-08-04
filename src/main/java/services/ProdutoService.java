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
    ProdutoDAO produtoDAO;

    public void insert(Produto produto) {
        produtoDAO.insert(produto);
    }

    public void update(Produto produto) {
        produtoDAO.update(produto);
    }

    public void delete(Produto produto) {
        produtoDAO.delete(produto);
    }
    
    public Produto findById(Integer id) {
        return produtoDAO.findById(id);
    }

    public List<Produto> find() {
        return produtoDAO.find(new Produto());
    }
    
    public List<Produto> find(Produto produto) {
        return produtoDAO.find(produto);
    }

}
