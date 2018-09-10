
package daos;

import configuration.ParamConfig;
import entities.Genero;
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
public class GeneroDAO {

    @PersistenceContext
    private EntityManager em;

    public void insert(Genero entity) {
        em.persist(entity);
    }

    public void update(Genero entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Genero entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public Genero findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Genero.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Genero)criteria.uniqueResult();
    }
    
    public List<Genero> find(Genero entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Genero.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
