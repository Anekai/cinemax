
package daos;

import configuration.ParamConfig;
import entities.AcaoTela;
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
public class AcaoTelaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(AcaoTela entity) {
        em.persist(entity);
    }

    public void update(AcaoTela entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(AcaoTela entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public AcaoTela findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(AcaoTela.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (AcaoTela)criteria.uniqueResult();
    }
    
    public List<AcaoTela> find(AcaoTela entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(AcaoTela.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
