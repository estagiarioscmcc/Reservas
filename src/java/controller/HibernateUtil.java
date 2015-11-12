/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
//            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
             sessionFactory = configuration.buildSessionFactory(ssrb.build());
            Session session = sessionFactory.openSession();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
//    public static Statistics getStatistics() {
//        if (!sessionFactory.getStatistics().isStatisticsEnabled()) {
//            sessionFactory.getStatistics().setStatisticsEnabled(true);
//        }
//        return sessionFactory.getStatistics();
//    }
//    
//    public static void printStatistics(){
//        
//        Statistics stats = getStatistics();
//        
//        System.out.println("Qtd. de entidades buscadas: " + stats.getEntityFetchCount());
//        System.out.println("Qtd. de entidades carregas: " + stats.getEntityLoadCount());
//        System.out.println("Qtd. de listas buscadas: " + stats.getCollectionFetchCount());
//        System.out.println("Qtd. de listas carregadas: " + stats.getCollectionLoadCount());
//        
//        double queryCacheHitCount = stats.getQueryCacheHitCount();
//        double queryCacheMissCount = stats.getQueryCacheMissCount();
//        double totalQueries = queryCacheHitCount + queryCacheMissCount;
//        double queryCacheHitRatio = (totalQueries == 0) ? 0 : queryCacheHitCount / totalQueries;
//        
//        System.out.println("Qtd. de consultas encontradas no cache: " + queryCacheHitCount);
//        System.out.println("Qtd. de consultas fora do cache: " + queryCacheMissCount);
//        System.out.println("Proporção de acerto do cache: " + queryCacheHitRatio);
//        System.out.println("Qtd. de consultas executadas: " + stats.getQueryExecutionCount());
//        
//        String[] queries = stats.getQueries();
//        for(int i = 0; i < queries.length; i++){
//            System.out.println("Consulta " + i + ": " + queries[i]);
//        }
//        
//        System.out.println("Query mais lenta: " + stats.getQueryExecutionMaxTimeQueryString());
//    }
}
