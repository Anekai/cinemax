
package daos;

import configuration.ParamConfig;
import entities.Permissao;
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
public class PermissaoDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Permissao entity) {
        em.persist(entity);
    }

    public void update(Permissao entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Permissao entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public Permissao findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Permissao.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Permissao)criteria.uniqueResult();
    }
    
    public List<Permissao> find(Permissao entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Permissao.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
}
