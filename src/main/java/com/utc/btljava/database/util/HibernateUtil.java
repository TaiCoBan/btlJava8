package com.utc.btljava.database.util;

import com.utc.btljava.database.entity.Account;
import com.utc.btljava.database.entity.Achievement;
import com.utc.btljava.database.entity.base.BaseEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
  
  private static final String DEFAULT_RESOURCE = "hibernate.cfg.xml";
//  private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
  
  private static SessionFactory buildSessionFactory(String resource) {
    try {
      Configuration configuration = new Configuration();
      configuration.addAnnotatedClass(BaseEntity.class);
      configuration.addAnnotatedClass(Account.class);
      configuration.addAnnotatedClass(Achievement.class);
      
      configuration.configure(resource);
//      LOGGER.debug("Hibernate Annotation Configuration loaded");
      
      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                                                .build();
//      LOGGER.debug("Hibernate Annotation serviceRegistry created");
      
      return configuration.buildSessionFactory(serviceRegistry);
    } catch (Throwable ex) {
//      LOGGER.error("Initial SessionFactory creation failed.", ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  public static SessionFactory getSessionFactory() {
    return buildSessionFactory(DEFAULT_RESOURCE);
  }
  
  public static SessionFactory getSessionFactory(String resource) {
    return buildSessionFactory(resource);
  }
}