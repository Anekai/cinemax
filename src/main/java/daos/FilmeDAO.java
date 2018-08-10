
package daos;

import entities.Filme;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class FilmeDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Filme entity) {
        em.persist(entity);
    }

    public void update(Filme entity) {
        em.merge(entity);
    }

    public void delete(Filme entity) {
        em.remove(entity);
    }
    
    public Filme findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Filme.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Filme)criteria.uniqueResult();
    }
    
    public List<Filme> find(Filme entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Filme.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
