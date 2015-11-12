package util;

import controller.HibernateUtil;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;


public class QueryDataModel<T> extends LazyDataModel<T> {
    
    private String jpql;
    
    public QueryDataModel(String jpql, String jpqlCount){
        
        this.jpql = jpql;
        
        Long count = (Long) HibernateUtil.getSessionFactory().getCurrentSession().createQuery(jpqlCount).uniqueResult();
    
        setRowCount(count.intValue());
    }
    
    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters){

        return HibernateUtil.getSessionFactory().getCurrentSession().createQuery(jpql)
                .setFirstResult(first)
                .setMaxResults(pageSize)
                .list();
    }
    
}
