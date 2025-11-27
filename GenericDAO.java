package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.io.Serializable;
import java.util.List;

public abstract class GenericDAO<T> {

    protected Session session;
    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public void insert(T entity) {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void update(T entity) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(entity);
        session.getTransaction().commit();
    }

    public void delete(T entity) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public T buscarPorCodigo(Serializable id) {
        session.beginTransaction();
        T entity = (T) session.get(entityClass, id);
        session.getTransaction().commit();
        return entity;
    }

    public List<T> listar() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(entityClass);
        List<T> entities = criteria.list();
        session.getTransaction().commit();
        return entities;
    }
}
