package com.utc.btljava.database.service.base;

import com.utc.btljava.database.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T> implements BaseService<T> {
  private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  private final Session session = sessionFactory.openSession();
  private final Class<T> clazz;
  
  public BaseServiceImpl(Class<T> clazz) {
    this.clazz = clazz;
  }
  
  @Override
  public T create(T t) {
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      
      session.save(t);
      
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return t;
  }
  
  @Override
  public Optional<T> findById(int id) {
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      
      T t = session.get(clazz, id);
      
      if (t != null) {
        transaction.commit();
        return Optional.of(t);
      }
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return Optional.empty();
  }
  
  @Override
  public List<T> findAll() {
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
      
      List<T> list = session.createQuery("FROM " + clazz.getSimpleName(), clazz).list();
      
      transaction.commit();
      return list;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return null;
  }
  
  @Override
  public T update(T t) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.update(t);
      transaction.commit();
      
      return t;
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return null;
  }
  
  @Override
  public void deleteById(int id) {
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      T t = session.get(clazz, id);
      if (t != null) {
        session.delete(t);
      }
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }
  
  public Optional<T> findByField(String fieldName, Object value) {
    Transaction transaction = null;
    try {
      transaction = session.beginTransaction();
  
      String queryString = "FROM " + clazz.getSimpleName() + " WHERE " + fieldName + " = :value";
      T result = session.createQuery(queryString, clazz)
        .setParameter("value", value)
        .uniqueResult();
  
      transaction.commit();
      return Optional.ofNullable(result);
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
    return Optional.empty();
  }
}
