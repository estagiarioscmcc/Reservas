/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controller.HibernateUtil;
import java.util.List;
import javax.ejb.Stateless;
import model.Docente;
import model.Sala;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author charles
 */
@Stateless
public class SalaFacade extends AbstractFacade<Sala>{
    
   
    @Override
    protected SessionFactory getSessionFactory() {
        return HibernateUtil.getSessionFactory();
    }
    
    
    public SalaFacade(){
        super(Sala.class);
    }
    
    //Retorna todas as salas com excessão de alguma(s)
    public List<Sala> findAllExcept(String sala){
        Session session = getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sala.class);
        criteria.add(Restrictions.ne("numero", sala)); 
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List results = criteria.list();
        session.close();
        
        return results;        
    }
}
