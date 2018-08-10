
package daos;

import entities.Diretor;
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
public class DiretorDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Diretor entity) {
        em.persist(entity);
    }

    public void update(Diretor entity) {
        em.merge(entity);
    }

    public void delete(Diretor entity) {
        em.remove(entity);
    }
    
    public Diretor findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Diretor.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Diretor)criteria.uniqueResult();
    }
    
    public List<Diretor> find(Diretor entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Diretor.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
