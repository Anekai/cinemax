
package daos;

import configuration.ParamConfig;
import entities.Sala;
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
public class SalaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Sala entity) {
        em.persist(entity);
    }

    public void update(Sala entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Sala entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public Sala findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Sala.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Sala)criteria.uniqueResult();
    }
    
    public List<Sala> find(Sala entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Sala.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
