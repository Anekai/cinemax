package daos;

import configuration.ParamConfig;
import entities.Produto;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Repository
public class ProdutoDAO {
 
    @PersistenceContext
    private EntityManager em;

    public void insert(Produto entity) {
        em.persist(entity);
    }

    public void update(Produto entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Produto entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public Produto findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Produto.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Produto)criteria.uniqueResult();
    }
    
    public List<Produto> find(Produto entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Produto.class);
        
        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }

}
