package rest.service;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

abstract class Service<T> implements RestService<T> {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public List getAll(Class clazz) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(clazz);
        return criteria.list();
    }

    @Transactional
    @Override
    public T getById(Class clazz, String id) {
        Session session = sessionFactory.getCurrentSession();
        T item = (T) session.byId(clazz).load(id);
        return item;
    }

    @Transactional
    @Override
    public T create(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        return  entity;
    }

    @Transactional
    @Override
    public T update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        return  entity;
    }
}
