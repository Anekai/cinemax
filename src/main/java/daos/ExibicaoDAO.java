
package daos;

import configuration.ParamConfig;
import entities.Exibicao;
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
public class ExibicaoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Exibicao entity) {
        em.persist(entity);
    }

    public void update(Exibicao entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Exibicao entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public Exibicao findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Exibicao.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Exibicao)criteria.uniqueResult();
    }
    
    public List<Exibicao> find(Exibicao entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Exibicao.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
