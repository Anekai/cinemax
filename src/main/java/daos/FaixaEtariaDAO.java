
package daos;

import entities.FaixaEtaria;
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
public class FaixaEtariaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(FaixaEtaria entity) {
        em.persist(entity);
    }

    public void update(FaixaEtaria entity) {
        em.merge(entity);
    }

    public void delete(FaixaEtaria entity) {
        em.remove(entity);
    }
    
    public FaixaEtaria findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(FaixaEtaria.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (FaixaEtaria)criteria.uniqueResult();
    }
    
    public List<FaixaEtaria> find(FaixaEtaria entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(FaixaEtaria.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
