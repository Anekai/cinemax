
package daos;

import configuration.ParamConfig;
import entities.Tela;
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
public class TelaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Tela entity) {
        em.persist(entity);
    }

    public void update(Tela entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Tela entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public Tela findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Tela.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Tela)criteria.uniqueResult();
    }
    
    public List<Tela> find(Tela entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Tela.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
