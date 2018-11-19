
package daos;

import configuration.ParamConfig;
import entities.Auditoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public class AuditoriaDAO {
    
    @PersistenceContext
    private EntityManager em;

    public void insert(Auditoria entity) {
        em.persist(entity);
    }

    public void update(Auditoria entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.merge(entity);
    }

    public void delete(Auditoria entity) {
        ParamConfig config = new ParamConfig();
        em.createNativeQuery("SET LOCAL \"usuario.logado\" = '" + config.getFuncionarioLogado().getNome() + " " + config.getFuncionarioLogado().getSobreNome() + "' ").executeUpdate();
        em.remove(entity);
    }
    
    public Auditoria findById(Integer id) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Auditoria.class);
        
        criteria.add(Restrictions.eq("id", id));
        
        return (Auditoria)criteria.uniqueResult();
    }
    
    public List<Auditoria> find(Auditoria entity) {
        Criteria criteria = ((Session)em.getDelegate()).createCriteria(Auditoria.class);

        criteria.add(Example.create(entity));
        
        if (entity.getId() != null) {
            criteria.add(Restrictions.eq("id", entity.getId()));
        }
        
        criteria.addOrder(Order.asc("id"));
        
        return criteria.list();
    }
    
    public void arquivarAuditoria(String dataInicial, String dataFinal) {
//        StoredProcedureQuery query = em.createStoredProcedureQuery("arquivar_auditoria");
        
//        query.registerStoredProcedureParameter("dt_inicial", String.class, ParameterMode.IN);
//        query.registerStoredProcedureParameter("dt_final", String.class, ParameterMode.IN);
//        query.setParameter("dt_inicial", dataInicial);
//        query.setParameter("dt_final", dataFinal);

//        query.executeUpdate();

        //ProcedureCall statement = ((Session)em.getDelegate()).createStoredProcedureCall("arquivar_auditoria");
        //statement.registerParameter(1, String.class, ParameterMode.IN).bindValue(dataInicial);
        //statement.registerParameter(2, String.class, ParameterMode.IN).bindValue(dataFinal);
        //statement.executeUpdate();
        
        
        Session session = ((Session)em.getDelegate());
                
        session.doWork(new Work() {

        @Override
        public void execute(Connection connection) throws SQLException {

            CallableStatement cs = connection.prepareCall("{call arquivar_auditoria(?,?)}");
            cs.setString(1, dataInicial);
            cs.setString(2, dataFinal);

            try {
                cs.execute();
            } catch (Exception e) {
                throw e;
            } finally {
                cs.close();
            }
        }

    });
    }
    
}
