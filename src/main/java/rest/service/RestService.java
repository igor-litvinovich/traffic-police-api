package rest.service;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RestService<T> {
    List<T> getAll(Class<T> clazz);
    T getById(Class<T> clazz, String id);
    T create(T entity);
    T update(T entity);
}
