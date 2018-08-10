
package daos;

import entities.Sessao;
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
public class SessaoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Sessao entity) {
        em.persist(entity);
    }

    public void update(Sessao entity) {
        em.merge(entity);
    }

    public void delete(Sessao entity) {
        em.remove(entity);
    }
    
    public Sessao findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Sessao.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Sessao)criteria.uniqueResult();
    }
    
    public List<Sessao> find(Sessao entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Sessao.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
