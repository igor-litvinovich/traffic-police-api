package rest.service;

import org.hibernate.criterion.Criterion;
import rest.request.RequestParams;

import java.util.List;


public interface RestService<T> {
    List<T> getAll(Class<T> clazz);
    T getById(Class<T> clazz, String id);
    T create(T entity);
    T update(T entity);
    T delete(Class clazz,String id);
    T findWithCriteria(Class<T> tClass, final Criterion... criterionArray);
    List<T> filterEntities(RequestParams requestParams, Class<T> tClass);
}
