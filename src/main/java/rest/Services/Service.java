package rest.Services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

abstract class Service<T> implements RestService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List getAll(Class clazz) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(clazz);
        return criteria.list();
    }
}
