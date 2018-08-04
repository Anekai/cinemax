package daos;

import entities.Funcionario;
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
public class UsuarioDAO {
 
    @PersistenceContext
    private EntityManager em;

    public void insert(Funcionario usuario) {
        em.persist(usuario);
    }

    public void update(Funcionario usuario) {
        em.merge(usuario);
    }

    public void delete(Funcionario usuario) {
        em.remove(usuario);
    }

    public List<Funcionario> find(Funcionario usuario) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Funcionario.class);
        
        criteria.add(Example.create(usuario));
        
        if (usuario.getId() != null) {
            criteria.add(Restrictions.eq("id", usuario.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }

    public Funcionario loginUsuario( String login, String senha ) {
        Funcionario entity = new Funcionario();

        entity.setLogin(login);
        entity.setSenha(senha);

        return (Funcionario)((Session)em.getDelegate()).createCriteria(Funcionario.class).add(Example.create(entity)).uniqueResult();
    }

}
