
package daos;

import configuration.ParamConfig;
import entities.Cargo;
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
public class CargoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Cargo entity) {
        em.persist(entity);
    }

    public void update(Cargo entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Cargo entity) {
        em.remove(entity);
    }
    
    public Cargo findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Cargo.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Cargo)criteria.uniqueResult();
    }
    
    public List<Cargo> find(Cargo entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Cargo.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
