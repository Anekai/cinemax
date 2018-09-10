
package daos;

import configuration.ParamConfig;
import entities.ParametroGenerico;
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
public class ParametroGenericoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(ParametroGenerico entity) {
        em.persist(entity);
    }

    public void update(ParametroGenerico entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(ParametroGenerico entity) {
        em.remove(entity);
    }
    
    public ParametroGenerico findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(ParametroGenerico.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (ParametroGenerico)criteria.uniqueResult();
    }
    
    public List<ParametroGenerico> find(ParametroGenerico entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(ParametroGenerico.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
