
package services;

import daos.ParametroGenericoDAO;
import entities.ParametroGenerico;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ParametroGenericoService {
    
    @Autowired
    ParametroGenericoDAO dao;

    public void insert(ParametroGenerico entity) {
        dao.insert(entity);
    }

    public void update(ParametroGenerico entity) {
        dao.update(entity);
    }

    public void delete(ParametroGenerico entity) {
        dao.delete(entity);
    }
    
    public ParametroGenerico findById(Integer id) {
        return dao.findById(id);
    }

    public List<ParametroGenerico> find() {
        return dao.find(new ParametroGenerico());
    }
    
    public List<ParametroGenerico> find(ParametroGenerico entity) {
        return dao.find(entity);
    }
    
    public ParametroGenerico findGerarAuditoria() {
        ParametroGenerico entity = new ParametroGenerico();
        
        entity.setNome("GERAR_AUDITORIA");
        
        List<ParametroGenerico> result = dao.find(entity);
        
        if ( CollectionUtils.isNotEmpty(result) ) {
            return result.get(0);
        } else {
            return null;
        }
    }
    
}
