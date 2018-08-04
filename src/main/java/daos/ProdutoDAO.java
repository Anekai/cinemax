package daos;

import entities.Produto;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Repository
public class ProdutoDAO {
 
    @PersistenceContext
    private EntityManager em;

    public void insert(Produto produto) {
        em.persist(produto);
    }

    public void update(Produto produto) {
        em.merge(produto);
    }

    public void delete(Produto produto) {
        em.remove(produto);
    }
    
    public Produto findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Produto.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Produto)criteria.uniqueResult();
    }
    
    public List<Produto> find(Produto produto) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Produto.class);
        
        criteria.add(Example.create(produto));
        
        if (produto.getId() != null) {
            criteria.add(Restrictions.eq("id", produto.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }

}
